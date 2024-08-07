import { useState } from 'react'
import { BrowserRouter,Route,Routes } from 'react-router-dom'
import Home from './pages/Home/Home'
import SignIn from './pages/SignIn/SignIn'
import SignUp from './pages/SignUp/SignUp'
import NavBar from './components/NavBar/NavBar'
import Footer from './components/Footer/Footer'
import Detail from './pages/Details/Detail'
import Products from './pages/Products/Products'
import StoreProvider from './context/store'
import {ToastContainer} from 'react-toastify'
import Support from './pages/Support/Support'
function App() {


  return (
    <StoreProvider>
    <BrowserRouter>
    <NavBar/>
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/products/:category" element={<Products />} />
      <Route path="/signin" element={<SignIn />} />
      <Route path="/signup" element={<SignUp />} />
      <Route path="/details" element={<Detail />} />
      <Route path="/support" element={<Support />} />
    </Routes>
    <Footer/>
    </BrowserRouter>
    <ToastContainer/>
    </StoreProvider>
  )
}

export default App
