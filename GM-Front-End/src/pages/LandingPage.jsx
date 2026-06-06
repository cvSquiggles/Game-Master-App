import { useState} from 'react';
import { useNavigate } from 'react-router-dom';

export function LandingPage() {
    //Variables for form submission
    const [gameName, setGameName] = useState('')
    const [player1, setPlayer1] = useState('')
    const [player2, setPlayer2] = useState('')
    const navigate = useNavigate();

    //function to handle game create api call
    const handleCreateGame = async () => {
        //Create a session first
        const response = await fetch(`${import.meta.env.VITE_API_BASE_URL}/api/game-sessions/create`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json'},
            body: JSON.stringify({ name: gameName, status: 'active'})
        })

        const session = await response.json()

        //Then create player 1
        await fetch(`${import.meta.env.VITE_API_BASE_URL}/api/players`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ sessionId: session.id, displayName: player1, isGameMaster: false, turnOrder: 1 })
        })

        //And 2
        await fetch(`${import.meta.env.VITE_API_BASE_URL}/api/players`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ sessionId: session.id, displayName: player2, isGameMaster: false, turnOrder: 2 })
        })

        console.log(session); //Log response
        //After the game session is created, we navigate to the /play view to render the game session
        navigate('/play', { state: { session } })
    }


    return(
        <div>
            <h1>Load Game</h1>
            <br/>
            <br/>
            <div>Place holder for game session code search</div>
            <br/>
            <br/>
            <hr/>
            <br/>
            <br/>
            <h1>Create Game</h1>
            <div id="newGameDiv">
                <label>Game Name: </label>
                <input
                    type="text"
                    value={gameName}
                    onChange={e => setGameName(e.target.value)}
                    placeholder="Game name here..."
                    /> <br/>
                <label>Player 1 Name: </label>
                <input
                    type="text"
                    value={player1}
                    onChange={e => setPlayer1(e.target.value)}
                    placeholder="Player 1 name here..."
                    /> <br/>
                <label>Player 2 Name: </label>
                <input
                    type="text"
                    value={player2}
                    onChange={e => setPlayer2(e.target.value)}
                    placeholder="Player 2 name here..."
                    /> <br/>
                <button onClick={handleCreateGame}>Create Game</button>
            </div>
        </div>
    );
}

export default LandingPage;