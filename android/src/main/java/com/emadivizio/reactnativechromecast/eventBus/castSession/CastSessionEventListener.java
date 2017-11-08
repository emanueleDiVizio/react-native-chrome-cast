package com.emadivizio.reactnativechromecast.eventBus.castSession;

/**
 * Created by Emanuele on 08/11/2017.
 */

public interface CastSessionEventListener {
    void onSessionStarting();

    void onSessionStarted(String var2);

    void onSessionStartFailed(int var2);

    void onSessionEnding();

    void onSessionEnded(int var2);

    void onSessionResuming(String var2);

    void onSessionResumed(boolean var2);

    void onSessionResumeFailed(int var2);

    void onSessionSuspended(int var2);
}
