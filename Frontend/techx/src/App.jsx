import { useState } from 'react'
import { BrowserRouter,Route,Routes } from 'react-router-dom'
import Home from './pages/Home/Home'
import SignIn from './pages/SignIn/SignIn'
import SignUp from './pages/SignUp/SignUp'
import NavBar from './components/NavBar/NavBar'
import Footer from './components/Footer/Footer'

function App() {


  return (
    <BrowserRouter>
    <NavBar/>
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/signin" element={<SignIn />} />
      <Route path="/signup" element={<SignUp />} />
    </Routes>
    <Footer/>
    </BrowserRouter>
  )
}

export default App
