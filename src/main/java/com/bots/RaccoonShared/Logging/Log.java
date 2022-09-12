package com.bots.RaccoonShared.Logging;

import java.awt.*;
import java.io.Serializable;

public class Log implements Serializable {
    private String caller, message;
    private Color color;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return caller + ": " + message;
    }
}
