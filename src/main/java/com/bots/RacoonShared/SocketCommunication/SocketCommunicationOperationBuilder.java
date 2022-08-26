package com.bots.RacoonShared.SocketCommunication;

import com.bots.RacoonShared.Logging.Loggers.Logger;
import org.json.JSONObject;

import java.util.function.Consumer;

/***
 * Builder class for SocketCommunicationOperation.
 */
public class SocketCommunicationOperationBuilder {
    private final Logger logger;

    private JSONObject request;
    private Consumer<JSONObject> onResponse;
    private Consumer<String> onError;

    public SocketCommunicationOperationBuilder(Logger logger) {
        this.logger = logger;
        clear();
    }

    public SocketCommunicationOperationBuilder setRequest(JSONObject request) {
        this.request = request;
        return this;
    }

    public SocketCommunicationOperationBuilder setOnResponse(Consumer<JSONObject> onResponse) {
        this.onResponse = onResponse;
        return this;
    }

    public SocketCommunicationOperationBuilder setOnError(Consumer<String> onError) {
        this.onError = onError;
        return this;
    }

    public SocketCommunicationOperation build() {
        SocketCommunicationOperation out = new SocketCommunicationOperation();

        if (request == null)
            out.setRequest(new JSONObject());
        out.setOnError(onError);
        out.setOnResponse(onResponse);

        return out;
    }

    public void clear() {
        this.request = null;
        this.onResponse = response -> {};
        this.onError = errorMessage -> {};
    }
}
