package com.bots.RaccoonShared.SocketCommunication;

import org.json.JSONObject;

import java.util.Objects;
import java.util.function.Consumer;

/***
 * Builder class for SocketCommunicationOperation.
 */
public class SocketCommunicationOperationBuilder {
    private JSONObject data;
    private boolean waitForResponse;
    private Consumer<JSONObject> onResponseReceived;
    private Consumer<String> onErrorEncountered;

    public SocketCommunicationOperationBuilder() {
        clear();
    }

    public SocketCommunicationOperationBuilder setData(JSONObject data) {
        this.data = data;
        return this;
    }

    public SocketCommunicationOperationBuilder setWaitForResponse(boolean waitForResponse) {
        this.waitForResponse = waitForResponse;
        return this;
    }

    public SocketCommunicationOperationBuilder setOnResponseReceived(Consumer<JSONObject> onResponseReceived) {
        this.onResponseReceived = onResponseReceived;
        this.waitForResponse = true;
        return this;
    }

    public SocketCommunicationOperationBuilder setOnErrorEncountered(Consumer<String> onErrorEncountered) {
        this.onErrorEncountered = onErrorEncountered;
        return this;
    }

    public SocketCommunicationOperation build() {
        SocketCommunicationOperation out = new SocketCommunicationOperation();

        out.setContent(Objects.requireNonNullElseGet(data, JSONObject::new));

        out.setWaitForResponse(waitForResponse);
        out.setOnErrorEncountered(onErrorEncountered);
        out.setOnResponseReceived(onResponseReceived);

        return out;
    }

    public void clear() {
        this.data = null;
        this.waitForResponse = false;
        this.onResponseReceived = response -> {};
        this.onErrorEncountered = errorMessage -> {};
    }
}
