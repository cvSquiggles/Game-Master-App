import useGameStore from '../store/useGameStore'

function ScoreTracker({ player }) {

    const scores = useGameStore(state => state.scores)
    const setScore = useGameStore(state => state.setScore)

    //If we don't have a value, default to 0 hard coded for now
    const currentScore = scores[player.id] ?? 0

    const handlePreset = (amount) => {
        setScore(player.id, currentScore + amount)
    }

    return (
        <div className="score-card">
            <h2 className="player-name">{player.displayName}</h2>
            <p className="current-score">{currentScore}</p>
            <div className="preset-buttons">
                {[-5, -2, 2, 5].map(amount => (
                    <button 
                        key={amount}
                        className="preset-btn"
                        onClick={() => handlePreset(amount)}
                    >
                        {amount > 0 ? `+${amount}` : amount}
                    </button>
                ))}
            </div>
        </div>
    )

}

export default ScoreTracker