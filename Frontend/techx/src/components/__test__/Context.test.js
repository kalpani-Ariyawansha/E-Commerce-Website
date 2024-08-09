import React, { useContext } from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import StoreProvider, { store } from '../../context/store'
import { products } from '../../assets/data/data'

// Mock data file
jest.mock('../../assets/data/data', () => ({
  products: [
    { id: 1, name: 'Product 1' },
    { id: 2, name: 'Product 2' }
  ]
}));

const TestComponent = () => {
  const { userData, ItemData, SetUserData } = useContext(store);

  return (
    <div>
      <div>userData: {userData ? userData : 'null'}</div>
      <div>ItemData: {JSON.stringify(ItemData)}</div>
      <button onClick={() => SetUserData('New User')}>Set User Data</button>
    </div>
  );
};

describe('StoreProvider Component', () => {
  it('initializes ItemData state from products data', () => {
    render(
      <StoreProvider>
        <TestComponent />
      </StoreProvider>
    );

    // Check if the initial ItemData is set from the products data
    expect(screen.getByText(/ItemData: \[{"id":1,"name":"Product 1"},{"id":2,"name":"Product 2"}\]/)).toBeInTheDocument();
  });

  it('provides context values to child components', () => {
    render(
      <StoreProvider>
        <TestComponent />
      </StoreProvider>
    );

    // Check if the initial userData is null
    expect(screen.getByText(/userData: null/)).toBeInTheDocument();

    // Check if the SetUserData function works correctly
    const button = screen.getByText('Set User Data');
    fireEvent.click(button);
    expect(screen.getByText(/userData: New User/)).toBeInTheDocument();
  });
});
