package com.emadivizio.reactnativechromecast.react.eventBus.events.data;

import com.emadivizio.reactnativechromecast.react.eventBus.events.ReactEvent;

import java.util.List;

/**
 * Created by Emanuele on 08/11/2017.
 */

public final class ReactDataEvent extends ReactEvent {
    private final List<Field<?>> fields;

    public ReactDataEvent(String channel, List<Field<?>> fields) {
        super(channel);
        this.fields = fields;
    }


    public final List<Field<?>> getFields() {
        return fields;
    }
}
