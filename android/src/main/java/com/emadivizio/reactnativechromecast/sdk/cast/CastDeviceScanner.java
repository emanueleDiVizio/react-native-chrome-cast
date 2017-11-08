package com.emadivizio.reactnativechromecast.sdk.cast;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.KeyEvent;

import com.emadivizio.reactnativechromecast.eventBus.castScan.CastScanEventListener;
import com.emadivizio.reactnativechromecast.eventBus.castSession.CastSessionEventListener;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.CastState;
import com.google.android.gms.cast.framework.CastStateListener;
import com.google.android.gms.cast.framework.SessionManagerListener;

import static com.google.android.gms.cast.framework.CastContext.getSharedInstance;

/**
 * Created by Emanuele on 07/09/2017.
 */

@SuppressWarnings("WeakerAccess")
public class CastDeviceScanner {

    private CastSession mCastSession;
    private CastStateListener mCastStateListener;
    private SessionManagerListener<CastSession> mSessionManagerListener;
    private CastContext mCastContext;

    private Context context;

    public CastDeviceScanner(Context context) {
        this.context = context;
    }


    /**
     * Set up cast manager to manage cast devices.
     */
    public void setUp() {
        setUpCastContext();
    }

    /**
     * Get the current cast session.
     */
    public CastSession getCurrentCastSession() {
        if (mCastSession == null) {
            mCastSession = getSharedInstance(context).getSessionManager()
                .getCurrentCastSession();
        }
        return mCastSession;
    }

    /**
     * Set up cast context and register lifecycle callbacks.
     */
    private void setUpCastContext() {
        getCastContext();
    }


    /**
     * Resume Cast Manager.
     */
    public void startScanning(CastScanEventListener castScanListener, CastSessionEventListener sessionStateListener) {
        addListeners(castScanListener, sessionStateListener);
        getCurrentCastSession();
    }

    /**
     * Pause cast manager.
     */
    public void stopScanning() {
        removeListeners();
    }


    /**
     * Send volume key events to chromecast.
     *
     * @param event Volume press event.
     * @return Operation successful.
     */
    public boolean dispatchKeyEvent(@NonNull KeyEvent event) {
        return getCastContext().onDispatchVolumeKeyEventBeforeJellyBean(event);
    }






    private CastContext getCastContext() {
        if (mCastContext == null) {
            mCastContext = CastContext.getSharedInstance(context);
        }
        return mCastContext;
    }

    /**
     * Add listeners to cast context.
     */
    private void addListeners(CastScanEventListener listener, CastSessionEventListener sessionStateListener) {
        mSessionManagerListener = setUpSessionManagerListener(sessionStateListener);
        mCastStateListener = setUpCastStateListener(listener);
        getCastContext().addCastStateListener(mCastStateListener);
        getCastContext().getSessionManager().addSessionManagerListener(
            mSessionManagerListener, CastSession.class);
    }


    /**
     * Remove listeners from cast context.
     */
    private void removeListeners() {
        getCastContext().removeCastStateListener(mCastStateListener);
        getCastContext().getSessionManager().removeSessionManagerListener(
            mSessionManagerListener, CastSession.class);
    }


    /**
     * Register scan state callback.
     *
     * @param listener Listener to call.
     */
    @NonNull
    private CastStateListener setUpCastStateListener(final CastScanEventListener listener) {
        return new CastStateListener() {
            @Override
            public void onCastStateChanged(int newState) {
                switch (newState) {
                    case CastState.NO_DEVICES_AVAILABLE:
                        listener.onNoDevicesAvailable();
                        break;

                    case CastState.NOT_CONNECTED:
                        listener.onDeviceNotConnected();
                        break;

                    case CastState.CONNECTED:
                        listener.onDeviceConnected();
                        break;

                    case CastState.CONNECTING:
                        listener.onDeviceConnecting();
                        break;
                }
            }
        };
    }


    /**
     * Register sessionState callback.
     *
     * @param listener Listener to call.
     */
    @NonNull
    private SessionManagerListener<CastSession> setUpSessionManagerListener(final CastSessionEventListener listener) {
        return new SessionManagerListener<CastSession>() {
            @Override
            public void onSessionStarting(CastSession castSession) {
                listener.onSessionStarting();
            }

            @Override
            public void onSessionStarted(CastSession castSession, String s) {
                mCastSession = castSession;

                listener.onSessionStarted(s);
            }

            @Override
            public void onSessionStartFailed(CastSession castSession, int i) {
                listener.onSessionStartFailed(i);
            }

            @Override
            public void onSessionEnding(CastSession castSession) {
                listener.onSessionEnding();

            }

            @Override
            public void onSessionEnded(CastSession castSession, int i) {
                if (castSession == mCastSession) {
                    mCastSession = null;
                }
                listener.onSessionEnded(i);
            }

            @Override
            public void onSessionResuming(CastSession castSession, String s) {
                listener.onSessionResuming(s);
            }

            @Override
            public void onSessionResumed(CastSession castSession, boolean b) {
                mCastSession = castSession;
                listener.onSessionResumed(b);
            }

            @Override
            public void onSessionResumeFailed(CastSession castSession, int i) {
                listener.onSessionResumeFailed(i);
            }

            @Override
            public void onSessionSuspended(CastSession castSession, int i) {
                listener.onSessionSuspended(i);

            }
        };
    }


}

