import { configureStore, createSlice } from '@reduxjs/toolkit'

//This slice contains the game state, createSlice takes a name, the state values, and then reducers to handle those state values.
const gameSlice = createSlice({
    name: 'game',
    initialState: {
        session: null,
        players: [],
        scores: {},
        timers: {}
    },
    reducers: {
        setSession: (state, action) => {
            state.session = action.payload
        },
        setPlayers: (state, action) => {
            state.players = action.payload
        },
        setScore: (state, action) => {
            const { playerId, score } = action.payload
            state.scores[playerId] = score
        },
        setScores: (state, action) => {
            state.scores = action.payload
        }, //Added to replace the entire array of player scores, rather than updating each separately
        setTimer: (state, action) => {
            const { timerId, timerState } = action.payload
            state.timers[timerId] = timerState
        }
    }
})

export const { setSession, setPlayers, setScore, setScores, setTimer } = gameSlice.actions

export const store = configureStore({
    reducer: {
        game: gameSlice.reducer
    }
})