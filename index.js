import { SessionStatus } from './src/utils/constants';
import Scanner from './src/wrappers/Scanner';
import Playback from './src/wrappers/Playback';
import ConnectionManager from './src/wrappers/ConnectionManager/index';
import ChromeCastWrapper from './src/wrappers/ChromeCast';
import Button from './src/components/Button';
import MiniController from './src/components/MiniController';

export const ChromeCast = ChromeCastWrapper;

export const ChromeCastScanner = Scanner;
export const ChromeCastPlayback = Playback;
export const ChromeCastConnectionManager = ConnectionManager;
export const ChromeCastSessionStatus = SessionStatus;

export const ChromeCastButton = Button;
export const ChromeCastMiniController = MiniController;
