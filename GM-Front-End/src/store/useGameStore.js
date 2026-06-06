import { create } from 'zustand'

//This is going to function as a global store for game session values
const useGameStore = create((set) => ({
    session: null,
    players: [],
    scores: {},

    setSession: (session) => set({ session }),
    setPlayers: (players) => set({ players }),
    setScore: (playerId, score) => set (state => ({
        scores: { ...state.scores, [playerId]: score }
    })),
}))

export default useGameStore