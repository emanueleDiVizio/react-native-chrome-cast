package com.emadivizio.reactnativechromecast.eventBus.playback;

import android.content.Context;
import android.content.Intent;

import com.google.android.gms.cast.framework.Session;

/**
 * Created by Emanuele on 08/11/2017.
 */

public interface PlaybackActionsListener {
    void onReceiveActionForward(Session currentSession, long forwardStepMs);

    void onReceiveActionMediaButton(Session currentSession, Intent intent);

    void onReceiveActionRewind(Session currentSession, long rewindStepMs);

    void onReceiveActionSkipNext(Session currentSession);

    void onReceiveActionSkipPrev(Session currentSession);

    void  onReceiveActionTogglePlayback(Session currentSession);

    void onReceiveOtherAction(Context context, String action, Intent intent);
}
