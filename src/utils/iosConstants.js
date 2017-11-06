import { NativeModules } from 'react-native';

const { GoogleCast } = NativeModules;

export const DevicesStatus = {
  DEVICE_AVAILABLE: GoogleCast.DEVICE_AVAILABLE,
  DEVICES_UPDATED: GoogleCast.DEVICES_UPDATED,
  DEVICE_CONNECTED: GoogleCast.DEVICE_CONNECTED,
  DEVICE_DISCONNECTED: GoogleCast.DEVICE_DISCONNECTED,
};

export const PlaybackStatus = {
  MEDIA_LOADED: GoogleCast.MEDIA_LOADED,

};
