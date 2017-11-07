package com.emadivizio.reactnativechromecast.sdk.cast.util;

import android.content.Context;
import android.content.Intent;

import com.emadivizio.reactnativechromecast.react.events.ReactCastPlaybackListener;
import com.facebook.react.bridge.ReactContext;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.media.MediaIntentReceiver;

/**
 * Created by Emanuele on 07/11/2017.
 */

public class CastMediaIntentReceiver extends MediaIntentReceiver {

    private ReactCastPlaybackListener reactCastPlaybackListener;


    @Override
    public void onReceive(Context context, Intent intent) {
        reactCastPlaybackListener = new ReactCastPlaybackListener((ReactContext) context);
        super.onReceive(context, intent);
    }

    @Override
    public void onReceiveActionForward(Session currentSession, long forwardStepMs) {
        reactCastPlaybackListener.onReceiveActionForward(currentSession, forwardStepMs);
    }

    @Override
    public void onReceiveActionMediaButton(Session currentSession, Intent intent)  {
        reactCastPlaybackListener.onReceiveActionMediaButton(currentSession, intent);

    }

    @Override
    public void onReceiveActionRewind(Session currentSession, long rewindStepMs)  {
        reactCastPlaybackListener.onReceiveActionRewind(currentSession, rewindStepMs);
    }

    @Override
    public void onReceiveActionSkipNext(Session currentSession)  {
        reactCastPlaybackListener.onReceiveActionSkipNext(currentSession);
    }

    @Override
    public void onReceiveActionSkipPrev(Session currentSession)   {
        reactCastPlaybackListener.onReceiveActionSkipPrev(currentSession);
    }

    @Override
    public void  onReceiveActionTogglePlayback(Session currentSession)   {
        reactCastPlaybackListener.onReceiveActionTogglePlayback(currentSession);
    }


    @Override
    public void onReceiveOtherAction(Context context, String action, Intent intent)   {
        reactCastPlaybackListener.onReceiveOtherAction(context, action, intent);
    }
}
