package com.emadivizio.reactnativechromecast.react.eventBus;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Emanuele on 08/11/2017.
 */

public class EventBusBridge {

    public void postEvent(Object event){
        EventBus.getDefault().post(event);

    }
}
