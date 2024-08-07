
import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import '@testing-library/jest-dom';
import { useNavigate } from 'react-router-dom';
import Category from '../Category/Category';
import MSI from '../../assets/msi.png';

// Mock useNavigate
jest.mock('react-router-dom', () => ({
  useNavigate: jest.fn(),
}));

describe('Category Component', () => {
  const mockNavigate = jest.fn();
  
  beforeAll(() => {
    useNavigate.mockImplementation(() => mockNavigate);
  });

  afterEach(() => {
    jest.clearAllMocks();
  });

  test('renders the category component and handles click navigation', () => {
    const category = 'electronics';

    render(<Category category={category} />);

    // Check if elements are rendered correctly
    const categoryElement = screen.getByText(category);
    const imageElement = screen.getByRole('img');

    expect(categoryElement).toBeInTheDocument();
    expect(imageElement).toHaveAttribute('src', MSI);
    expect(imageElement).toHaveClass('w-full h-full object-contain');

    // Simulate click event
    fireEvent.click(screen.getByText(category));

    // Check if navigate is called with the correct argument
    expect(mockNavigate).toHaveBeenCalledWith(`/products/${category}`);
  });
});
