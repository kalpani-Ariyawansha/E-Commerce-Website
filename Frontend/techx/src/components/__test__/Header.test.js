import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import { BrowserRouter as Router } from 'react-router-dom';
import Header from '../Header/Header'; // Adjust the import path if necessary

// Updated mock data for testing
const mockItem = {
  brand: 'Apple',
  description: 'The Apple MacBook Pro 16-inch is designed for high performance with a large Retina display and the powerful Apple M1 Pro chip. This laptop provides impressive graphics and processing power, making it perfect for creative professionals and power users.',
  model: 'MacBook Pro 16-inch',
  price: '$2,499',
  processor: 'Apple M1 Pro',
  ram: '16GB',
  resolution: '3456x2234',
  screenSize: '16.2 inches',
  storage: '1TB SSD',
  title: 'Apple MacBook Pro 16-inch - High Performance'
};

// Mock useNavigate
jest.mock('react-router-dom', () => ({
  ...jest.requireActual('react-router-dom'),
  useNavigate: jest.fn()
}));

describe('Header Component', () => {
  test('renders with correct props', () => {
    render(
      <Router>
        <Header item={mockItem} />
      </Router>
    );

    // Check if the title is rendered
    expect(screen.getByText(mockItem.title)).toBeInTheDocument();

    // Check if the description is rendered
    expect(screen.getByText(mockItem.description)).toBeInTheDocument();

    // Check if the price is rendered
    expect(screen.getByText(mockItem.price)).toBeInTheDocument();
  });

  test('renders the buttons correctly', () => {
    render(
      <Router>
        <Header item={mockItem} />
      </Router>
    );

    // Check if the "BUY NOW" button is rendered
    expect(screen.getByText('BUY NOW')).toBeInTheDocument();

    // Check if the "MORE DETAILS" button is rendered
    expect(screen.getByText('MORE DETAILS')).toBeInTheDocument();
  });

  test('navigates to the details page with correct state on "MORE DETAILS" button click', () => {
    const mockNavigate = jest.fn(); // Create a mock function
    jest.spyOn(require('react-router-dom'), 'useNavigate').mockImplementation(() => mockNavigate); // Use the mock function

    render(
      <Router>
        <Header item={mockItem} />
      </Router>
    );

    // Click the "MORE DETAILS" button
    fireEvent.click(screen.getByText('MORE DETAILS'));

    // Check if navigate was called with the correct arguments
    expect(mockNavigate).toHaveBeenCalledWith('/details', { state: { item: mockItem } });
  });
});
