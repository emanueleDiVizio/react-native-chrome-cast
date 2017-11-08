package com.emadivizio.reactnativechromecast.react.eventBus.events;

import com.emadivizio.reactnativechromecast.react.eventBus.utils.DataType;

/**
 * Created by Emanuele on 08/11/2017.
 */

public class ReactActionEvent<T> extends ReactEvent{
    private final String actionType, action;
    private final DataType argType;
    private final T argument;

    public ReactActionEvent(String channel, String action, String actionType, T argument, DataType argType) {
        super(channel);
        this.actionType = actionType;
        this.action = action;
        this.argType = argType;
        this.argument = argument;
    }

    public String getActionType() {
        return actionType;
    }

    public String getAction() {
        return action;
    }

    public DataType getArgType() {
        return argType;
    }

    public T getArgument() {
        return argument;
    }


    @Override
    public String toString() {
        return "ReactActionEvent{" +
            "actionType='" + actionType + '\'' +
            ", action='" + action + '\'' +
            ", argType=" + argType +
            ", argument=" + argument +
            '}';
    }
}
