import { NativeModules, NativeEventEmitter } from 'react-native';
import { DevicesStatus } from '../../utils/iosConstants';

const { GoogleCast } = NativeModules;

const ChromecastEmitter = new NativeEventEmitter(GoogleCast);


export default class ChromeCastScanner {
  chromeCastDeviceAvailable = cb => ChromecastEmitter.addListener(
    DevicesStatus.DEVICE_AVAILABLE,
    e => cb({
      devicesAvailable: e.device_available,
    }));
  chromeCastDeviceUpdated = cb => ChromecastEmitter.addListener(
    DevicesStatus.DEVICES_UPDATED,
    e => cb({
      devicesList: e.devices,
    }));

  startScan(cb) {
    GoogleCast.startScan();
    this.availableListener = this.chromeCastDeviceAvailable(cb);
    this.updatedListener = this.chromeCastDeviceUpdated(cb);
  }

  stopScan() {
    this.availableListener.remove();
    this.updatedListener.remove();
    GoogleCast.stopScan();
  }
}
