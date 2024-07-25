import React, { useContext } from 'react'
import PopularCard from '../../components/Popularcard/PopularCard'
import { useParams } from 'react-router-dom'
import { store } from '../../context/store'

function Products() {
  const {ItemData}=useContext(store)
  
  const {category}=useParams()
  
  return (
    <div className='flex gap-9 mx-auto justify-start mt-10 mb-10 flex-wrap max-w-screen-xl'>
      {ItemData?.filter((item)=>(item.category===category)).map((item,i)=>(item.items.map((item,i)=>(<PopularCard item={item} key={i}/>))) )}
        
       
    </div>
  )
}

export default Products