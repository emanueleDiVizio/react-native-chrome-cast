import { NativeModules, NativeEventEmitter } from 'react-native';

import { DevicesStatus, CastSessionConstants } from '../../utils/constants';

const { GoogleCast } = NativeModules;

const ChromecastEmitter = new NativeEventEmitter(GoogleCast);

export default class ChromeCastConnectionManager {
  chromeCastDeviceConnected = (cb) => {
    this.connectedListener = ChromecastEmitter.addListener(
      DevicesStatus.DEVICE_CONNECTED,
      () => cb({ status: CastSessionConstants.SESSION_STARTED, message: '' }),
    );
  };

  chromeCastDeviceDisconnected = (cb) => {
    this.disconnectedListener = ChromecastEmitter.addListener(
      DevicesStatus.DEVICE_DISCONNECTED,
      () => cb({ status: CastSessionConstants.SESSION_ENDED, message: '' }),
    );
  };

  startConnectionListener(cb) {
    this.chromeCastDeviceConnected(cb);
    this.chromeCastDeviceDisconnected(cb);
  }

  stopConnectionListener() {
    this.connectedListener.remove();
    this.disconnectedListener.remove();
  }
}
