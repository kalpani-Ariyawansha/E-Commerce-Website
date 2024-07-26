import React from 'react'
import MSI from '../../assets/msi.png'
import { useNavigate } from 'react-router-dom'
function Category({category}) {
  
  
  const navigate=useNavigate()
  return (
    <div className='flex flex-col h-[15vh] bg-[#383838] max-w-[15vh] rounded-lg items-center p-3 gap-2' onClick={()=>(navigate(`/products/${category}`))}>
        <div className='h-16 w-16 flex justify-center items-center'>
            <img src={MSI} className='w-full h-full object-contain'/>
        </div>
        <span className='text-white text-xs font-medium text-center'>{category}</span>
    </div>
  )
}

export default Category