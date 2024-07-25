import React from 'react'

function Footer() {
  return (
    <div className='flex flex-col h-[40vh] sm:h-[50vh] p-5  bg-[#111111] w-full mx-auto '>
      
      <div className='flex flex-row justify-around items-start'>
        <div className='flex flex-col gap-3'>
          <span className='flex flex-row text-white text-2xl sm:text-4xl font-semibold'>tech<span className='text-[#25AEFF] text-2xl sm:text-4xl font-semibold'>X</span></span>
          <span className='text-white w-40 sm:w-64 text-xs font-medium'>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Quas quam quaerat, natus quasi earum ad?</span>
          <span className='text-xs text-white font-medium'>No 112,Galkiss,Colombo 07</span>
        </div>

        <div className='flex flex-col gap-2 text-white text-xs'>
        <span className='text-sm text-[#25AEFF] font-medium'>Quick Links</span>
          <span>HOME</span>
          <span>PRODUCTS</span>
          <span>SUPPORT</span>

        </div>
        <div className='flex flex-col gap-2 text-white text-xs'>
          <span className='text-sm text-[#25AEFF] font-medium'>Brands</span>
          <span>Asus</span>
          <span>Apple</span>
          <span>Dell</span>
          <span>Hp</span>
          <span>MSI</span>

        </div>

      </div>

      
      
      <div className='mt-14 sm:mt-28 gap-2 flex flex-col'>
      <hr className=' w-3/4 mx-auto'/>
       <div className='text-center text-white text-xs'>&copy; 2021 Tech<span className='text-[#25AEFF]'>X</span>. All Rights Reserved</div>
        
      </div>

    </div>
  )
}

export default Footer