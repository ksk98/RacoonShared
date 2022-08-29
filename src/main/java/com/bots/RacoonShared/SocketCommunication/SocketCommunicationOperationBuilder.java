package com.bots.RacoonShared.SocketCommunication;

import org.json.JSONObject;

import java.util.function.Consumer;

/***
 * Builder class for SocketCommunicationOperation.
 */
public class SocketCommunicationOperationBuilder {
    private JSONObject data;
    private Consumer<JSONObject> onResponseReceived;
    private Consumer<String> onErrorEncountered;

    public SocketCommunicationOperationBuilder() {
        clear();
    }

    public SocketCommunicationOperationBuilder setData(JSONObject data) {
        this.data = data;
        return this;
    }

    public SocketCommunicationOperationBuilder setOnResponseReceived(Consumer<JSONObject> onResponseReceived) {
        this.onResponseReceived = onResponseReceived;
        return this;
    }

    public SocketCommunicationOperationBuilder setOnErrorEncountered(Consumer<String> onErrorEncountered) {
        this.onErrorEncountered = onErrorEncountered;
        return this;
    }

    public SocketCommunicationOperation build() {
        SocketCommunicationOperation out = new SocketCommunicationOperation();

        if (data == null)
            out.setRequest(new JSONObject());
        out.setOnErrorEncountered(onErrorEncountered);
        out.setOnResponseReceived(onResponseReceived);

        return out;
    }

    public void clear() {
        this.data = null;
        this.onResponseReceived = response -> {};
        this.onErrorEncountered = errorMessage -> {};
    }
}
