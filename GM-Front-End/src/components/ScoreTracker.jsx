import { useSelector, useDispatch } from 'react-redux'
import { useState } from 'react'
import { setScore } from '../store/store'
import './ScoreTracker.css'

function ScoreTracker({ player }) {
    const dispatch = useDispatch()

    const scores = useSelector(state => state.game.scores) //Converted from zustand to react-redux store

    //If we don't have a value, default to 0 hard coded for now
    const currentScore = scores[player.id] ?? 0

    const handlePreset = (amount) => {
        dispatch(setScore({ playerId: player.id, score: currentScore + amount })) //Converted to react-redux useDispatch instead of direct store setter
    }

    const [modalOpen, setModalOpen] = useState(false)
    const [inputValue, setInputValue] = useState('')

    return (
        <>
        <div className="score-card" onClick={() => setModalOpen(true)}>
            <h2 className="player-name">{player.displayName}</h2>
            <p className="current-score">{currentScore}</p>
            <div className="preset-buttons">
                {[-5, -2, 2, 5].map(amount => (
                    <button 
                        key={amount}
                        className="preset-btn"
                        onClick={(e) => {
                            e.stopPropagation()
                            handlePreset(amount)
                        }}
                    >
                        {amount > 0 ? `+${amount}` : amount}
                    </button>
                ))}
            </div>
        </div>

        {modalOpen && (
            <div className = "modal-overlay" onClick={() => setModalOpen(false)}>
                <div className="modal-content" onClick={e => e.stopPropagation()}>
                    <h3>Set Score for {player.displayName}</h3>
                    <input type="number" value={inputValue} onChange={e => setInputValue(e.target.value)} placeholder="Enter score"/>
                    <button onClick={() => {
                        dispatch(setScore({ playerId: player.id, score: Number(inputValue) }))
                        setModalOpen(false)
                    }}>Confirm</button>
                    <button onClick={() => setModalOpen(false)}>Cancel</button>
                </div>
            </div>
        )}
        </>
    )

}

export default ScoreTracker