package com.emadivizio.reactnativechromecast.react.ui;

import com.emadivizio.reactnativechromecast.sdk.ui.ChromeCastMiniController;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

/**
 * Created by Emanuele on 11/09/2017.
 */

public class ChromeCastMiniControllerManager extends SimpleViewManager<ChromeCastMiniController> {

    public static final String REACT_CLASS = "RCTChromeCastMiniController";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected ChromeCastMiniController createViewInstance(ThemedReactContext reactContext) {
        return new ChromeCastMiniController(reactContext);
    }

}
