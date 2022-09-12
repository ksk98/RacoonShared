package com.bots.RaccoonShared.IncomingDataHandlers;

import org.json.JSONObject;

public abstract class BaseIncomingDataTrafficHandler implements IncomingDataTrafficHandler {
    private IncomingDataTrafficHandler next;

    public BaseIncomingDataTrafficHandler() {
        this.next = null;
    }

    @Override
    public IncomingDataTrafficHandler setNext(IncomingDataTrafficHandler handler) {
        this.next = handler;
        return handler;
    }

    @Override
    public void handle(JSONObject data) {
        if (next != null)
            next.handle(data);
    }
}
