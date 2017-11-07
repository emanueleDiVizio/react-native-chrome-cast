package com.emadivizio.reactnativechromecast.react.events;

import android.content.Context;
import android.content.Intent;

import com.emadivizio.reactnativechromecast.util.Constants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.android.gms.cast.framework.Session;

/**
 * Created by Emanuele on 12/09/2017.
 */
public class ReactCastPlaybackListener {

  private ReactContext mReactContext;

  public ReactCastPlaybackListener(ReactContext mReactContext) {
    this.mReactContext = mReactContext;
  }

  public void onReceiveActionForward(Session currentSession, long forwardStepMs) {
    WritableMap map = Arguments.createMap();
    map.putString(Constants.PLAYBACK_ACTION, Constants.ACTION_FORWARD);
    map.putDouble(Constants.ACTION_FORWARD, forwardStepMs);
    mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
          .emit(Constants.CAST_PLAYBACK_EVENT, map);
  }

  public void onReceiveActionMediaButton(Session currentSession, Intent intent)  {
    WritableMap map = Arguments.createMap();
    map.putString(Constants.PLAYBACK_ACTION, Constants.ACTION_MEDIA_BUTTON);
    map.putNull(Constants.ACTION_MEDIA_BUTTON);
    mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
          .emit(Constants.CAST_PLAYBACK_EVENT, map);
  }

  public void onReceiveActionRewind(Session currentSession, long rewindStepMs)  {
    WritableMap map = Arguments.createMap();
    map.putString(Constants.PLAYBACK_ACTION, Constants.ACTION_REWIND);
    map.putDouble(Constants.ACTION_REWIND, rewindStepMs);
    mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
          .emit(Constants.CAST_PLAYBACK_EVENT, map);
  }

  public void onReceiveActionSkipNext(Session currentSession)  {
    WritableMap map = Arguments.createMap();
    map.putString(Constants.PLAYBACK_ACTION, Constants.ACTION_SKIP_NEXT);
    map.putNull(Constants.ACTION_SKIP_NEXT);
    mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
          .emit(Constants.CAST_PLAYBACK_EVENT, map);
  }

  public void onReceiveActionSkipPrev(Session currentSession)   {
    WritableMap map = Arguments.createMap();
    map.putString(Constants.PLAYBACK_ACTION, Constants.ACTION_SKIP_PREV);
    map.putNull(Constants.ACTION_SKIP_PREV);
    mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
        .emit(Constants.CAST_PLAYBACK_EVENT, map);
  }

  public void  onReceiveActionTogglePlayback(Session currentSession)   {
    WritableMap map = Arguments.createMap();
    map.putString(Constants.PLAYBACK_ACTION, Constants.ACTION_TOGGLE_PLAYBACK);
    map.putNull(Constants.ACTION_TOGGLE_PLAYBACK);
    mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
        .emit(Constants.CAST_PLAYBACK_EVENT, map);
  }

  public void onReceiveOtherAction(Context context, String action, Intent intent)   {
    WritableMap map = Arguments.createMap();
    map.putString(Constants.PLAYBACK_ACTION, Constants.ACTION_OTHER);
    map.putString(Constants.ACTION_OTHER, action);
    mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
        .emit(Constants.CAST_PLAYBACK_EVENT, map);
  }
}
