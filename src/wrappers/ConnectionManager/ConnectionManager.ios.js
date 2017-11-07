import { NativeModules, NativeEventEmitter } from 'react-native';
import { DevicesStatus } from '../../utils/iosConstants';
import { SessionStatus } from '../../utils/constants';

const { GoogleCast } = NativeModules;

const ChromecastEmitter = new NativeEventEmitter(GoogleCast);

export default class ChromeCastConnectionManager {
  chromeCastDeviceConnected = (cb) => {
    this.connectedListener = ChromecastEmitter.addListener(
      DevicesStatus.DEVICE_CONNECTED, () =>
        cb({ status: SessionStatus.STARTED, message: '' }),
    );
  }

  chromeCastDeviceDisconnected = (cb) => {
    this.disconnectedListener = ChromecastEmitter.addListener(
      DevicesStatus.DEVICE_DISCONNECTED, () =>
        cb({ status: SessionStatus.ENDED, message: '' }),
    );
  }

  startConnectionListener(cb) {
    this.chromeCastDeviceConnected(cb);
    this.chromeCastDeviceDisconnected(cb);
  }

  stopConnectionListener() {
    this.connectedListener.remove();
    this.disconnectedListener.remove();
  }
}
