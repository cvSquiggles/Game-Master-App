import { configureStore, createSlice } from '@reduxjs/toolkit'

//This slice contains the game state, createSlice takes a name, the state values, and then reducers to handle those state values.
const gameSlice = createSlice({
    name: 'game',
    initialState: {
        session: null,
        players: [],
        scores: {}
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
        }
    }
})

export const { setSession, setPlayers, setScore } = gameSlice.actions

export const store = configureStore({
    reducer: {
        game: gameSlice.reducer
    }
})