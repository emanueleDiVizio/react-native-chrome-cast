import React from 'react';
import ChromeCastButton from './Button';
import ChromeCastScanner from '../../wrappers/Scanner';

export default props => (
  <ChromeCastButton Scanner={ChromeCastScanner} {...props} />
);
