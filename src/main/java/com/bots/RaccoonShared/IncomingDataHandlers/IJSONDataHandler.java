package com.bots.RaccoonShared.IncomingDataHandlers;

import org.json.JSONObject;

public interface IJSONDataHandler {
    /**
     * @return handler that was passed as parameter
     */
    IJSONDataHandler setNext(IJSONDataHandler handler);

    /**
     * Handle given data or pass it to the next available handler.
     * Response should contain a key "operation" to distinguish which handler should
     * make use of the response.
     */
    void handle(JSONObject data);
}
