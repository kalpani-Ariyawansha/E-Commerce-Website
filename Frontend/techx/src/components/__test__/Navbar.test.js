import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import { BrowserRouter as Router } from 'react-router-dom';
import NavBar from '../NavBar/NavBar';
import { useNavigate } from 'react-router-dom';

// Mock useNavigate from react-router-dom
jest.mock('react-router-dom', () => ({
  ...jest.requireActual('react-router-dom'),
  useNavigate: jest.fn(),
}));

describe("NavBar", () => {
  it('renders LOGIN button', () => {
    render(
      <Router>
        <NavBar />
      </Router>
    );

    // Check that LOGIN button is present
    const loginButton = screen.getByText('LOGIN');
    expect(loginButton).toBeInTheDocument();
  });

  it('NavBar displays login form when LOGIN button is clicked', () => {
    render(
      <Router>
        <NavBar />
      </Router>
    );

    fireEvent.click(screen.getByText('LOGIN'));
    expect(screen.getByText('Welcome Back')).toBeInTheDocument();
    expect(screen.getByLabelText('User Name')).toBeInTheDocument();
    expect(screen.getByLabelText('Password')).toBeInTheDocument();
  });

  it('displays register form when Register link is clicked', () => {
    render(
      <Router>
        <NavBar />
      </Router>
    );

    // Click the LOGIN button to open the login form
    const loginButton = screen.getByText('LOGIN');
    fireEvent.click(loginButton);

    // Click on Register link to switch to sign-up form
    const registerLink = screen.getByText('Register');
    fireEvent.click(registerLink);

    // Check that the sign-up form is displayed
    expect(screen.getByText('Create an Account')).toBeInTheDocument();
    expect(screen.getByLabelText('Email')).toBeInTheDocument();
    expect(screen.getByLabelText('Mobile Number')).toBeInTheDocument();
    expect(screen.getByLabelText('Password')).toBeInTheDocument();

    // Check that the SIGN UP button is present
    const signUpButton = screen.getByText('SIGN UP');
    expect(signUpButton).toBeInTheDocument();
  });

  it('username field accepts text input', () => {
    render(
      <Router>
        <NavBar />
      </Router>
    );

    // Click the LOGIN button to open the login form
    const loginButton = screen.getByText('LOGIN');
    fireEvent.click(loginButton);

    // Check that the login form is displayed
    const userNameInput = screen.getByLabelText('User Name');
    fireEvent.change(userNameInput, { target: { value: 'testuser' } });

    expect(userNameInput.value).toBe('testuser');
  });

  it('email field accepts email input', () => {
    render(
      <Router>
        <NavBar />
      </Router>
    );

    // Click the LOGIN button to open the login form
    const loginButton = screen.getByText('LOGIN');
    fireEvent.click(loginButton);

    // Click on Register link to switch to sign-up form
    const registerLink = screen.getByText('Register');
    fireEvent.click(registerLink);

    // Check that the email field accepts email input
    const emailInput = screen.getByLabelText('Email');
    fireEvent.change(emailInput, { target: { value: 'test@example.com' } });

    expect(emailInput.value).toBe('test@example.com');
  });

  it('mobile number field accepts text input', () => {
    render(
      <Router>
        <NavBar />
      </Router>
    );

    // Click the LOGIN button to open the login form
    const loginButton = screen.getByText('LOGIN');
    fireEvent.click(loginButton);

    // Click on Register link to switch to sign-up form
    const registerLink = screen.getByText('Register');
    fireEvent.click(registerLink);

    // Check that the mobile number field accepts text input
    const mobileNumberInput = screen.getByLabelText('Mobile Number');
    fireEvent.change(mobileNumberInput, { target: { value: '1234567890' } });

    expect(mobileNumberInput.value).toBe('1234567890');
  });

  it('password field accepts text input', () => {
    render(
      <Router>
        <NavBar />
      </Router>
    );

    // Click the LOGIN button to open the login form
    const loginButton = screen.getByText('LOGIN');
    fireEvent.click(loginButton);

    // Check that the login form is displayed
    const passwordInput = screen.getByLabelText('Password');
    fireEvent.change(passwordInput, { target: { value: 'password123' } });

    expect(passwordInput.value).toBe('password123');
  });

  it('navigates to products page when search icon is clicked', () => {
    const navigate = jest.fn();
    useNavigate.mockReturnValue(navigate);

    render(
      <Router>
        <NavBar />
      </Router>
    );

    // Simulate user typing in the search input
    const input = screen.getByPlaceholderText('Find your product...');
    fireEvent.change(input, { target: { value: 'laptop' } });

    // Simulate clicking the search icon
    const searchIcon = screen.getByTestId('search-icon');
    fireEvent.click(searchIcon);

    // Verify navigation function was called with correct path
    expect(navigate).toHaveBeenCalledWith('/products/laptop');
  });
});
