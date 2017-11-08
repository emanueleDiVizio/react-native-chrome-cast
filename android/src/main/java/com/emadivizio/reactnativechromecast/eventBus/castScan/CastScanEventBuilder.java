package com.emadivizio.reactnativechromecast.eventBus.castScan;

import com.emadivizio.reactnativechromecast.constants.CastScan;
import com.emadivizio.reactnativechromecast.react.eventBus.events.data.ReactDataEventBuilder;

/**
 * Created by Emanuele on 08/11/2017.
 */

public class CastScanEventBuilder extends ReactDataEventBuilder {

    public CastScanEventBuilder() {
        super(CastScan.CAST_SCAN_EVENT);
    }
}
