package com.emadivizio.reactnativechromecast.react.eventBus.utils;

import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;

/**
 * Created by Emanuele on 08/11/2017.
 */

public class TypeAwareMap  {
    private WritableMap writableMap;

    public TypeAwareMap(WritableMap map) {
        this.writableMap = map;
    }

    public <T>  TypeAwareMap putValue(String key, T value, DataType valueType){
        switch(valueType){
            case NULL:
                writableMap.putNull(key);
                break;
            case BOOLEAN:
                writableMap.putBoolean(key, (Boolean) value);
                break;
            case DOUBLE:
                writableMap.putDouble(key, (Double) value);
                break;
            case INT:
                writableMap.putInt(key, (Integer) value);
                break;
            case STRING:
                writableMap.putString(key, (String) value);
                break;
            case ARRAY:
                writableMap.putArray(key, (WritableArray) value);
                break;
            case MAP:
                writableMap.putMap(key, (WritableMap) value);
                break;
            default:
                break;
        }
        return this;
    }

    public WritableMap getWritableMap() {
        return writableMap;
    }
}
