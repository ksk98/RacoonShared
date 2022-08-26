package com.bots.RacoonShared.Logging;

import java.awt.*;
import java.io.Serializable;

public class Log implements Serializable {
    private final String caller;
    private final String message;
    private final Color color;

    public Log(String message, Color color) {
        this.caller = CallerAcquirement.getInstance().getClassName();
        this.message = message;
        this.color = color;
    }

    public Log(String caller, String message, Color color) {
        this.caller = caller;
        this.message = message;
        this.color = color;
    }

    public String getCaller() {
        return caller;
    }

    public String getMessage() {
        return message;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return caller + ": " + message;
    }
}
