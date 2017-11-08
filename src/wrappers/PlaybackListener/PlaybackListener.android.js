import { DeviceEventEmitter } from 'react-native';

import { Events, CastPlaybackConstants } from '../../utils/constants';

export default class PlaybackListener {
  listenForPlaybackEvents = cb =>
    DeviceEventEmitter.addListener(Events.CAST_PLAYBACK, (e) => {
      cb({
        action: e[CastPlaybackConstants.PLAYBACK_ACTION],
        arg: e[e[CastPlaybackConstants.PLAYBACK_ACTION]],
      });
    });

  startListening(cb) {
    this.listener = this.listenForPlaybackEvents(cb);
  }

  stopListening() {
    this.listener.remove();
  }
}
