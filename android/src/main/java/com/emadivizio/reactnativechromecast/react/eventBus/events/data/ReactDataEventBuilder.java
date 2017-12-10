package com.emadivizio.reactnativechromecast.react.eventBus.events.data;

import com.emadivizio.reactnativechromecast.react.eventBus.utils.DataType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Emanuele on 08/11/2017.
 */

public class ReactDataEventBuilder {
    private List<Field<?>> fields;
    private String channel;

    public ReactDataEventBuilder(String channel) {
        this.channel = channel;
        this.fields = new ArrayList<>();
    }


    public  <T> ReactDataEventBuilder addField(String name, T value, DataType valueType){
        fields.add(new Field<>(name, value, valueType));
        return this;
    }

    public ReactDataEvent build(){
        return new ReactDataEvent(channel, fields);
    }
}
