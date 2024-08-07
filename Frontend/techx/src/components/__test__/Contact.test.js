import React from 'react';
import { render, screen, fireEvent, waitFor } from '@testing-library/react';
import { BrowserRouter as Router } from 'react-router-dom';
import Contact from '../Contact/Contact';
import emailjs from '@emailjs/browser';
import { toast } from 'react-toastify';

// Mock emailjs and toast
jest.mock('@emailjs/browser', () => ({
  sendForm: jest.fn(),
}));

jest.mock('react-toastify', () => ({
  toast: {
    success: jest.fn(),
    error: jest.fn(),
  },
}));

describe('Contact Component', () => {
  beforeEach(() => {
    jest.clearAllMocks();
  });

  it('renders CONTACT US title and form fields', () => {
    render(
      <Router>
        <Contact />
      </Router>
    );

    expect(screen.getByText(/CONTACT US/i)).toBeInTheDocument();
    expect(screen.getByPlaceholderText(/First Name/i)).toBeInTheDocument();
    expect(screen.getByPlaceholderText(/Last Name/i)).toBeInTheDocument();
    expect(screen.getByPlaceholderText(/Email/i)).toBeInTheDocument();
    expect(screen.getByPlaceholderText(/Message/i)).toBeInTheDocument();
    expect(screen.getByText(/SUBMIT/i)).toBeInTheDocument();
  });

  it('calls sendEmail on form submit and displays success message', async () => {
    const mockSendForm = emailjs.sendForm;
    mockSendForm.mockResolvedValueOnce({}); // Mock successful response

    render(
      <Router>
        <Contact />
      </Router>
    );

    fireEvent.change(screen.getByPlaceholderText(/First Name/i), { target: { value: 'John' } });
    fireEvent.change(screen.getByPlaceholderText(/Last Name/i), { target: { value: 'Doe' } });
    fireEvent.change(screen.getByPlaceholderText(/Email/i), { target: { value: 'john.doe@example.com' } });
    fireEvent.change(screen.getByPlaceholderText(/Message/i), { target: { value: 'Hello!' } });

    fireEvent.click(screen.getByText(/SUBMIT/i));

    await waitFor(() => {
      expect(mockSendForm).toHaveBeenCalledWith(
        'service_htlttgu',
        'template_oxtizp9',
        expect.anything(),
        { publicKey: 'JejJug4W0gWq4GTBn' }
      );
      expect(toast.success).toHaveBeenCalledWith('Message Sent Successfully', { position: "bottom-right" });
    });
  });

  it('calls sendEmail on form submit and displays error message on failure', async () => {
    const mockSendForm = emailjs.sendForm;
    mockSendForm.mockRejectedValueOnce({ text: 'Failed' }); // Mock failure response

    render(
      <Router>
        <Contact />
      </Router>
    );

    fireEvent.change(screen.getByPlaceholderText(/First Name/i), { target: { value: 'John' } });
    fireEvent.change(screen.getByPlaceholderText(/Last Name/i), { target: { value: 'Doe' } });
    fireEvent.change(screen.getByPlaceholderText(/Email/i), { target: { value: 'john.doe@example.com' } });
    fireEvent.change(screen.getByPlaceholderText(/Message/i), { target: { value: 'Hello!' } });

    fireEvent.click(screen.getByText(/SUBMIT/i));

    await waitFor(() => {
      expect(mockSendForm).toHaveBeenCalledWith(
        'service_htlttgu',
        'template_oxtizp9',
        expect.anything(),
        { publicKey: 'JejJug4W0gWq4GTBn' }
      );
      expect(toast.error).toHaveBeenCalledWith('Message Failed to Send', { position: "bottom-right" });
    });
  });
});
