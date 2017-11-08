package com.emadivizio.reactnativechromecast.eventBus.playback;

import com.emadivizio.reactnativechromecast.react.eventBus.utils.DataType;
import com.emadivizio.reactnativechromecast.react.eventBus.events.ReactActionEvent;
import com.emadivizio.reactnativechromecast.constants.Playback;

/**
 * Created by Emanuele on 08/11/2017.
 */

public class PlaybackEvent<T> extends ReactActionEvent<T> {

    public PlaybackEvent(String action, T argument, DataType argType) {
        super(Playback.CAST_PLAYBACK_EVENT, action, Playback.PLAYBACK_ACTION, argument, argType);
    }
}
