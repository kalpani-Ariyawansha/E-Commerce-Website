import React from 'react'
import MSI from '../../assets/msi.png'
function Category() {
  return (
    <div className='flex flex-col h-[15vh] bg-[#383838] max-w-[15vh] rounded-lg items-center'>
        <div className='h-16 w-16 flex justify-center items-center'>
            <img src={MSI} className='w-full h-full object-contain'/>
        </div>
        <span className='text-white text-sm font-medium'>Laptop</span>
    </div>
  )
}

export default Category