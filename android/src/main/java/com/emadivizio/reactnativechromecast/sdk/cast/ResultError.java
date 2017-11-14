package com.emadivizio.reactnativechromecast.sdk.cast;

import com.google.android.gms.common.api.Status;

/**
 * Created by Emanuele on 14/11/2017.
 */
public class ResultError {
  private Status status;

  public ResultError(Status status) {
    this.status = status;
  }


    public int getCode() {
    return status.getStatusCode();
  }

    public String getMessage() {
    return status.getStatusMessage();
  }
}
