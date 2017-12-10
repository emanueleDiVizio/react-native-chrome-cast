package com.emadivizio.reactnativechromecast.eventBus.playback;

import android.content.Context;
import android.content.Intent;

import com.emadivizio.reactnativechromecast.react.eventBus.utils.DataType;
import com.emadivizio.reactnativechromecast.react.eventBus.EventBusBridge;
import com.emadivizio.reactnativechromecast.constants.Playback;
import com.google.android.gms.cast.framework.Session;

/**
 * Created by Emanuele on 08/11/2017.
 */

public class PlaybackEventBridge  extends EventBusBridge implements PlaybackActionsListener {

    private <T> void sendEvent(String action, T argument, DataType valueType) {
        postEvent(new PlaybackEvent<T>(action, argument, valueType));
    }

    private <T> void sendEvent(String action) {
        postEvent(new PlaybackEvent<T>(action, null, DataType.NULL));
    }

    @Override
    public void onReceiveActionForward(Session currentSession, long forwardStepMs) {
        sendEvent(Playback.ACTION_FORWARD, forwardStepMs, DataType.DOUBLE);
    }

    @Override
    public void onReceiveActionMediaButton(Session currentSession, Intent intent)  {
        sendEvent(Playback.ACTION_MEDIA_BUTTON);
    }

    @Override
    public void onReceiveActionRewind(Session currentSession, long rewindStepMs)  {
        sendEvent(Playback.ACTION_REWIND, rewindStepMs, DataType.DOUBLE);
    }

    @Override
    public void onReceiveActionSkipNext(Session currentSession)  {
        sendEvent(Playback.ACTION_SKIP_NEXT);
    }

    @Override
    public void onReceiveActionSkipPrev(Session currentSession)   {
        sendEvent(Playback.ACTION_SKIP_PREV);
    }

    @Override
    public void  onReceiveActionTogglePlayback(Session currentSession)   {
        sendEvent(Playback.ACTION_TOGGLE_PLAYBACK);
    }

    @Override
    public void onReceiveOtherAction(Context context, String action, Intent intent)   {
        sendEvent(Playback.ACTION_OTHER, action, DataType.STRING);
    }
}
