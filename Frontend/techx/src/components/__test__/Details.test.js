
import React from 'react';
import { render, screen } from '@testing-library/react';
import '@testing-library/jest-dom';
import { MemoryRouter, Route, Routes } from 'react-router-dom';
import Detail from '../../pages/Details/Detail';
import MSI from '../../assets/msi.png';

const renderWithRouter = (ui, { route = '/' } = {}) => {
  window.history.pushState({}, 'Test page', route);

  return render(
    <MemoryRouter initialEntries={[route]}>
      <Routes>
        <Route path="*" element={ui} />
      </Routes>
    </MemoryRouter>
  );
};

describe('Detail Component', () => {
  const mockItem = {
    title: 'Test Item',
    description: 'This is a test item',
    price: '$99.99',
    feature1: 'Feature 1',
    feature2: 'Feature 2',
  };

  test('renders item details correctly', () => {
    renderWithRouter(<Detail />, { route: { pathname: '/detail', state: { item: mockItem } } });

    expect(screen.getByText('Test Item')).toBeInTheDocument();
    expect(screen.getByText('This is a test item')).toBeInTheDocument();
    expect(screen.getByText('$99.99')).toBeInTheDocument();
    expect(screen.getByText('Feature 1')).toBeInTheDocument();
    expect(screen.getByText('Feature 2')).toBeInTheDocument();
    expect(screen.getByAltText('MSI')).toHaveAttribute('src', MSI);
  });

  test('renders no item details available message', () => {
    renderWithRouter(<Detail />, { route: { pathname: '/detail' } });

    expect(screen.getByText('No item details available.')).toBeInTheDocument();
  });
});
