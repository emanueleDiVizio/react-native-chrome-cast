package com.emadivizio.reactnativechromecast.eventBus.castScreen;

import com.emadivizio.reactnativechromecast.react.eventBus.utils.DataType;
import com.emadivizio.reactnativechromecast.constants.CastScreen;
import com.emadivizio.reactnativechromecast.react.eventBus.EventBusBridge;

import static com.emadivizio.reactnativechromecast.constants.CastScreen.CAST_SCREEN_ACTION;

/**
 * Created by Emanuele on 08/11/2017.
 */

public class CastScreenBridge extends EventBusBridge implements CastScreenActionListener {
    private <T> void sendEvent(String action, T argument, DataType argType) {
         postEvent(new CastScreenEvent<T>(action, argument, argType));
    }

    @Override
    public void onStart() {
        sendEvent(CAST_SCREEN_ACTION, CastScreen.ON_SCREEN_OPEN, DataType.NULL);
    }

    @Override
    public void onStop() {
        sendEvent(CastScreen.CAST_SCREEN_ACTION, CastScreen.ON_SCREEN_CLOSE, DataType.NULL);
    }
}
