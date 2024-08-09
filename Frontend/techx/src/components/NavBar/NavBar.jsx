
import React, { useEffect, useRef, useState } from 'react';
import { IoMdSearch } from 'react-icons/io';
import { RxHamburgerMenu } from 'react-icons/rx';
import { IoIosCloseCircleOutline } from 'react-icons/io';


import { IoMdArrowDropdown } from "react-icons/io";

import axios from 'axios'
import './Navbar.css'

import { useNavigate } from 'react-router-dom';
import './Navbar.css';

function NavBar() {

  const [showLogin, setShowLogin] = useState(false);
  const [selected, setSelected] = useState('ALL');
  const [showMenu, setShowMenu] = useState(false);
  const [search, setSearch] = useState('');
  const [status, setStatus] = useState('LOGIN');
  

 
  
  
 

 const [data,setData] = useState({
  fullName:'',
  number:'',
  password:'',
  email:''
 })
 const navigate=useNavigate()

  const toggleRef = useRef(null);

  const searchHandler = () => {
    navigate(`/products/${search}`);
    setSearch('');
  };

  const handleClickOutside = (event) => {
    if (toggleRef.current && !toggleRef.current.contains(event.target)) {
      setShowMenu(false);
    }
  };

  useEffect(() => {
    document.addEventListener('mousedown', handleClickOutside);
    return () => {
      document.removeEventListener('mousedown', handleClickOutside);
    };
  }, []);

  const handleSubmit = async () =>{
    if(status==='LOGIN'){
      console.log("okay")
      await axios.post('http://localhost:8080/api/v1/auth/authenticate',{
       userName: data.email, 
       password: data.password
      }   
      ).then(reponse =>{
        if(reponse.status === 200){
          alert('Login successfull')
        }
      } 
    ).catch(
      error =>{
        alert("Unsucessfull. ")
        console.log(error)
      }
    )
    }else if(status === 'REGISTER'){
      await axios.post('http://localhost:8080/api/v1/auth/register',{
        userName: data.fullName, 
        password: data.password,
        email:data.email
       }   
       ).then(reponse =>{
         if(reponse.status === 200){
           alert('Register successfull')
         }
       } 
     ).catch(
       error =>{
        alert("Unsucessfull. User has already existed.")
         console.log(error)
       }
     )
    }

  }
  
  const handleChange = (e) =>{
    e.preventDefault();
    setData(
      preData => ({
        ...preData,[e.target.name] : e.target.value
      })
    );
    console.log(data.password)
  }

  return (

   

      
       

    <div className='flex flex-row justify-between px-3 relative sm:justify-around w-full sm:max-w-screen-xl  h-8 sm:h-16 mx-auto items-center bg-[#222222]  py-2 '>
      <div className='text-lg font-bold text-white sm:text-3xl'>tech<span className=' text-lg sm:text-3xl text-[#25AEFF] '>X</span></div>

      <div className='flex flex-row justify-between items-center w-[50vh] rounded-2xl bg-[#383838] px-2 '>
      <input value={search} type='text' placeholder='Find your product...'  className=' h-8 hidden sm:flex w-full bg-[#383838] focus:outline-none text-white rounded-2xl px-2 text-xs' id='667' onChange={(e)=>(setSearch(e.target.value))}/>
      <IoMdSearch  size={20} color='white' onClick={searchHandler} className='cursor-pointer' id = '699'/>
      </div>

      <RxHamburgerMenu  color='#25AEFF' className='visible sm:hidden' onClick={()=>(setShowMenu(prev=>!prev))}/>

        {showMenu && <div ref={toggleRef} className='flex z-50 flex-col bg-[#383838] absolute right-3 top-8 text-xs gap-2 items-center py-2 px-3 text-white font-semibold rounded-md'>
          <span onClick={()=>(navigate('/'))}>HOME</span>
          
          <span onClick={()=>(navigate('support'))}>SUPPORT</span>
          <button className='bg-[#25AEFF] text-black rounded-lg px-4 py-1 cursor-pointer' onClick={()=>(setShowLogin(true))} >LOGIN</button>
           
          </div>}

      <div className='flex-row items-center hidden gap-4 text-sm font-semibold text-white sm:flex sm:visible'>
        <span className='relative flex flex-col gap-2 '><span className={selected==='HOME' ? 'cursor-pointer underline-space ':'cursor-pointer'} onClick={()=>(setSelected(prev=>prev==="ALL"? "HOME":"ALL"))}>HOME</span></span>
        
        <span className='relative flex flex-col gap-2 '><span className={selected==='SUPPORT' ? 'cursor-pointer underline-space ':'cursor-pointer'} onClick={()=>(setSelected(prev=>prev==="ALL"? "SUPPORT":"ALL"))}>SUPPORT</span></span>
        <button className='bg-[#25AEFF] text-black rounded-lg px-4 py-1 cursor-pointer' onClick={()=>(setShowLogin(true)) } id ="1223">LOGIN</button>
      </div>

        {
          showLogin && 
              <div className='flex absolute z-50  w-screen h-screen sm:w-[208vh] sm:h-[100vh] justify-center items-center opacity-85 top-0  bg-black '>
                  <div className='flex flex-col gap-4 bg-white p-5 rounded-md w-[40vh] min-h-80 relative'>
                    <span className='text-2xl font-bold text-center text-black'>{status==='LOGIN'?'Welcome Back':'Create an Account'}</span>
                    <IoIosCloseCircleOutline className='absolute right-2 top-2 text-[#25AEFF] cursor-pointer hover:text-[#376f8f]' size={22} onClick={(e)=>(setShowLogin(false))} />
                    <div className='flex flex-col gap-2 '>
                    
                    <span className='flex flex-col gap-1'>
                      <label className='text-xs font-medium text-black' >User Name</label>
                      <input type='text' className='flex text-white px-3 py-2 w-full bg-[#383838] rounded-md text-xs' name = 'fullName' onChange={(e) => {handleChange(e)}}/>
                    </span>
                    <span className='flex flex-col gap-1'>
                      <label className='text-xs font-medium text-black'>Email</label>
                      <input type='email' className='flex text-white px-3 py-2 w-full bg-[#383838] rounded-md text-xs' name = 'email' onChange={(e) => {handleChange(e)}} />
                    </span>
                    {status==='LOGIN'?'':<span className='flex flex-col gap-1'>
                      <label className='text-xs font-medium text-black' >Mobile Number</label>
                      <input type='text' className='flex text-white px-3 py-2 w-full bg-[#383838] rounded-md text-xs' name = 'number' onChange={(e) => {handleChange(e)}}/>
                    </span>}
                    <span className='flex flex-col gap-1'>
                      <label className='text-xs font-medium text-black' >Password</label>
                      <input type='password' className='flex text-white px-3 py-2 w-full bg-[#383838] rounded-md text-xs' name = 'password' onChange={(e) => {handleChange(e)}}/>
                    </span>

                    <button onClick={handleSubmit} className='flex justify-center items-center px-2 mt-2 bg-[#25AEFF] rounded-md py-2 font-medium text-sm transition-all hover:bg-[#35769e] cursor-pointer'>{status==='LOGIN'?"SIGN IN":"SIGN UP"}</button>
                    
                    {status==='LOGIN'?(<span className='flex flex-row justify-center gap-1 text-xs font-medium text-black '>Don't have an account?<span className='text-[#25AEFF] cursor-pointer' onClick={()=>(setStatus('REGISTER'))} id="223">Register</span></span>):
                    (<span className='flex flex-row justify-center gap-1 text-xs font-medium text-black '>All ready have an account?<span className='text-[#25AEFF] cursor-pointer' onClick={()=>(setStatus('LOGIN'))}>Login</span></span>)}
                    </div>


      {showMenu && (
        <div
          ref={toggleRef}
          className='flex z-50 flex-col bg-[#383838] absolute right-3 top-8 text-xs gap-2 items-center py-2 px-3 text-white font-semibold rounded-md'
        >
          <span onClick={() => navigate('/')}>HOME</span>
          <span onClick={() => navigate('/support')}>SUPPORT</span>
          <button
            className='bg-[#25AEFF] text-black rounded-lg px-4 py-1 cursor-pointer'
            onClick={() => setShowLogin(true)}
          >
            LOGIN
          </button>
        </div>
      )}

      <div className='sm:flex flex-row items-center gap-4 hidden sm:visible text-sm font-semibold text-white'>
        <span className='flex flex-col relative gap-2'>
          <span
            className={selected === 'HOME' ? 'cursor-pointer underline-space' : 'cursor-pointer'}
            onClick={() => {setSelected((prev) => (prev === 'ALL' ? 'HOME' : 'ALL')); navigate('/');}}
          >
            HOME
          </span>
        </span>
        <span className='flex flex-col relative gap-2'>
          <span
            className={selected === 'SUPPORT' ? 'cursor-pointer underline-space' : 'cursor-pointer'}
            onClick={() => {setSelected((prev) => (prev === 'ALL' ? 'SUPPORT' : 'ALL')); navigate('/support');}}
          >
            SUPPORT
          </span>
        </span>
        <button
          className='bg-[#25AEFF] text-black rounded-lg px-4 py-1 cursor-pointer'
          onClick={() => setShowLogin(true)}
        >
          LOGIN
        </button>
      </div>

      {showLogin && (
        <div className='flex absolute z-50 w-screen h-screen sm:w-[208vh] sm:h-[100vh] justify-center items-center opacity-85 top-0 bg-black'>
          <div className='flex flex-col gap-4 bg-white p-5 rounded-md w-[40vh] min-h-80 relative'>
            <span className='text-2xl text-black font-bold text-center'>
              {status === 'LOGIN' ? 'Welcome Back' : 'Create an Account'}
            </span>
            <IoIosCloseCircleOutline
              className='absolute right-2 top-2 text-[#25AEFF] cursor-pointer hover:text-[#376f8f]'
              size={22}
              onClick={() => setShowLogin(false)}
              data-testid='close-icon'
            />
            <div className='flex flex-col gap-2'>
              <span className='flex flex-col gap-1'>
                <label htmlFor='username' className='text-xs text-black font-medium'>
                  User Name
                </label>
                <input
                  id='username'
                  type='text'
                  className='flex text-black px-3 py-2 w-full bg-[#f0f0f0] rounded-md text-xs'
                  aria-label='User Name'
                />
              </span>
              <span className='flex flex-col gap-1'>
                <label htmlFor='email' className='text-xs text-black font-medium'>
                  Email
                </label>
                <input
                  id='email'
                  type='email'
                  className='flex text-black px-3 py-2 w-full bg-[#f0f0f0] rounded-md text-xs'
                  aria-label='Email'
                />
              </span>
              {status === 'REGISTER' && (
                <span className='flex flex-col gap-1'>
                  <label htmlFor='mobile' className='text-xs text-black font-medium'>
                    Mobile Number
                  </label>
                  <input
                    id='mobile'
                    type='text'
                    className='flex text-black px-3 py-2 w-full bg-[#f0f0f0] rounded-md text-xs'
                    aria-label='Mobile Number'
                  />
                </span>
              )}
              <span className='flex flex-col gap-1'>
                <label htmlFor='password' className='text-xs text-black font-medium'>
                  Password
                </label>
                <input
                  id='password'
                  type='password'
                  className='flex text-black px-3 py-2 w-full bg-[#f0f0f0] rounded-md text-xs'
                  aria-label='Password'
                />
              </span>
              <button
                className='flex justify-center items-center px-2 mt-2 bg-[#25AEFF] rounded-md py-2 font-medium text-sm transition-all hover:bg-[#35769e] cursor-pointer'
              >
                {status === 'LOGIN' ? 'SIGN IN' : 'SIGN UP'}
              </button>
              {status === 'LOGIN' ? (
                <span className='flex flex-row gap-1 text-xs justify-center text-black font-medium'>
                  Don't have an account?
                  <span
                    className='text-[#25AEFF] cursor-pointer'
                    onClick={() => setStatus('REGISTER')}
                  >
                    Register
                  </span>
                </span>
              ) : (
                <span className='flex flex-row gap-1 text-xs justify-center text-black font-medium'>
                  Already have an account?
                  <span
                    className='text-[#25AEFF] cursor-pointer'
                    onClick={() => setStatus('LOGIN')}
                  >
                    Login
                  </span>
                </span>
              )}
            </div>
          </div>
        </div>
      )}
    </div>
  );
}

export default NavBar;
