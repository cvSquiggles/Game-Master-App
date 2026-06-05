import { useState, useEffect } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
import './App.css'
import { BrowserRouter, Routes, Route } from 'react-router-dom'

//View imports
import { LandingPage } from './pages/LandingPage'
import { PlayView } from './pages/PlayView'

  function App() {
    return (
      <BrowserRouter>
          {/* Routes */}
          <Routes>

            <Route path="/" element={<LandingPage />} />

            <Route path="/play" element={<PlayView />} />

          </Routes>
      
      </BrowserRouter>
    )
}

export default App