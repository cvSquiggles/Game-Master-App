import { create } from 'zustand'

//This is going to function as a global store for game session values
const useGameStore = create((set) => ({
    session: null,
    players: [],

    setSession: (session) => set({ session }),
    setPlayers: (players) => set({ players }),
}))

export default useGameStore