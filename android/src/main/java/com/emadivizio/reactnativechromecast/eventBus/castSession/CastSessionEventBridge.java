package com.emadivizio.reactnativechromecast.eventBus.castSession;

import com.emadivizio.reactnativechromecast.react.eventBus.utils.DataType;
import com.emadivizio.reactnativechromecast.react.eventBus.EventBusBridge;
import com.emadivizio.reactnativechromecast.constants.CastSession;

/**
 * Created by Emanuele on 08/11/2017.
 */

public class CastSessionEventBridge extends EventBusBridge implements CastSessionEventListener {


    private void sendEvent(int status) {
        CastSessionEventBuilder eventBuilder = new CastSessionEventBuilder();
        eventBuilder.addField(CastSession.SESSION_STATUS_STRING, status, DataType.INT);
        eventBuilder.addField(CastSession.SESSION_STATUS_MESSAGE_STRING,  CastSession.statusToMessage(status), DataType.STRING);
        postEvent(eventBuilder.build());
    }

    @Override
    public void onSessionStarting() {
        sendEvent(CastSession.SESSION_STARTING);
    }

    @Override
    public void onSessionStarted(String var2) {
        sendEvent(CastSession.SESSION_STARTED);
    }

    @Override
    public void onSessionStartFailed(int var2) {
        sendEvent(CastSession.SESSION_START_FAILED);
    }

    @Override
    public void onSessionEnding() {
        sendEvent(CastSession.SESSION_ENDING);
    }

    @Override
    public void onSessionEnded(int var2) {
        sendEvent(CastSession.SESSION_ENDED);
    }

    @Override
    public void onSessionResuming(String var2) {
        sendEvent(CastSession.SESSION_RESUMING);
    }

    @Override
    public void onSessionResumed(boolean var2) {
        sendEvent(CastSession.SESSION_RESUMED);
    }

    @Override
    public void onSessionResumeFailed(int var2) {
        sendEvent(CastSession.SESSION_RESUME_FAILED);
    }

    @Override
    public void onSessionSuspended(int var2) {
        sendEvent(CastSession.SESSION_SUSPENDED);
    }
}
