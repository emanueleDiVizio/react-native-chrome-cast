module.exports = {
  extends: 'airbnb',
  plugins: ['react'],
  parser: 'babel-eslint',
  env: {jest: true},
  rules: {
    'no-mixed-operators': 0,
    'react/forbid-prop-types': 0,
    'no-console': 0,
    'import/no-unresolved': [
      2,
      {
        ignore: ['^react$', '^react-native$', '^react-native/'],
      },
    ],
    'react/jsx-filename-extension': [
      1,
      {
        extensions: ['.js', '.jsx'],
      },
    ],
    'import/no-extraneous-dependencies': [
      'error',
      {
        devDependencies: true,
      },
    ],
    'no-bitwise': [
      'error',
      {
        allow: ['^'],
      },
    ],
    'no-restricted-syntax': ['error', 'ForInStatement', 'LabeledStatement', 'WithStatement'],
  },
  settings: {
    'import/resolver': {
      node: {
        extensions: ['.js', '.android.js', '.ios.js'],
      },
    },
    node: true,
  },
};
