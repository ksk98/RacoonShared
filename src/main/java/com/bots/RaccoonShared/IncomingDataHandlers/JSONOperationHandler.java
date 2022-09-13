package com.bots.RaccoonShared.IncomingDataHandlers;

import com.bots.RaccoonShared.SocketCommunication.SocketOperationIdentifiers;
import org.json.JSONObject;

public abstract class JSONOperationHandler extends JSONDataHandler {
    private final SocketOperationIdentifiers operation;

    public JSONOperationHandler(SocketOperationIdentifiers operation) {
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
