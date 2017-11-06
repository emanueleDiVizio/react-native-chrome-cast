import { DeviceEventEmitter, NativeModules } from 'react-native';

const NativeChromeCast = NativeModules.RNChromeCast;

export default class ChromeCastScanner {
  constructor() {
    this.listenForSessionEvents = cb => DeviceEventEmitter.addListener('ChromeCastSessionEvent', (e) => {
      cb({ status: e.SESSION_STATUS, message: e.SESSION_STATUS_MESSAGE });
    });

    this.listenForScanEvent = cb => DeviceEventEmitter.addListener('ChromeCastScanEvent', (e) => {
      cb({
        deviceConnected: e.DEVICE_CONNECTED,
        deviceConnecting: e.DEVICE_CONNECTING,
        devicesAvailable: e.DEVICES_AVAILABLE,
      });
    });
  }


  setUp = () => {
    NativeChromeCast.setUpScanner();
  };

  startScan = (scanCb, sessionCb) => {
    NativeChromeCast.startScan();
    this.scanListener = this.listenForScanEvent(scanCb);
    this.sessionListener = this.listenForSessionEvents(sessionCb);
  };

  stopScan = () => {
    this.scanListener.remove();
    this.sessionListener.remove();
    NativeChromeCast.stopScan();
  };
}
