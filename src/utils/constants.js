import { NativeModules } from 'react-native';

const NativeChromeCast = NativeModules.RNChromeCast;

export const CastScanConstants = NativeChromeCast.CAST_SCAN;
export const CastSessionConstants = NativeChromeCast.CAST_SESSION;
export const CastScreenConstants = NativeChromeCast.CAST_SCREEN;
export const CastPlaybackConstants = NativeChromeCast.CAST_PLAYBACK;

export const Events = Object.freeze({
  CAST_PLAYBACK: CastPlaybackConstants.EVENT_NAME,
  CAST_SCAN: CastScanConstants.EVENT_NAME,
  CAST_SCREEN: CastScreenConstants.EVENT_NAME,
  CAST_SESSION: CastPlaybackConstants.EVENT_NAME,
});
