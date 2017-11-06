import { NativeModules, NativeEventEmitter } from 'react-native';
import { DevicesStatus } from '../../utils/iosConstants';
import { SessionStatus } from '../../utils/constants';

const { GoogleCast } = NativeModules;

const ChromecastEmitter = new NativeEventEmitter(GoogleCast);


export default class ConnectionManager {
  constructor() {
    this.chromeCastDeviceConnected = cb => ChromecastEmitter.addListener(
      DevicesStatus.DEVICE_CONNECTED,
      () => cb({ status: SessionStatus.STARTED, message: '' }));

    this.chromeCastDeviceDisconnected = cb => ChromecastEmitter.addListener(
      DevicesStatus.DEVICE_DISCONNECTED,
      () => cb({ status: SessionStatus.ENDED, message: '' }));
  }

  startConnectionListener = (cb) => {
    this.connectedListener = this.chromeCastDeviceConnected(cb);
    this.disconnectedListener = this.chromeCastDeviceDisconnected(cb);
  };

  stopConnectionListener = () => {
    this.connectedListener.remove();
    this.disconnectedListener.remove();
  };
}
