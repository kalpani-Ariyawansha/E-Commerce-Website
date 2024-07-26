import React from 'react';
import MSI from '../../assets/msi.png';
import { useLocation } from 'react-router-dom';

function Detail() {
  const location = useLocation();
  const item = location.state?.item;

  if (!item) {
    return <div>No item details available.</div>; 
  }

  const { title, description, price, ...features } = item;

  return (
    <div className='flex flex-row max-w-screen-xl mt-10 mb-14'>
      <div className='flex flex-1 justify-center items-center'>
        <div className='flex h-[35vh] justify-center items-center'>
          <img src={MSI} alt='MSI' className='h-full object-contain' />
        </div>
      </div>

      <div className='flex flex-1 flex-col gap-3 justify-start'>
        <span className='text-white text-4xl font-bold'>{title}</span>

        <span className='text-white text-sm font-light'>
          {description}
        </span>

        {/* Render features using map */}
        {Object.keys(features).map((key) => (
          <div key={key} className='flex flex-row gap-2'>
            <span className='text-white text-sm font-medium'>{key}</span>
            <span className='text-white text-sm font-light'>{features[key]}</span>
          </div>
        ))}

        <span className='text-3xl text-[#25AEFF] font-semibold'>{price}</span>
        <button className='flex flex-row justify-center items-center px-3 py-2 bg-[#25AEFF] font-medium'>BUY NOW</button>
      </div>
    </div>
  );
}

export default Detail;
