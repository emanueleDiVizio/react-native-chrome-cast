import React, { Component } from 'react';
import { requireNativeComponent, ViewPropTypes } from 'react-native';
import PropTypes from 'prop-types';


const NativeChromeCastButton = requireNativeComponent(
  'RCTChromeCastButton',
  ChromeCastButton,
);

export default class ChromeCastButton extends Component {
  constructor(props) {
    super(props);
    this.scanner = new props.Scanner();
  }

  componentWillMount() {
    this.scanner.setUp();
    const { onScanEventReceived, onSessionEventReceived } = this.props;
    this.scanner.startScan(onScanEventReceived, onSessionEventReceived);
  }

  componentWillUnmount() {
    this.scanner.stopScan();
  }

  render() {
    return <NativeChromeCastButton {...this.props} />;
  }
}

ChromeCastButton.propTypes = {
  onScanEventReceived: PropTypes.func.isRequired,
  onSessionEventReceived: PropTypes.func.isRequired,
  Scanner: PropTypes.func.isRequired,
  ...ViewPropTypes,
};

ChromeCastButton.defaultProps = {
  onScanEventReceived: () => {},
  onSessionEventReceived: () => {},
};
