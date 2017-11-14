package com.emadivizio.reactnativechromecast.sdk.cast;

/**
 * Created by Emanuele on 14/11/2017.
 */
public interface ControlsCallback {
  void onSuccess();

  void onFailure(ResultError resultError);
}
