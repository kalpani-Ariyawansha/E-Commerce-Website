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

function Home() {
  const contactRef = useRef();

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

  const sendEmail = (e) => {
    e.preventDefault();

    emailjs
      .sendForm('service_htlttgu', 'template_oxtizp9', contactRef.current, {publicKey:'JejJug4W0gWq4GTBn'})
      .then(
        () => {
          console.log('SUCCESS!');
          toast.success('Message Sent Successfully', { position: "bottom-right" });
          contactRef.current.reset();
        },
        (error) => {
          console.log('FAILED...', error.text);
          toast.error('Message Failed to Send', { position: "bottom-right" });
        },
      );
  };

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
      <div className='flex flex-col sm:w-[80vh] w-[40vh] gap-4 mx-auto mb-7 mt-7'>
        <div className='flex flex-col relative items-center mb-8'>
          <h1 className='text-3xl sm:text-5xl text-[#1D4759] font-bold tracking-wide'>CONTACT US</h1>
          <p className='text-white text-xs sm:text-sm absolute top-6 sm:top-8'>How can we help you today?</p>
        </div>

        <form className='flex flex-col gap-3' ref={contactRef} onSubmit={sendEmail}>
          <div className='flex flex-col sm:flex-row justify-between gap-4 sm:gap-3'>
            <input type='text' name='firstName' placeholder='First Name' className='bg-[#383838] rounded-lg text-xs sm:text-sm text-white px-3 py-2 w-full' />
            <input type='text' name='lastName' placeholder='Last Name' className='bg-[#383838] rounded-lg text-xs sm:text-sm text-white px-3 py-2 w-full' />
          </div>

          <input type='email' placeholder='Email' name='email' className='bg-[#383838] rounded-lg text-xs sm:text-sm text-white px-3 py-2 w-full' />
          <textarea name='message' className='bg-[#383838] rounded-lg text-xs sm:text-sm h-40 text-white px-3 py-2 w-full' placeholder='Message' />
          <button type='submit' className='bg-[#25AEFF] rounded-md text-xs font-semibold text-center px-3 py-2 hover:bg-[#3e7596] cursor-pointer '>SUBMIT</button>
        </form>
      </div>
    </div>
  );
}

export default Home;
