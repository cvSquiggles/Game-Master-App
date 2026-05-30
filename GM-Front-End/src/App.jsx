import { useState, useEffect } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
import './App.css'

  function App() {
  const [count, setCount] = useState(0)
  const [output, setOutput] = useState("");

  useEffect(()=> {
    console.log("It's triggered!");
    fetch('http://localhost:8080/api/mic')
      .then(response => response.text())
      .then(text => setOutput(text))
  });

  return (
    <>
      {
        <p>{output}</p>
      }
    </>
  )
}

export default App