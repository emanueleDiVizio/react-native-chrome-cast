import { NativeModules, NativeEventEmitter } from 'react-native';
import { PlaybackStatus } from '../../utils/constants';

const { GoogleCast } = NativeModules;
const ChromecastEmitter = new NativeEventEmitter(GoogleCast);

export default class PlaybackListener {
  onChromeCastMediaLoaded(cb) {
    this.mediaLoaded = ChromecastEmitter.addListener(
      PlaybackStatus.MEDIA_LOADED,
      () =>
        cb({
          casting: true
        })
    );
  }

  startMediaLoadedListener(cb) {
    this.onChromeCastMediaLoaded(cb);
  }

  stopMediaLoadedListener() {
    this.mediaLoaded.remove();
  }
}
