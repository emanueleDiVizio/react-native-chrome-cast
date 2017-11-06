import { PlaybackStatus } from '../../utils/iosConstants';

const { GoogleCast } = NativeModules;
const ChromecastEmitter = new NativeEventEmitter(GoogleCast);

export default class Playback {
  onChromeCastMediaLoaded = cb => ChromecastEmitter.addListener(
    PlaybackStatus.MEDIA_LOADED,
    () => cb({
      playing: true,
    }));
}
