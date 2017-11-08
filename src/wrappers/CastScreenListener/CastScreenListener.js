import { DeviceEventEmitter, NativeModules } from 'react-native';

import { Events, CastScreenConstants } from '../../utils/constants';

export default class ChromeCastPlayback {
  listenForPlaybackEvents = cb =>
    DeviceEventEmitter.addListener(Events.CAST_SCREEN, (e) => {
      cb({ action: e[CastScreenConstants.CAST_SCREEN_ACTION] });
    });

  startListening(cb) {
    this.listener = this.listenForPlaybackEvents(cb);
  }

  stopListening() {
    this.listener.remove();
  }
}
