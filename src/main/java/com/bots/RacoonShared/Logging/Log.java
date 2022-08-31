package com.bots.RacoonShared.Logging;

import java.awt.*;
import java.io.Serializable;

public class Log implements Serializable {
    private String caller;
    public final String message;
    public final Color color;

    public Log(String caller, String message, Color color) {
        this.caller = caller;
        this.message = message;
        this.color = color;
    }

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }

    @Override
    public String toString() {
        return caller + ": " + message;
    }
}
