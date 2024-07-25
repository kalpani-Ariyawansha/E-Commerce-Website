import React from 'react'
import { CiStar } from "react-icons/ci";
import MSI from '../../assets/msi.png'
function PopularCard({img,title,price,sold}) {
  return (
    <div className='flex flex-col bg-[#383838] max-w-[40vh] gap-8 rounded-md py-3 min-h-[40vh]'>
        <div className='flex h-28 sm:h-40 w-full'>
            <img src={MSI} alt='MSI' className='w-full object-contain h-full'/>
        </div>
        <div className='flex flex-col gap-3 px-5 py-3'>
            <span className='text-white text-sm'>MSI GL63 15.6 Gaming Laptop </span>
            <span className='flex flex-row items-center text-sm'>
                <CiStar size={17} color='#25AEFF' />
                <CiStar size={17} color='#25AEFF'/>
                <CiStar size={17} color='#25AEFF'/>
                <CiStar size={17} color='#25AEFF'/>
                <span className='text-xs ml-1 font-medium text-white'>1123 sold</span>
            </span>
            <span className='text-sm text-white'>Rs.11200.00</span>
        </div>

    </div>
  )
}


export default PopularCard