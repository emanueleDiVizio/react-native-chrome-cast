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
        eventBuilder.addField(CastSession.SESSION_STATUS_ARG,  null, DataType.NULL);
        postEvent(eventBuilder.build());
    }


    private void sendEvent(int status, int arg) {
        CastSessionEventBuilder eventBuilder = new CastSessionEventBuilder();
        eventBuilder.addField(CastSession.SESSION_STATUS_STRING, status, DataType.INT);
        eventBuilder.addField(CastSession.SESSION_STATUS_MESSAGE_STRING,  CastSession.statusToMessage(status), DataType.STRING);
        eventBuilder.addField(CastSession.SESSION_STATUS_ARG,  arg, DataType.INT);
        postEvent(eventBuilder.build());
    }

    private void sendEvent(int status, boolean arg) {
        CastSessionEventBuilder eventBuilder = new CastSessionEventBuilder();
        eventBuilder.addField(CastSession.SESSION_STATUS_STRING, status, DataType.INT);
        eventBuilder.addField(CastSession.SESSION_STATUS_MESSAGE_STRING,  CastSession.statusToMessage(status), DataType.STRING);
        eventBuilder.addField(CastSession.SESSION_STATUS_ARG,  arg, DataType.BOOLEAN);
        postEvent(eventBuilder.build());
    }

    private void sendEvent(int status, String arg) {
        CastSessionEventBuilder eventBuilder = new CastSessionEventBuilder();
        eventBuilder.addField(CastSession.SESSION_STATUS_STRING, status, DataType.INT);
        eventBuilder.addField(CastSession.SESSION_STATUS_MESSAGE_STRING,  CastSession.statusToMessage(status), DataType.STRING);
        eventBuilder.addField(CastSession.SESSION_STATUS_ARG,  arg, DataType.STRING);
        postEvent(eventBuilder.build());
    }

    @Override
    public void onSessionStarting() {
        sendEvent(CastSession.SESSION_STARTING);
    }

    @Override
    public void onSessionStarted(String sessionId) {
        sendEvent(CastSession.SESSION_STARTED, sessionId);
    }

    @Override
    public void onSessionStartFailed(int error) {
        sendEvent(CastSession.SESSION_START_FAILED, error);
    }

    @Override
    public void onSessionEnding() {
        sendEvent(CastSession.SESSION_ENDING);
    }

    @Override
    public void onSessionEnded(int error) {
        sendEvent(CastSession.SESSION_ENDED, error);
    }

    @Override
    public void onSessionResuming(String sessionId) {
        sendEvent(CastSession.SESSION_RESUMING, sessionId);
    }

    @Override
    public void onSessionResumed(boolean wasSuspended) {
        sendEvent(CastSession.SESSION_RESUMED, wasSuspended);
    }

    @Override
    public void onSessionResumeFailed(int error) {
        sendEvent(CastSession.SESSION_RESUME_FAILED, error);
    }

    @Override
    public void onSessionSuspended(int reason) {
        sendEvent(CastSession.SESSION_SUSPENDED, reason);
    }
}
