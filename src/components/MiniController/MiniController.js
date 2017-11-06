import React, { Component } from 'react';
import { requireNativeComponent, View, ViewPropTypes } from 'react-native';
import PropTypes from 'prop-types';

const NativeChromeCastMiniController = requireNativeComponent(
  'RCTChromeCastMiniController',
  ChromeCastMiniController,
);

const ChromeCastMiniController = props => (
  <View>
    <NativeChromeCastMiniController {...props} />
  </View>
);

ChromeCastMiniController.propTypes = {
  progress: PropTypes.number.isRequired,
  indeterminate: PropTypes.bool.isRequired,
  ...ViewPropTypes,
};

export default ChromeCastMiniController;
