import React from 'react'
import MSI from '../../assets/msi.png'
function Header() {
  return (
    <div className='flex flex-row bg-[#383838] h-full w-full rounded-lg'>

        <div className='flex flex-1 flex-col px-4 justify-center  gap-3 '>
            <div className='text-sm sm:text-xl text-white text-start font-semibold'>MSI GL63 15.6 Gaming Laptop</div>
            <div className='hidden sm:flex sm:text-xs text-white text-justify font-light'>Lorem ipsum dolor sit amet consectetur adipisicing elit. Officiis voluptates possimus voluptate! Repellendus velit rem doloremque deserunt, explicabo natus voluptas. Libero vero nobis, molestias nulla provident odit earum? Ipsam, tempora!</div>
            <div className='text-start text-xs sm:text-sm text-[#25AEFF] font-medium'>Rs.250000.00</div>

            <div className='flex flex-col sm:flex-row gap-2 sm:gap-5  sm:items-center'>
                
                <button className='flex px-3 py-1 text-[8px] sm:text-xs  w-25 justify-center items-center sm:px-3 sm:py-2 bg-[#25AEFF] text-xs font-medium rounded-md hover:bg-white'>BUY NOW</button>
                <button className='flex px-3 py-1 text-[8px] sm:text-xs w-25 justify-center items-center sm:px-3 sm:py-2 border text-xs text-white font-medium rounded-md hover:bg-[#25AEFF]'>MORE DETAILS</button>
            </div>
        </div>

        <div className='flex flex-1  justify-center items-center'>
        <div className='flex justify-center items-center h-[25vh] '>
    <img src={MSI} className='w-full h-full object-contain' />
</div>

        </div>

    </div>
  )
}

export default Header