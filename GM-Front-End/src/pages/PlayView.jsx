import React from 'react'
import { useLocation } from 'react-router-dom'

export function PlayView() {
    const location = useLocation()
    const session = location.state?.session

    return(
        <div>
        <h1>Play View</h1>
        <br/>
        <br/>
        <div id="sessionInfoDisplay">
            <p>Game Code: {session?.sessionCode}</p>
            <p>Session ID: {session?.id}</p>
            <p>Session Code: {session?.sessionCode}</p>
        </div>
        </div>
    );
}

export default PlayView;