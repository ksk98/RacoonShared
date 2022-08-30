package com.bots.RacoonShared.Logging;

import java.awt.*;
import java.io.Serializable;

public class Log implements Serializable {
    public final String caller;
    public final String message;
    public final Color color;

    public Log(int callerDepth, String message, Color color) {
        this.caller = CallerAcquirement.getInstance().getClassName(callerDepth);
        this.message = message;
        this.color = color;
    }

    public Log(String caller, String message, Color color) {
        this.caller = caller;
        this.message = message;
        this.color = color;
    }

    @Override
    public String toString() {
        return caller + ": " + message;
    }
}
