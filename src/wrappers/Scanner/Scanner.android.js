import { DeviceEventEmitter, NativeModules } from 'react-native';

import {
  Events,
  CastScanConstants,
  CastSessionConstants,
} from '../../utils/constants';

const NativeChromeCast = NativeModules.RNChromeCast;

export default class ChromeCastScanner {
  listenForSessionEvents = cb =>
    DeviceEventEmitter.addListener(Events.CAST_SESSION, (e) => {
      cb({
        status: e[CastSessionConstants.SESSION_STATUS],
        message: e[CastSessionConstants.SESSION_STATUS_MESSAGE],
      });
    });

  listenForScanEvent = cb =>
    DeviceEventEmitter.addListener(Events.CAST_SCAN, (e) => {
      cb({
        deviceConnected: e[CastScanConstants.DEVICE_CONNECTED],
        deviceConnecting: e[CastScanConstants.DEVICE_CONNECTING],
        devicesAvailable: e[CastScanConstants.DEVICES_AVAILABLE],
      });
    });

  setUp() {
    NativeChromeCast.setUpScanner();
  }

  startScan(scanCb, sessionCb) {
    NativeChromeCast.startScan();
    this.scanListener = this.listenForScanEvent(scanCb);
    this.sessionListener = this.listenForSessionEvents(sessionCb);
  }

  stopScan() {
    this.scanListener.remove();
    this.sessionListener.remove();
    NativeChromeCast.stopScan();
  }
}
