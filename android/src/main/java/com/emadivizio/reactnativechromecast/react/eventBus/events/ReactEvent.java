package com.emadivizio.reactnativechromecast.react.eventBus.events;

/**
 * Created by Emanuele on 08/11/2017.
 */

public class ReactEvent {
    private final String channel;

    public ReactEvent(String channel) {
        this.channel = channel;
    }


    public String getChannel() {
        return channel;
    }
}

