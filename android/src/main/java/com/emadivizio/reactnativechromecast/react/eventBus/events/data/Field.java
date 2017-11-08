package com.emadivizio.reactnativechromecast.react.eventBus.events.data;

import com.emadivizio.reactnativechromecast.react.eventBus.utils.DataType;

/**
 * Created by Emanuele on 08/11/2017.
 */

public class Field<T> {
    private final DataType valueType;
    private final T value;
    private final String name;

    public Field(String name, T value, DataType valueType) {
        this.valueType = valueType;
        this.value = value;
        this.name = name;
    }


    public DataType getValueType() {
        return valueType;
    }

    public T getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Field{" +
            "valueType=" + valueType +
            ", value=" + value +
            ", name='" + name + '\'' +
            '}';
    }
}
