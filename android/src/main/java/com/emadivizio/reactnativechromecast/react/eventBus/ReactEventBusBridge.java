package com.emadivizio.reactnativechromecast.react.eventBus;

import com.emadivizio.reactnativechromecast.react.eventBus.utils.DataType;
import com.emadivizio.reactnativechromecast.react.eventBus.utils.TypeAwareMap;
import com.emadivizio.reactnativechromecast.eventBus.castScreen.CastScreenEvent;
import com.emadivizio.reactnativechromecast.react.eventBus.events.ReactActionEvent;
import com.emadivizio.reactnativechromecast.react.eventBus.events.data.Field;
import com.emadivizio.reactnativechromecast.react.eventBus.events.data.ReactDataEvent;
import com.emadivizio.reactnativechromecast.eventBus.playback.PlaybackEvent;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Emanuele on 08/11/2017.
 */

public class ReactEventBusBridge {

    private ReactContext mReactContext;

    public ReactEventBusBridge(ReactContext reactContex) {
        this.mReactContext = reactContex;
    }


    public void register(){
        EventBus.getDefault().register(this);
    }

    public void unregister(){
        EventBus.getDefault().unregister(this);
    }



    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPlaybackEvent(PlaybackEvent event) {
        pushEventToReactBridge(event);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCastScreenEvent(CastScreenEvent event) {
        pushEventToReactBridge(event);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDataEvent(ReactDataEvent event) {
        pushEventToReactBridge(event);
    }

    private void pushEventToReactBridge(ReactActionEvent event){
        TypeAwareMap map = new TypeAwareMap(Arguments.createMap());

        map.putValue(event.getActionType(), event.getAction(), DataType.STRING);
        map.putValue(event.getAction(), event.getArgument(), event.getArgType());

        mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
            .emit(event.getChannel(), map.getWritableMap());
    }

    private void pushEventToReactBridge(ReactDataEvent event){
        TypeAwareMap map = new TypeAwareMap(Arguments.createMap());

        for(Field<?> field : event.getFields()){
            map.putValue(field.getName(), field.getValue(), field.getValueType());
        }

        mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
            .emit(event.getChannel(), map.getWritableMap());
    }

}
