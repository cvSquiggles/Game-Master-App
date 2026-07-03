import { useEffect, useCallback } from 'react'
import { useLocation } from 'react-router-dom'
import { useSelector, useDispatch } from 'react-redux' //Import useSelector (used to read state) and useDispatch (used to trigger state changes, rather than calling setters directly)
import { setSession, setPlayers } from '../store/store'
import ScoreTracker from '../components/ScoreTracker'

export function PlayView() {
    const location = useLocation()
    const dispatch = useDispatch() //variable used to trigger state changes

    //Converted zustand store to redux, these allow easy access to the session and players states in the redux store
    const setSession = useSelector(state => state.game.session) //state.slice-name.state-variable
    const setPlayers = useSelector(state => state.game.players)
    
    //Removed lines pulling setters from the zustand store, redux doesn't require pulling the setters directly

    //This should load the players associated with the current game
    const loadPlayers = async () => {
        const response = await fetch(`${import.meta.env.VITE_API_BASE_URL}/api/players/game/${location.state.session.sessionCode}`, {
            method: 'GET',
        })

        const data = await response.json()
        dispatch(setPlayers(data)) //Replaced zustand setter call with redux dispatch setter
    }

    //This is a function that will be used to handle both manual and auto saves, added "useCallBack" so the function isn't recreated on every render of this component, bug was creating thousands of saves!
    const saveGame = useCallback(async () => {
        console.log("Attempting save")
        const response = await fetch(`${import.meta.env.VITE_API_BASE_URL}/api/game-sessions/${location.state.session.sessionCode}/save`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json'},
            body: JSON.stringify({
                    activeSessionToken: session.activeSessionToken,
                    stateBlob: JSON.stringify({ session, players})
                })
        })
    }, [session, players])

    useEffect(() => {
        //This is saying, if we have a state session from our React Router, then look into it...
        if (location.state?.session) {
            //...and then set the values in the global store equal to the values in the React Router state
            dispatch(setSession(location.state.session)) //This is where we're calling the global store functions above to set the values on page load ~updated to redux dispatch setter
            loadPlayers()
        }
    }, [])

    useEffect(() => {
        //This is an auto-save trigger defaulted to save the game state once every minute (TODO: customizable save interval later)
        const interval = setInterval(saveGame, 60000)
        return () => clearInterval(interval)
    }, [saveGame])

    return(
        <div>
            <h1>Play View</h1>
            <br/>
            <br/>
            <div id="sessionInfoDisplay">
                <p>Game Code: {session?.name} <button onClick={saveGame}>Save Game</button></p>
                <p>Session ID: {session?.id}</p>
                <p>Session Code: {session?.sessionCode}</p>
                <div id="playerCards">
                    {players.map(player => (
                        <div key={player.id}>
                            <p>Player {player.turnOrder}: {player.displayName}</p>
                        </div>
                    ))}
                </div>
                <br/>
                <br/>
                {players.length > 0 && <ScoreTracker player={players[0]} />}
            </div>
        </div>
    );
}

export default PlayView;