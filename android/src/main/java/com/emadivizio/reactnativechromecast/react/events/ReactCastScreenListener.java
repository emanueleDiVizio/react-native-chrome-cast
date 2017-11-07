package com.emadivizio.reactnativechromecast.react.events;

import com.emadivizio.reactnativechromecast.util.Constants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

/**
 * Created by Emanuele on 12/09/2017.
 */
public class ReactCastScreenListener {

  private ReactContext mReactContext;

  public ReactCastScreenListener(ReactContext mReactContext) {
    this.mReactContext = mReactContext;
  }

  public void onScreenOpen() {
    WritableMap map = Arguments.createMap();
    map.putString(Constants.CAST_SCREEN_ACTION, Constants.ON_SCREEN_OPEN);
    mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
          .emit(Constants.CAST_SCREEN_EVENT, map);
  }

  public void onScreenClose() {
    WritableMap map = Arguments.createMap();
    map.putString(Constants.CAST_SCREEN_ACTION ,Constants.ON_SCREEN_CLOSE);
    mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
        .emit(Constants.CAST_SCREEN_EVENT, map);
  }
}
