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
  let navigate;

  beforeEach(() => {
    navigate = jest.fn();
    useNavigate.mockReturnValue(navigate);
  });

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

    const loginButton = screen.getByText('LOGIN');
    fireEvent.click(loginButton);

    const registerLink = screen.getByText('Register');
    fireEvent.click(registerLink);

    expect(screen.getByText('Create an Account')).toBeInTheDocument();
    expect(screen.getByLabelText('Email')).toBeInTheDocument();
    expect(screen.getByLabelText('Mobile Number')).toBeInTheDocument();
    expect(screen.getByLabelText('Password')).toBeInTheDocument();

    const signUpButton = screen.getByText('SIGN UP');
    expect(signUpButton).toBeInTheDocument();
  });

  it('username field accepts text input', () => {
    render(
      <Router>
        <NavBar />
      </Router>
    );

    const loginButton = screen.getByText('LOGIN');
    fireEvent.click(loginButton);

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

    const loginButton = screen.getByText('LOGIN');
    fireEvent.click(loginButton);

    const registerLink = screen.getByText('Register');
    fireEvent.click(registerLink);

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

    const loginButton = screen.getByText('LOGIN');
    fireEvent.click(loginButton);

    const registerLink = screen.getByText('Register');
    fireEvent.click(registerLink);

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

    const loginButton = screen.getByText('LOGIN');
    fireEvent.click(loginButton);

    const passwordInput = screen.getByLabelText('Password');
    fireEvent.change(passwordInput, { target: { value: 'password123' } });

    expect(passwordInput.value).toBe('password123');
  });

  it('navigates to products page when search icon is clicked', () => {
    render(
      <Router>
        <NavBar />
      </Router>
    );

    fireEvent.change(screen.getByPlaceholderText('Find your product...'), { target: { value: 'laptop' } });
    fireEvent.click(screen.getByTestId('search-icon'));

    expect(navigate).toHaveBeenCalledWith('/products/laptop');
  });

  it('closes the login form when the close button is clicked', () => {
    render(
      <Router>
        <NavBar />
      </Router>
    );

    fireEvent.click(screen.getByText('LOGIN'));
    fireEvent.click(screen.getByTestId('close-icon'));

    expect(screen.queryByText('Welcome Back')).not.toBeInTheDocument();
  });

  it('navigates to home page when HOME link is clicked', () => {
    render(
      <Router>
        <NavBar />
      </Router>
    );

    fireEvent.click(screen.getByText('HOME'));

    expect(navigate).toHaveBeenCalledWith('/');
  });

  it('navigates to support page when SUPPORT link is clicked', () => {
    render(
      <Router>
        <NavBar />
      </Router>
    );

    fireEvent.click(screen.getByText('SUPPORT'));

    expect(navigate).toHaveBeenCalledWith('/support');
  });

  it('handles form input focus correctly', () => {
    render(
      <Router>
        <NavBar />
      </Router>
    );

    fireEvent.click(screen.getByText('LOGIN'));

    const userNameInput = screen.getByLabelText('User Name');
    userNameInput.focus();
    expect(userNameInput).toHaveFocus();
  });
});
