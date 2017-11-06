import React from 'react';
import ChromeCastButton from './Button';
import ChromeCastScanner from '../../wrappers/Scanner';

export default () => (
  <ChromeCastButton Scanner={ChromeCastScanner} />
);
