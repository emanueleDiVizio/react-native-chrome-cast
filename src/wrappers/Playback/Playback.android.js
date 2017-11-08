import { DeviceEventEmitter } from 'react-native';

import { Events, CastPlaybackConstants } from '../../utils/constants';

export default class ChromeCastPlayback {
  listenForPlaybackEvents = cb =>
    DeviceEventEmitter.addListener(Events.CAST_PLAYBACK, (e) => {
      cb({
        action: e[CastPlaybackConstants.PLAYBACK_ACTION],
        arg: e[e[CastPlaybackConstants.PLAYBACK_ACTION]],
      });
    });

  startScan(cb) {
    this.listener = this.listenForPlaybackEvents(cb);
  }

  stopScan() {
    this.listener.remove();
  }
}
