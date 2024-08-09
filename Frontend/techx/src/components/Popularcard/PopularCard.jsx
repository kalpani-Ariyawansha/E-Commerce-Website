import React from 'react'
import { CiStar } from "react-icons/ci";
import MSI from '../../assets/msi.png'
import { useNavigate } from 'react-router-dom';
function PopularCard({item}) {
   console.log(item);
  const navigate=useNavigate()
  return (
    <div className='flex flex-col bg-[#383838] max-w-[40vh] gap-8 rounded-md py-3 min-h-[40vh]' onClick={()=>(navigate(`/details`,{ state: { item } }))} id = '1'>
        <div className='flex w-full h-28 sm:h-40'>
            <img src={MSI} alt='MSI' className='object-contain w-full h-full'/>
        </div>
        <div className='flex flex-col gap-3 px-5 py-3'>
            <span className='text-sm text-white'>{item?.title} </span>
            <span className='flex flex-row items-center text-sm'>
                <CiStar size={17} color='#25AEFF' />
                <CiStar size={17} color='#25AEFF'/>
                <CiStar size={17} color='#25AEFF'/>
                <CiStar size={17} color='#25AEFF'/>
                <span className='ml-1 text-xs font-medium text-white'>1123 sold</span>
            </span>
            <span className='text-sm text-white'>{item?.price}</span>
        </div>

    </div>
  )
}


export default PopularCard