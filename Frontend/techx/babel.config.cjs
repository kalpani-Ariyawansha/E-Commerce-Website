const presets = [
  '@babel/preset-env',
  '@babel/preset-react'
];

const  plugins = [
  '@babel/plugin-proposal-class-properties', // Support for class properties syntax
    '@babel/plugin-proposal-optional-chaining'
];

module.exports = { presets,plugins };
