import { NativeModules } from 'react-native';

const NativeChromeCast = NativeModules.RNChromeCast;

export default class ChromeCastWrapper {
  constructor() {
    this.isAvailable = true;
  }

  runIfAvailable = (func) => {
    if (this.isAvailable) {
      return func().then(() => Promise.resolve(this));
    }
    return Promise.reject(new Error('Player not available.'));
  };

  setUnavailable = () => {
    this.isAvailable = false;
    return Promise.resolve(this);
  };

  setAvailable = () => {
    this.isAvailable = true;
    return Promise.resolve(this);
  };

  loadVideo(video) {
    return NativeChromeCast.loadVideo(
      video.url,
      video.title,
      video.subtitle,
      video.image,
      video.duration,
      false,
      video.mimeType,
      video.progress,
    ).then(() => this.setAvailable());
  }

  loadLiveVideo(video) {
    return NativeChromeCast.loadVideo(
      video.url,
      video.title,
      video.subtitle,
      video.image,
      0,
      true,
      video.mimeType,
      0,
    ).then(() => this.setAvailable());
  }

  play() {
    return this.runIfAvailable(() => NativeChromeCast.play());
  }
  pause() {
    return this.runIfAvailable(() => NativeChromeCast.pause());
  }

  toggle() {
    return this.runIfAvailable(() => NativeChromeCast.toggle());
  }

  stop() {
    return this.runIfAvailable(() =>
      NativeChromeCast.stop().then(() => this.setUnavailable()),
    );
  }

  showChromeCastActivity() {
    return NativeChromeCast.showChromeCastActivity();
  }
}
