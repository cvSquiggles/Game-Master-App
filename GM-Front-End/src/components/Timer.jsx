import { useSelector, useDispatch } from 'react-redux'
import { useState, useRef, useEffect } from 'react'
import { setTimer } from '../store/store'

//Defaulting to 90,000ms for now just to get it functional, this is a basic first draft of the timer to get something running, eventually we want to support more, like naming the timers, and toggling between counting up or down
function Timer({ timerId, durationMs = 90000 }) {
    const dispatch = useDispatch()

    const timers = useSelector(state => state.game.timers)
    const timerState = timers[timerId] || { currentValueMs: durationMs, status: 'idle'} //Default to 90,000ms and idle if no timer info to pull from global state array

    console.log(timerState)

    //This function knocks 1000ms off our timer ms value, and updates the timer status if necessary
    const tick = () => {
        dispatch(setTimer({
            timerId,
            timerState: {
                currentValueMs: Math.max(0, timerState.currentValueMs - 1000),
                status: timerState.currentValueMs <= 1000 ? 'expire' : 'running'
            }
        }))
    }

    const intervalRef = useRef(null) //Stores the ID of our interval so we can easily manage/clear it when we want
    const tickRef = useRef(tick) //This stores a reference to our tick function that updates the currentValueMs and timer status
    tickRef.current = tick //Set our tick method to the latest iteration of tick on each re-render, so it's never stale

    const handlePlay = () => {
        dispatch(setTimer({ timerId, timerState: { ...timerState, status: 'running'} }))
    }

    const handlePause = () => {
        dispatch(setTimer({ timerId, timerState: { ...timerState, status: 'paused'} }))
    }

    const handleReset = () => {
        dispatch(setTimer({ timerId, timerState: { currentValueMs: durationMs, status: 'idle'} }))
    }

    useEffect(() => {
        if (timerState.status === 'running') 
        {
            intervalRef.current = setInterval(() => tickRef.current(), 1000) //Call the tickRef.current() which is just our tick dispatch method, since we're running
        }
        else
        {
            clearInterval(intervalRef.current)
        }

        return () => clearInterval(intervalRef.current)
    }, [timerState.status])

    const formatTime = (ms) => {
        const totalSeconds = Math.floor(ms / 1000)
        const minutes = Math.floor(totalSeconds / 60)
        const seconds = totalSeconds % 60
        return `${minutes}:${seconds.toString().padStart(2, '0')}`
    }

    return (
        <div className="timer-card">
            <h2 className="timer-label">Timer</h2>
            <p className="timer-display">{formatTime(timerState.currentValueMs)}</p>
            <div className="timer-buttons">
                <button onClick={handlePlay} disabled={timerState.status === 'running' || timerState.status === 'expired'}>▶</button>
                <button onClick={handlePause} disabled={timerState.status !== 'running'}>⏸</button>
                <button onClick={handleReset}>↺</button>
            </div>
        </div>
    )
}

export default Timer