package com.emadivizio.reactnativechromecast.eventBus.castSession;

/**
 * Created by Emanuele on 08/11/2017.
 */

public interface CastSessionEventListener {
    void onSessionStarting();

    void onSessionStarted(String sessionId);

    void onSessionStartFailed(int error);

    void onSessionEnding();

    void onSessionEnded(int error);

    void onSessionResuming(String sessionId);

    void onSessionResumed(boolean wasSuspended);

    void onSessionResumeFailed(int error);

    void onSessionSuspended(int reason);
}
