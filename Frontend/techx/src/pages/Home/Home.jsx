import React, { useRef } from 'react'
import PopularCard from '../../components/Popularcard/PopularCard'
import Category from '../../components/Category/Category'
import { categories } from '../../assets/data/data';
import { Swiper, SwiperSlide } from 'swiper/react';
import 'swiper/css';
import 'swiper/css/pagination';
import 'swiper/css/navigation';
import { Autoplay, Pagination, Navigation } from 'swiper/modules';
import Header from '../../components/Header/Header';
import { specialOffer } from '../../assets/data/data';
import emailjs from '@emailjs/browser';
import { toast } from 'react-toastify';
import Contact from '../../components/Contact/Contact';

function Home() {
  

  const slidersettings = {
    slidesPerView: 2,
    spaceBetween: 5,
    breakpoints: {
      480: {
        slidesPerView: 2
      },
      600: {
        slidesPerView: 4
      },
      750: {
        slidesPerView: 5
      },
      1100: {
        slidesPerView: 9
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
          {specialOffer?.map((item, index) => (
            <SwiperSlide key={index}><Header item={item} /></SwiperSlide>
          ))}
        </Swiper>
      </div>

      {/* Categories */}
      <div className='flex flex-col justify-center w-full mx-auto mt-14 mb-14 overflow-hidden'>
        <div className='flex flex-col relative items-center mb-14'>
          <h1 className='text-3xl sm:text-5xl text-[#1D4759] font-bold tracking-wide'>CATEGORIES</h1>
          <p className='text-white text-xs sm:text-sm absolute top-6 sm:top-8'>What tech essentials are you shopping for? </p>
        </div>

        <div className='w-full flex flex-row justify-center items-center mx-10 overflow-hidden'>
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
          >
            {categories.map((category, index) => (
              <SwiperSlide key={index}><Category category={category} /></SwiperSlide>
            ))}
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
          <PopularCard />
          <PopularCard />
          <PopularCard />
          <PopularCard />
        </div>
      </div>

      {/* Contact us */}
      <Contact/>
      
    </div>
  );
}

export default Home;
