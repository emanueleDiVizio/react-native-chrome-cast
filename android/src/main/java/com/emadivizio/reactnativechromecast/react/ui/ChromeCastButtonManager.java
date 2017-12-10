package com.emadivizio.reactnativechromecast.react.ui;

import com.emadivizio.reactnativechromecast.sdk.ui.ChromeCastButton;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

/**
 * Created by Emanuele on 11/09/2017.
 */

public class ChromeCastButtonManager extends SimpleViewManager<ChromeCastButton> {

    public static final String REACT_CLASS = "RCTChromeCastButton";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected ChromeCastButton createViewInstance(ThemedReactContext reactContext) {
        return new ChromeCastButton(reactContext);
    }


}
