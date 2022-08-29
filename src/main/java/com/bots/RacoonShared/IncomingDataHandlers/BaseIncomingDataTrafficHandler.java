package com.bots.RacoonShared.IncomingDataHandlers;

import org.json.JSONObject;

public abstract class BaseIncomingDataTrafficHandler implements IncomingDataTrafficHandler {
    private IncomingDataTrafficHandler next;

    public BaseIncomingDataTrafficHandler(IncomingDataTrafficHandler next) {
        this.next = next;
    }

    @Override
    public void setNext(IncomingDataTrafficHandler handler) {
        this.next = handler;
    }

    @Override
    public void handle(JSONObject data) {
        if (next != null)
            next.handle(data);
    }
}
