import React from 'react';
import { render, screen } from '@testing-library/react';
import '@testing-library/jest-dom';
import { useParams } from 'react-router-dom';
import Products from '../../pages/Products/Products';
import { store } from '../../context/store';
import PopularCard from '../../components/Popularcard/PopularCard';

// Mock useParams
jest.mock('react-router-dom', () => ({
  useParams: jest.fn(),
}));

// Mock PopularCard component
jest.mock('../../components/Popularcard/PopularCard', () => () => <div>PopularCard Mock</div>);

describe('Products Component', () => {
  const mockItemData = [
    {
      category: 'electronics',
      items: [{ name: 'Laptop' }, { name: 'Smartphone' }]
    },
    {
      category: 'furniture',
      items: [{ name: 'Chair' }, { name: 'Table' }]
    }
  ];

  const renderWithStore = (ui, { providerProps, ...renderOptions }) => {
    return render(
      <store.Provider {...providerProps}>{ui}</store.Provider>,
      renderOptions,
    );
  };

  test('renders products based on category and handles no products found', () => {
    // Mock useParams to return the desired category
    useParams.mockReturnValue({ category: 'electronics' });

    const providerProps = {
      value: {
        ItemData: mockItemData,
      },
    };

    // Render the component with the mock context provider
    renderWithStore(<Products />, { providerProps });

    // Check if products are rendered correctly
    expect(screen.getAllByText('PopularCard Mock').length).toBe(2);

    // Check if error message is displayed when no products are found
    useParams.mockReturnValue({ category: 'toys' });
    renderWithStore(<Products />, { providerProps });

    expect(screen.getByText('No products found')).toBeInTheDocument();
  });

  test('renders no products message when category is empty', () => {
    useParams.mockReturnValue({ category: '' });

    const providerProps = {
      value: {
        ItemData: mockItemData,
      },
    };

    renderWithStore(<Products />, { providerProps });

    // Ensure the error message for no products is displayed
    expect(screen.getByText('No products found')).toBeInTheDocument();
  });

  test('renders no products message when ItemData is empty', () => {
    useParams.mockReturnValue({ category: 'electronics' });

    const providerProps = {
      value: {
        ItemData: [], // Empty data
      },
    };

    renderWithStore(<Products />, { providerProps });

    // Ensure the error message for no products is displayed
    expect(screen.getByText('No products found')).toBeInTheDocument();
  });

  test('handles category with no products correctly', () => {
    useParams.mockReturnValue({ category: 'furniture' });

    const providerProps = {
      value: {
        ItemData: [
          {
            category: 'electronics',
            items: [{ name: 'Laptop' }]
          }
        ],
      },
    };

    renderWithStore(<Products />, { providerProps });

    // Ensure the error message for no products is displayed
    expect(screen.getByText('No products found')).toBeInTheDocument();
  });
});
