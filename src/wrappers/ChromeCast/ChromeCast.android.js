import { NativeModules } from 'react-native';

const NativeChromeCast = NativeModules.RNChromeCast;

export default class ChromeCastWrapper {
  constructor() {
    this.isAvailable = true;
    this.this.runIfAvailable = (func) => {
      if (this.isAvailable) {
        return func().then(() => Promise.resolve(this));
      }
      return Promise.reject(new Error('Player not available.'));
    };

    this.setUnavailable = () => {
      this.isAvailable = false;
      return Promise.resolve(this);
    };

    this.setAvailable = () => {
      this.isAvailable = true;
      return Promise.resolve(this);
    };
  }


  loadVideo = video => NativeChromeCast.loadVideo(
    video.url,
    video.title,
    video.subtitle,
    video.image,
    video.duration,
    false,
    video.mimeType,
  ).then(() => this.setAvailable());

  loadLiveVideo = video => NativeChromeCast.loadVideo(
    video.url,
    video.title,
    video.subtitle,
    video.image,
    0,
    true,
    video.mimeType,
  ).then(() => this.setAvailable());

  start = progress => this.runIfAvailable(() => NativeChromeCast.start(progress));

  play = () => this.runIfAvailable(() => NativeChromeCast.play());


  pause = () => this.runIfAvailable(() => NativeChromeCast.pause());

  stop = () => this.runIfAvailable(() =>
    NativeChromeCast.stop().then(() => this.setUnavailable()),
  );

  showChromeCastActivity = () => NativeChromeCast.showChromeCastActivity();
}
