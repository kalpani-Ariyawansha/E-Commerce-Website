import React, { useRef } from 'react'
import emailjs from '@emailjs/browser';
import { toast } from 'react-toastify';
function Contact() {
    const contactRef = useRef();
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
  )
}

export default Contact