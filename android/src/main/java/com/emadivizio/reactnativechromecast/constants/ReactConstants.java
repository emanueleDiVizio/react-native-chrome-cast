package com.emadivizio.reactnativechromecast.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Emanuele on 08/11/2017.
 */

public class ReactConstants {
    private static final String CAST_SESSION = "CAST_SESSION";
    private static final String CAST_SCAN = "CAST_SCAN";
    private static final String CAST_SCREEN = "CAST_SCREEN";
    private static final String CAST_PLAYBACK = "CAST_PLAYBACK";
    private static final String EVENT_NAME = "EVENT_NAME";


    public static Map<String, Object> buildConstantsMap(){
        final Map<String, Object> castSessionMap = new HashMap<>();
        castSessionMap.put(EVENT_NAME, CastSession.CAST_SESSION_EVENT);

        castSessionMap.put(CastSession.SESSION_STATUS_STRING, CastSession.SESSION_STATUS_STRING);
        castSessionMap.put(CastSession.SESSION_STATUS_MESSAGE_STRING, CastSession.SESSION_STATUS_MESSAGE_STRING);

        castSessionMap.put(CastSession.SESSION_STARTING_STRING, CastSession.SESSION_STARTING);
        castSessionMap.put(CastSession.SESSION_STARTED_STRING, CastSession.SESSION_STARTED);
        castSessionMap.put(CastSession.SESSION_START_FAILED_STRING, CastSession.SESSION_START_FAILED);
        castSessionMap.put(CastSession.SESSION_ENDING_STRING, CastSession.SESSION_ENDING);
        castSessionMap.put(CastSession.SESSION_ENDED_STRING, CastSession.SESSION_ENDED);
        castSessionMap.put(CastSession.SESSION_RESUMING_STRING, CastSession.SESSION_RESUMING);
        castSessionMap.put(CastSession.SESSION_RESUMED_STRING, CastSession.SESSION_RESUMED);
        castSessionMap.put(CastSession.SESSION_RESUME_FAILED_STRING, CastSession.SESSION_RESUME_FAILED);
        castSessionMap.put(CastSession.SESSION_SUSPENDED_STRING, CastSession.SESSION_SUSPENDED);

        castSessionMap.put(CastSession.SESSION_STATUS_ARG, CastSession.SESSION_STATUS_ARG);




        final Map<String, Object> castScanMap = new HashMap<>();

        castScanMap.put(EVENT_NAME, CastScan.CAST_SCAN_EVENT);

        castScanMap.put(CastScan.DEVICES_AVAILABLE_STRING, CastScan.DEVICES_AVAILABLE_STRING);
        castScanMap.put(CastScan.DEVICE_CONNECTED_STRING, CastScan.DEVICE_CONNECTED_STRING);
        castScanMap.put(CastScan.DEVICE_CONNECTING_STRING, CastScan.DEVICE_CONNECTING_STRING);


        final Map<String, Object> playbackMap = new HashMap<>();

        playbackMap.put(EVENT_NAME, Playback.CAST_PLAYBACK_EVENT);

        playbackMap.put(Playback.PLAYBACK_ACTION, Playback.PLAYBACK_ACTION);

        playbackMap.put(Playback.ACTION_FORWARD, Playback.ACTION_FORWARD);
        playbackMap.put(Playback.ACTION_REWIND, Playback.ACTION_REWIND);
        playbackMap.put(Playback.ACTION_SKIP_NEXT, Playback.ACTION_SKIP_NEXT);
        playbackMap.put(Playback.ACTION_SKIP_PREV, Playback.ACTION_SKIP_PREV);
        playbackMap.put(Playback.ACTION_STOP_CASTING, Playback.ACTION_STOP_CASTING);
        playbackMap.put(Playback.ACTION_TOGGLE_PLAYBACK, Playback.ACTION_TOGGLE_PLAYBACK);
        playbackMap.put(Playback.ACTION_OTHER, Playback.ACTION_OTHER);
        playbackMap.put(Playback.ACTION_MEDIA_BUTTON, Playback.ACTION_MEDIA_BUTTON);

        final Map<String, Object> castScreenMap = new HashMap<>();

        castScreenMap.put(EVENT_NAME, CastScreen.CAST_SCREEN_EVENT);

        castScreenMap.put(CastScreen.CAST_SCREEN_ACTION, CastScreen.CAST_SCREEN_ACTION);

        castScreenMap.put(CastScreen.ON_SCREEN_OPEN, CastScreen.ON_SCREEN_OPEN);
        castScreenMap.put(CastScreen.ON_SCREEN_CLOSE, CastScreen.ON_SCREEN_CLOSE);




        final Map<String, Object> constantsMap = new HashMap<>();
        constantsMap.put(ReactConstants.CAST_SESSION, castSessionMap);
        constantsMap.put(ReactConstants.CAST_SCAN, castScanMap);
        constantsMap.put(ReactConstants.CAST_PLAYBACK, playbackMap);
        constantsMap.put(ReactConstants.CAST_SCREEN, castScreenMap);

        return constantsMap;
    }
}
