import { React, useEffect } from 'react'
import { useLocation } from 'react-router-dom'
import useGameStore from '../store/useGameStore'

export function PlayView() {
    const location = useLocation()

    /*Create quick access setSession function from game store, as well as setActiveSessionToken, without these I'd have to type out
    * useGameStore(state => state.session)(state.session), every time I wanted to use it. See easier implementation below.*/
    const setSession = useGameStore(state => state.setSession)

    const session = useGameStore(state => state.session) //Pull session from the global store

    useEffect(() => {
        //This is saying, if we have a state session from our React Router, then look into it...
        if (location.state?.session) {
            //...and then set the values in the global store equal to the values in the React Router state
            setSession(location.state.session) //This is where we're calling the global store functions above to set the values on page load
        }
    }, [])

    return(
        <div>
        <h1>Play View</h1>
        <br/>
        <br/>
        <div id="sessionInfoDisplay">
            <p>Game Code: {session?.name}</p>
            <p>Session ID: {session?.id}</p>
            <p>Session Code: {session?.sessionCode}</p>
        </div>
        </div>
    );
}

export default PlayView;