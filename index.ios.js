import { NativeModules, requireNativeComponent } from 'react-native';
import Scanner from './src/wrappers/Scanner';
import Playback from './src/wrappers/Playback';
import ConnectionManager from './src/wrappers/ConnectionManager/index';

const { GoogleCast } = NativeModules;


export const ChromeCastScanner = Scanner;
export const ChromeCast = GoogleCast;
export const ChromeCastPlayback = Playback;
export const ChromeCastConnectionManager = ConnectionManager;
export const button = requireNativeComponent('GoogleCast', null);


// export default {
//
//   isConnected() {
//     return GoogleCast.isConnected();
//   },
//   getDevices() {
//     return GoogleCast.getDevices();
//   },
//   connectToDevice(deviceId: string) {
//     GoogleCast.connectToDevice(deviceId);
//   },
//   disconnect() {
//     GoogleCast.disconnect();
//   },
//   castMedia(mediaUrl: string, title: string, imageUrl: string, seconds: number = 0) {
//     GoogleCast.castMedia(mediaUrl, title, imageUrl, seconds);
//   },
//   seekCast(seconds: number) {
//     GoogleCast.seekCast(seconds);
//   },
//   togglePauseCast() {
//     GoogleCast.togglePauseCast();
//   },
//   getStreamPosition() {
//     return GoogleCast.getStreamPosition();
//   },
// };
