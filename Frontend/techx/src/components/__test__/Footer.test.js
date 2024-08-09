import React from 'react';
import { render, screen } from '@testing-library/react';
import Footer from '../Footer/Footer'; // Adjust the import path if necessary

describe('Footer Component', () => {
  beforeEach(() => {
    jest.clearAllMocks();
  });

  it('renders the footer with correct text and styling', () => {
    render(<Footer />);

   

    // Check if the description text is rendered correctly
    expect(screen.getByText(/Lorem, ipsum dolor sit amet consectetur adipisicing elit. Quas quam quaerat, natus quasi earum ad\?/i)).toBeInTheDocument();

    // Check if the address is rendered correctly
    expect(screen.getByText(/No 112,Galkiss,Colombo 07/i)).toBeInTheDocument();

    // Check if the Quick Links section is rendered correctly
    expect(screen.getByText(/Quick Links/i)).toBeInTheDocument();
    expect(screen.getByText(/HOME/i)).toBeInTheDocument();
    expect(screen.getByText(/PRODUCTS/i)).toBeInTheDocument();
    expect(screen.getByText(/SUPPORT/i)).toBeInTheDocument();

    // Check if the Brands section is rendered correctly
    expect(screen.getByText(/Brands/i)).toBeInTheDocument();
    expect(screen.getByText(/Asus/i)).toBeInTheDocument();
    expect(screen.getByText(/Apple/i)).toBeInTheDocument();
    expect(screen.getByText(/Dell/i)).toBeInTheDocument();
    expect(screen.getByText(/Hp/i)).toBeInTheDocument();
    expect(screen.getByText(/MSI/i)).toBeInTheDocument();

    
  });
});
