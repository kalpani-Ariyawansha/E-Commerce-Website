import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import '@testing-library/jest-dom';
import { useNavigate } from 'react-router-dom';
import Category from '../Category/Category';
import MSI from '../../assets/msi.png';


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

  test('renders the category component with correct props', () => {
    const category = 'electronics';

    render(<Category category={category} />);

    // Check if elements are rendered correctly
    const categoryElement = screen.getByText(category);
    const imageElement = screen.getByRole('img');

    expect(categoryElement).toBeInTheDocument();
    expect(imageElement).toHaveAttribute('src', MSI);
    expect(imageElement).toHaveClass('w-full h-full object-contain');
  });

  test('handles click event and navigates to the correct route', () => {
    const category = 'electronics';

    render(<Category category={category} />);

    // Simulate click event
    fireEvent.click(screen.getByText(category));

    // Check if navigate is called with the correct argument
    expect(mockNavigate).toHaveBeenCalledWith(`/products/${category}`);
  });

  test('renders with proper class names and structure', () => {
    const category = 'clothing';

    render(<Category category={category} />);

    // Check for specific class names and structure
    const container = screen.getByText(category).closest('div');
    expect(container).toHaveClass('flex flex-col h-[15vh] bg-[#383838] max-w-[15vh] rounded-lg items-center p-3 gap-2');

    const imageContainer = screen.getByRole('img').closest('div');
    expect(imageContainer).toHaveClass('h-16 w-16 flex justify-center items-center');
  });
});
