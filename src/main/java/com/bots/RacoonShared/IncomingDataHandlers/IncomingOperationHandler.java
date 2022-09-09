package com.bots.RacoonShared.IncomingDataHandlers;

import com.bots.RacoonShared.SocketCommunication.SocketOperationIdentifiers;
import org.json.JSONObject;

public abstract class IncomingOperationHandler extends BaseIncomingDataTrafficHandler {
    private final SocketOperationIdentifiers operation;

    public IncomingOperationHandler(SocketOperationIdentifiers operation) {
        super();
        this.operation = operation;
    }

    public abstract void consume(JSONObject data);

    @Override
    public final void handle(JSONObject data) {
        if (data.has("operation") && data.getString("operation").equals(operation.toString()))
            consume(data);
        else super.handle(data);
    }
}
