import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import { BrowserRouter as Router } from 'react-router-dom';
import Contact from '../Contact/Contact';




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

 
 
});
