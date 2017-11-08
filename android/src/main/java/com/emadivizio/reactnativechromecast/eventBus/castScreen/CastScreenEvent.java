package com.emadivizio.reactnativechromecast.eventBus.castScreen;

import com.emadivizio.reactnativechromecast.react.eventBus.utils.DataType;
import com.emadivizio.reactnativechromecast.constants.CastScreen;
import com.emadivizio.reactnativechromecast.react.eventBus.events.ReactActionEvent;

/**
 * Created by Emanuele on 08/11/2017.
 */

public class CastScreenEvent<T> extends ReactActionEvent<T> {
    public CastScreenEvent(String action, T argument, DataType valueType) {
        super(CastScreen.CAST_SCREEN_EVENT, action, CastScreen.CAST_SCREEN_ACTION, argument, valueType);
    }
}
