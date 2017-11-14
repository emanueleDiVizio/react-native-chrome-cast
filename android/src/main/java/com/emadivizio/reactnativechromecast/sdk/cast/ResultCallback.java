package com.emadivizio.reactnativechromecast.sdk.cast;

import android.support.annotation.NonNull;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.Status;

/**
 * Created by Emanuele on 14/11/2017.
 */
class ResultCallback extends ResultCallbacks<RemoteMediaClient.MediaChannelResult> {
  private ControlsCallback controlsCallback;

  public ResultCallback(ControlsCallback controlsCallback) {
    this.controlsCallback = controlsCallback;
  }

  @Override
  public void onSuccess(@NonNull RemoteMediaClient.MediaChannelResult mediaChannelResult) {
    controlsCallback.onSuccess();
  }

  @Override
  public void onFailure(@NonNull Status status) {
    controlsCallback.onFailure(new ResultError(status));
  }
}
