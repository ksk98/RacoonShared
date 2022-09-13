package com.bots.RaccoonShared.IncomingDataHandlers;

import org.json.JSONObject;

public abstract class JSONDataHandler implements IJSONDataHandler {
    private IJSONDataHandler next;

    public JSONDataHandler() {
        this.next = null;
    }

    @Override
    public IJSONDataHandler setNext(IJSONDataHandler handler) {
        this.next = handler;
        return handler;
    }

    @Override
    public void handle(JSONObject data) {
        if (next != null)
            next.handle(data);
    }
}
