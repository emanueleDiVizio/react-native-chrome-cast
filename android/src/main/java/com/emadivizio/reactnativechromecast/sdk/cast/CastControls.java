package com.emadivizio.reactnativechromecast.sdk.cast;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;

/**
 * Created by Emanuele on 21/09/2017.
 */
public class CastControls {

    private RemoteMediaClient remoteMediaClient;


    CastControls(RemoteMediaClient remoteMediaClient) {
        this.remoteMediaClient = remoteMediaClient;
    }


    public void play(final ControlsCallback controlsCallback) {
        if (remoteMediaClient != null) {
            remoteMediaClient.play().setResultCallback(new ResultCallback(controlsCallback));
        }
    }


    public void pause(final ControlsCallback controlsCallback) {
        if (remoteMediaClient != null) {
            remoteMediaClient.pause().setResultCallback(new ResultCallback(controlsCallback));
        }
    }


    public void toggle(final ControlsCallback controlsCallback) {
        if (remoteMediaClient != null) {
            if (remoteMediaClient.isPlaying()) {
                remoteMediaClient.pause().setResultCallback(new ResultCallback(controlsCallback));
            } else {
                remoteMediaClient.play().setResultCallback(new ResultCallback(controlsCallback));
            }
        }
    }


    public void stop(final ControlsCallback controlsCallback) {
        if (remoteMediaClient != null) {
            remoteMediaClient.stop().setResultCallback(new ResultCallback(controlsCallback));
        }
    }


    public void seek(long position, final ControlsCallback controlsCallback) {
        if (remoteMediaClient != null) {
            remoteMediaClient.seek(position).setResultCallback(new ResultCallback(controlsCallback));
        }
    }


}
