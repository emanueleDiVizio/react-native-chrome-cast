import { Platform } from 'react-native';

import { SessionStatus } from './src/utils/constants';
import Scanner from './src/wrappers/Scanner';
import Playback from './src/wrappers/Playback';
import ConnectionManager from './src/wrappers/ConnectionManager';
import EventListeningManager from './src/wrappers/EventListeningManager';
import ChromeCastWrapper from './src/wrappers/ChromeCast';
import Button from './src/components/Button';
import MiniController from './src/components/MiniController';

export const ChromeCast =
  Platform.OS === 'ios' ? ChromeCastWrapper : new ChromeCastWrapper();
export const ChromeCastScanner = new Scanner();
export const ChromeCastPlayback = new Playback();
export const ChromeCastConnectionManager = new ConnectionManager();
export const ChromeCastEventsManager = new EventListeningManager();

export const ChromeCastSessionStatus = SessionStatus;

export const ChromeCastButton = Button;
export const ChromeCastMiniController = MiniController;
