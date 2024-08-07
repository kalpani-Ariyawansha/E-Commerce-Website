
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
});
