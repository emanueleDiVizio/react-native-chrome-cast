package com.emadivizio.reactnativechromecast.eventBus.castSession;

import com.emadivizio.reactnativechromecast.react.eventBus.events.data.ReactDataEventBuilder;
import com.emadivizio.reactnativechromecast.constants.CastSession;

/**
 * Created by Emanuele on 08/11/2017.
 */

public class CastSessionEventBuilder extends ReactDataEventBuilder {

    public CastSessionEventBuilder() {
        super(CastSession.CAST_SESSION_EVENT);
    }
}
