import React, { useRef } from 'react'
import PopularCard from '../../components/Popularcard/PopularCard'
import Category from '../../components/Category/Category'

import { Swiper, SwiperSlide } from 'swiper/react';


import 'swiper/css';


import 'swiper/css/pagination';
import 'swiper/css/navigation';



import { Autoplay, Pagination, Navigation } from 'swiper/modules';
import Header from '../../components/Header/Header';

function Home() {


  const slidersettings = {
    slidesPerView : 2,
    spaceBetween : 5,
    breakpoints : {
        480 : {
            slidesPerView: 2
        },
        600 : {
            slidesPerView: 4
        },
        750 : {
            slidesPerView: 5
        },
        1100 : {
            slidesPerView: 8
        }

    }
  }
  
  return (
    <div className='flex flex-col max-w-screen-xl mx-auto '>

      {/* header */}
      <div className='flex w-[45vh] h-[33vh] sm:w-[100vh] sm:h-[50vh] mx-auto p-4 mt-8'>

      <Swiper
        spaceBetween={30}
        centeredSlides={true}
        autoplay={{
          delay: 2500,
          disableOnInteraction: false,
        }}
        pagination={{
          clickable: true,
        }}
        
        modules={[Autoplay, Pagination, Navigation]}
        
        className="mySwiper"
      >
        <SwiperSlide><Header/></SwiperSlide>
        <SwiperSlide><Header/></SwiperSlide>
        <SwiperSlide><Header/></SwiperSlide>
        
        
        
      </Swiper>
      </div>


      {/* Categories */}
      <div className='flex flex-col justify-center w-full mx-auto mt-14 mb-14'>
        <div className='flex flex-col relative items-center mb-14'>
          <h1 className='text-3xl sm:text-5xl text-[#1D4759] font-bold tracking-wide'>CATEGORIES</h1>
          <p className='text-white text-xs sm:text-sm absolute top-6 sm:top-8'>What tech essentials are you shopping for? </p>
        </div>
        
        <div className='w-full  flex flex-row justify-center items-center mx-10'>
          <Swiper
          
            spaceBetween={slidersettings.spaceBetween}
            slidesPerView={slidersettings.slidesPerView}
            breakpoints={slidersettings.breakpoints}
            autoplay={{
              delay: 2500,
              disableOnInteraction: false,
            }}
            pagination={{
              clickable: true,
            }}
            
            modules={[Autoplay]}
            
            
            onSlideChange={() => console.log('slide change')}
            onSwiper={(swiper) => console.log(swiper)}
          >
            <SwiperSlide><Category/></SwiperSlide>
            <SwiperSlide><Category/></SwiperSlide>
            <SwiperSlide><Category/></SwiperSlide>
            <SwiperSlide><Category/></SwiperSlide>
            <SwiperSlide><Category/></SwiperSlide>
            <SwiperSlide><Category/></SwiperSlide>
            <SwiperSlide><Category/></SwiperSlide>
            <SwiperSlide><Category/></SwiperSlide>
            <SwiperSlide><Category/></SwiperSlide>
            <SwiperSlide><Category/></SwiperSlide>
            <SwiperSlide><Category/></SwiperSlide>
            <SwiperSlide><Category/></SwiperSlide>
          </Swiper>
        </div>
      </div>

      {/* Popular section */}
      <div className='flex flex-col mx-auto mt-14 mb-14'>
        <div className='flex flex-col relative items-center mb-14'>
          <h1 className='text-3xl sm:text-5xl text-[#1D4759] font-bold tracking-wide'>POPULAR PRODUCTS</h1>
          <p className='text-white text-xs sm:text-sm absolute top-6 sm:top-8'>Looking for the best in tech?</p>
        </div>

        <div className='grid grid-cols-1 mx-auto sm:grid-cols-4 gap-6 sm:gap-3'>
          <PopularCard/>
          <PopularCard/>
          <PopularCard/>
          <PopularCard/>
        </div>
      </div>
      
      {/* Contact us */}
      <div className='flex flex-col sm:w-[80vh] w-[40vh] gap-4 mx-auto mb-7 mt-7'>
        <div className='flex flex-col relative items-center mb-8'>
          <h1 className='text-3xl sm:text-5xl text-[#1D4759] font-bold tracking-wide'>CONTACT US</h1>
          <p className='text-white text-xs sm:text-sm absolute top-6 sm:top-8'>How can we help you today?</p>
        </div>

        <div className='flex flex-col sm:flex-row justify-between gap-4 sm:gap-3'>
          <input type='text' placeholder='First Name' className='bg-[#383838] rounded-lg text-xs sm:text-sm text-white px-3 py-2 w-full' />
          <input type='text' placeholder='Last Name' className='bg-[#383838] rounded-lg text-xs sm:text-sm text-white px-3 py-2 w-full' />
        </div>

        <input type='text' placeholder='Email' className='bg-[#383838] rounded-lg text-xs sm:text-sm text-white px-3 py-2 w-full' />
        <textarea className='bg-[#383838] rounded-lg text-xs sm:text-sm h-40 text-white px-3 py-2 w-full' placeholder='Message' />
      </div>
    </div>
  )
}

export default Home
