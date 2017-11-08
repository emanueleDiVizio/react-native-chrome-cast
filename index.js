import { Platform } from 'react-native';

import * as _Constants from './src/utils/constants';
import Scanner from './src/wrappers/Scanner';
import PlaybackListener from './src/wrappers/PlaybackListener';
import CastScreenListener from './src/wrappers/CastScreenListener';
import ConnectionManager from './src/wrappers/ConnectionManager';
import EventListeningManager from './src/wrappers/EventListeningManager';
import ChromeCastWrapper from './src/wrappers/ChromeCast';
import Button from './src/components/Button';
import MiniController from './src/components/MiniController';

export const ChromeCast =
  Platform.OS === 'ios' ? ChromeCastWrapper : new ChromeCastWrapper();

export const ChromeCastScanner = new Scanner();
export const ChromeCastConnectionManager = new ConnectionManager();

export const ChromeCastEventsManager = EventListeningManager;
export const ChromeCastPlaybackListener = new PlaybackListener();
export const ChromeCastScreenListener = new CastScreenListener();

export const ChromeCastButton = Button;
export const ChromeCastMiniController = MiniController;

export const Constants = _Constants;
