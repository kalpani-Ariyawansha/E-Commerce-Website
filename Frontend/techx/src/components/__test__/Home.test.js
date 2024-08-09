
import React from 'react';
import { render, screen } from '@testing-library/react';
import '@testing-library/jest-dom';
import Home from '../../pages/Home/Home';
import { categories, specialOffer } from '../../assets/data/data';
import { MemoryRouter } from 'react-router-dom';

// Mocking components and data
jest.mock('../../components/Popularcard/PopularCard', () => () => <div>PopularCard Mock</div>);
jest.mock('../../components/Category/Category', () => ({ category }) => <div>{category}</div>);
jest.mock('../../components/Header/Header', () => ({ item }) => <div>{item.title}</div>);
jest.mock('../../components/Contact/Contact', () => () => <div>Contact Mock</div>);

describe('Home Component', () => {
  test('renders header section with special offers', () => {
    render(
      <MemoryRouter>
        <Home />
      </MemoryRouter>
    );

    specialOffer.forEach(offer => {
      expect(screen.getByText(offer.title)).toBeInTheDocument();
    });
  });

  test('renders categories section', () => {
    render(
      <MemoryRouter>
        <Home />
      </MemoryRouter>
    );

    expect(screen.getByText('CATEGORIES')).toBeInTheDocument();
    expect(screen.getByText('What tech essentials are you shopping for?')).toBeInTheDocument();

    categories.forEach(category => {
      expect(screen.getByText(category)).toBeInTheDocument();
    });
  });

  test('renders popular products section', () => {
    render(
      <MemoryRouter>
        <Home />
      </MemoryRouter>
    );

    expect(screen.getByText('POPULAR PRODUCTS')).toBeInTheDocument();
    expect(screen.getByText('Looking for the best in tech?')).toBeInTheDocument();

    const popularCards = screen.getAllByText('PopularCard Mock');
    expect(popularCards).toHaveLength(4);
  });

  test('renders contact us section', () => {
    render(
      <MemoryRouter>
        <Home />
      </MemoryRouter>
    );

    expect(screen.getByText('Contact Mock')).toBeInTheDocument();
  });
});
