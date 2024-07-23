import React, { useState } from 'react'
import { IoMdArrowDropdown } from "react-icons/io";
import { RxHamburgerMenu } from "react-icons/rx";
import './Navbar.css'

function NavBar() {
  const [show, setShow] = useState(false)
  const [selected, setSelected] = useState('ALL')
  const [showMenu, setShowMenu] = useState(false)
  return (
    <div className='flex flex-row justify-between px-3 relative sm:justify-around w-full sm:max-w-screen-xl  h-8 sm:h-16 mx-auto items-center bg-[#222222]  py-2 relative'>
      <div className=' text-lg sm:text-3xl text-white font-bold'>tech<span className=' text-lg sm:text-3xl text-[#25AEFF] '>X</span></div>

      <input type='text' placeholder='Find your product...' className='w-1/3 h-8 hidden sm:flex bg-[#383838] rounded-2xl px-2 text-xs' />

      <RxHamburgerMenu  color='#25AEFF' className='visible  sm:hidden' onClick={()=>(setShowMenu(prev=>!prev))}/>

        {showMenu && <div className='flex flex-col bg-[#383838] absolute right-3 top-8 text-xs gap-2 items-center py-2 px-3 text-white font-semibold rounded-md'>
          <span>HOME</span>
          <span onClick={()=>(setShow(prev=>!prev))}>PRODUCTS</span>
          <span>SUPPORT</span>
          <button className='bg-[#25AEFF] text-black rounded-lg px-4 py-1 cursor-pointer'>LOGIN</button>
           
          </div>}

      <div className='sm:flex flex-row items-center  gap-4 hidden sm:visible text-sm font-semibold text-white'>
        <span className='flex flex-col relative gap-2 '><span className={selected==='HOME' ? 'cursor-pointer underline-space ':'cursor-pointer'} onClick={()=>(setSelected(prev=>prev==="ALL"? "HOME":"ALL"))}>HOME</span></span>
        <span className='flex flex-row items-center cursor-pointer ' onClick={()=>(setShow(prev=>!prev))}>PRODUCTS<span><IoMdArrowDropdown /></span></span>
        <span className='flex flex-col relative gap-2 '><span className={selected==='SUPPORT' ? 'cursor-pointer underline-space ':'cursor-pointer'} onClick={()=>(setSelected(prev=>prev==="ALL"? "SUPPORT":"ALL"))}>SUPPORT</span></span>
        <button className='bg-[#25AEFF] text-black rounded-lg px-4 py-1 cursor-pointer'>LOGIN</button>
      </div>

      {show && <div className='flex flex-col bg-[#383838] w-24 gap-2 py-2  absolute sm:right-[33vh] right-24 top-16 text-xs sm:text-base sm:top-[7vh] justify-center items-center text-white rounded-md font-semibold'>
        <span className='sm:border px-4 py-1 border-[#25AEFF]'>laptop</span>
        <span className='sm:border px-4 py-1 border-[#25AEFF]'>laptop</span>
        <span className='sm:border px-4 py-1 border-[#25AEFF]'>laptop</span>
      </div>}

      
    </div>
  )
}

export default NavBar