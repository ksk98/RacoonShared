package com.bots.RacoonShared.Events.IncomingDataEvents;

import org.json.JSONObject;

public abstract class BaseIncomingDataTrafficHandler implements IncomingDataTrafficHandler {
    private IncomingDataTrafficHandler next = null;

    @Override
    public void setNext(IncomingDataTrafficHandler handler) {
        this.next = handler;
    }

    @Override
    public void handle(JSONObject response) {
        if (next != null)
            next.handle(response);
    }
}
