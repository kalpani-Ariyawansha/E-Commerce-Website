import React from 'react'

function Home() {
  return (
    <div className='flex flex-col max-w-xl mx-auto'>

    {/* contact us */}
    <div className='flex flex-col w-[60vh] gap-4 mx-auto mb-7 mt-7 m'>

      <div className='flex flex-col relative items-center mb-8'>
        <h1 className='text-3xl sm:text-5xl text-[#1D4759] font-semibold'>CONTACT US</h1>
        <p className='text-white text-xs sm:text-sm absolute top-6 sm:top-8'>How can we help you today?</p>
      </div>

      <div className='flex flex-col   sm:flex-row justify-between  gap-4 sm:gap-3'>
        <input type='text' placeholder='First Name' className=' bg-[#383838] rounded-lg text-xs sm:text-sm text-white px-3 py-2 w-full '/>
        <input type='text' placeholder='Last Name' className=' bg-[#383838] rounded-lg text-xs sm:text-sm text-white px-3 py-2 w-full '/>
      </div>

      <input type='text' placeholder='Last Name' className=' bg-[#383838] rounded-lg  text-xs sm:text-sm text-white px-3 py-2 w-full '/>
      <textarea className='bg-[#383838] rounded-lg text-xs sm:text-sm h-40 text-white px-3 py-2 w-full ' placeholder='Message' />

    </div>

    </div>
  )
}

export default Home