package com.bots.RacoonShared.Events.IncomingDataEvents;

import org.json.JSONObject;

public abstract class BaseIncomingDataTrafficHandler implements IncomingDataTrafficHandler {
    private IncomingDataTrafficHandler next = null;

    public BaseIncomingDataTrafficHandler() {

    }

    public BaseIncomingDataTrafficHandler(IncomingDataTrafficHandler next) {
        this.next = next;
    }

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
