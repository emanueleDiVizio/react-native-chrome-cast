package com.emadivizio.reactnativechromecast.eventBus.castScan;

import com.emadivizio.reactnativechromecast.react.eventBus.utils.DataType;
import com.emadivizio.reactnativechromecast.constants.CastScan;
import com.emadivizio.reactnativechromecast.react.eventBus.EventBusBridge;

/**
 * Created by Emanuele on 08/11/2017.
 */

public class CastScanEventBridge extends EventBusBridge implements CastScanEventListener {


    private void sendEvent(boolean available, boolean connected, boolean connecting) {
        CastScanEventBuilder eventBuilder = new CastScanEventBuilder();
        eventBuilder.addField(CastScan.DEVICES_AVAILABLE_STRING, available, DataType.BOOLEAN);
        eventBuilder.addField(CastScan.DEVICE_CONNECTED_STRING, connected, DataType.BOOLEAN);
        eventBuilder.addField(CastScan.DEVICE_CONNECTING_STRING, connecting, DataType.BOOLEAN);
        postEvent(eventBuilder.build());
    }

    @Override
    public void onNoDevicesAvailable() {
        sendEvent(false, false, false);
    }

    @Override
    public void onDeviceConnecting() {
        sendEvent(true, false, true);
    }

    @Override
    public void onDeviceConnected() {
        sendEvent(true, true, false);
    }

    @Override
    public void onDeviceNotConnected() {
        sendEvent(true, false, false);
    }
}
