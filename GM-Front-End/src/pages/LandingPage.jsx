import { useState} from 'react';
import { useNavigate } from 'react-router-dom';

export function LandingPage() {
    //Variables for form submission
    const [gameName, setGameName] = useState('')
    const [sessionCode, setSessionCode] = useState('') //Added for session code search
    const [player1, setPlayer1] = useState('')
    const [player2, setPlayer2] = useState('')
    const navigate = useNavigate();

    //function to handle game create api call
    const handleCreateGame = async () => {
        try {
            //Create a session first
            const response = await fetch(`${import.meta.env.VITE_API_BASE_URL}/api/game-sessions/create`, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json'},
                body: JSON.stringify({ name: gameName, status: 'active'})
            })

            if(!response.ok)
            {
                throw new Error(`API Request Error creating session: ${response.status} - ${response.statusText}`)
            }

            const session = await response.json()

            //Then create player 1
            await fetch(`${import.meta.env.VITE_API_BASE_URL}/api/players`, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ sessionId: session.id, displayName: player1, isGameMaster: false, turnOrder: 1 })
            })

            if(!response.ok)
            {
                throw new Error(`API Request Error creating player 1: ${response.status} - ${response.statusText}`)
            }

            //And 2
            await fetch(`${import.meta.env.VITE_API_BASE_URL}/api/players`, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ sessionId: session.id, displayName: player2, isGameMaster: false, turnOrder: 2 })
            })

            if(!response.ok)
            {
                throw new Error(`API Request Error createing player 2: ${response.status} - ${response.statusText}`)
            }

            console.log(session); //Log response
            //After the game session is created, we navigate to the /play view to render the game session
            navigate('/play', { state: { session } })
        }
        catch(error) {
            console.log(error.message)
        }
    }

    const handleLoadGame = async () => {
        try {
            //Create a session first
            const response = await fetch(`${import.meta.env.VITE_API_BASE_URL}/api/game-sessions/${sessionCode}/load`, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' } //No body because the session code is passed as a URL parameter
            })

            if(!response.ok)
            {
                throw new Error(`API Request Error loading pre-existing session: ${response.status} - ${response.statusText}`)
            }

            const data = await response.json() //response data containing the session and the latest save state blob

            const session = data.session
            const latestStateBlob = data.latestStateBlob

            //We fetch players separately because they're not returned with the session. This could be setup as an @JsonManagedReference playerList in GameSession, and @JsonBackReference on gameSession in Player, but for now this is less work
            const playersResponse = await fetch (`${import.meta.env.VITE_API_BASE_URL}/api/players/game/${sessionCode}`, {
                method: 'GET',
            })

            if(!playersResponse.ok)
            {
                throw new Error(`API Request Error loading players associated with pre-existing session: ${response.status} - ${response.statusText}`)
            }

            const players = await playersResponse.json()
            
            //Then navigate to the /play view to render the loaded game session
            console.log(players)
            console.log(session)
            navigate('/play', { state: { session, players, latestStateBlob } })
        }
        catch(error) {
            console.log(error.message)
        }

        
    }


    return(
        <div>
            <h1>Load Game</h1>
            <br/>
            <br/>
            <div>
                <label>Session code: </label>
                <input
                    type="text"
                    value={sessionCode}
                    onChange={e => setSessionCode(e.target.value)}
                    placeholder="Enter a session code here to load a game..."
                    style={{width:'25%', marginRight: '8px'}}
                    />
                <button onClick={handleLoadGame}>Load Game</button>
            </div>
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