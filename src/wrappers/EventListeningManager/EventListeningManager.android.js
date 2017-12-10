import { NativeModules } from 'react-native';

const NativeChromeCast = NativeModules.RNChromeCast;

class EventListeningManager {
  isListening = false;

  setUp() {
    if (!this.isListening) {
      NativeChromeCast.startListeningForEvents();
      this.isListening = true;
    }
  }

  cleanUp() {
    if (this.isListening) {
      NativeChromeCast.stopListeningForEvents();
      this.isListening = false;
    }
  }
}

export default new EventListeningManager();
