/** @type {import('jest').Config} */
const config = {
  testEnvironment: 'jest-environment-jsdom',
  transform: {
    '^.+\\.jsx?$': 'babel-jest',  // Transform JavaScript and JSX files
    '^.+\\.mjs$': 'babel-jest',   // Transform ES modules
    "^.+\\.(css|svg|png)$": "jest-transform-stub"
  },
  moduleNameMapper: {
    '\\.(css|less|scss|sass)$': 'identity-obj-proxy', // Mock CSS imports
    '\\.(jpg|jpeg|png|gif|webp|svg)$': '<rootDir>/__mocks__/fileMock.js', // Mock image imports
  },
  setupFilesAfterEnv: ['<rootDir>/src/setupTests.js'], // Setup file for additional configurations or mocks
  transformIgnorePatterns: [
    "/node_modules/(?!swiper|react-icons).+\\.mjs$", // Transform .mjs files from swiper and react-icons
    "/node_modules/(?!(swiper|other-package-to-transform)/)"
  ],
  collectCoverage: true, // Enable coverage collection
  coverageDirectory: "coverage", // Directory where Jest should output its coverage files
  coverageReporters: ["html", "text"], // Report formats to generate
  coverageThreshold: {
    global: {
      branches: 80, // Minimum % of branches covered
      functions: 80, // Minimum % of functions covered
      lines: 80, // Minimum % of lines covered
      statements: 80 // Minimum % of statements covered
    }
  }
};

module.exports = config;
