package com.emadivizio.reactnativechromecast.eventBus.castScan;

/**
 * Created by Emanuele on 08/11/2017.
 */

public interface CastScanEventListener {
    void onNoDevicesAvailable();

    void onDeviceConnecting();

    void onDeviceConnected();

    void onDeviceNotConnected();

}
