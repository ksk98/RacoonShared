package com.bots.RaccoonShared.SocketCommunication;

import org.json.JSONObject;

import java.util.function.Consumer;

/***
 * Resembles a single operation related to sending data.
 */
public class SocketCommunicationOperation {
    private JSONObject content = null;
    private boolean waitForResponse = false;
    private Consumer<JSONObject> onResponseReceived = response -> {};
    private Consumer<String> onErrorEncountered = errorMessage -> {};


    public JSONObject getContent() {
        return content;
    }

    public void setContent(JSONObject content) {
        this.content = content;
    }

    public boolean waitForResponse() {
        return waitForResponse;
    }

    public void setWaitForResponse(boolean waitForResponse) {
        this.waitForResponse = waitForResponse;
    }

    public Consumer<JSONObject> getOnResponseReceived() {
        return onResponseReceived;
    }

    public void setOnResponseReceived(Consumer<JSONObject> onResponseReceived) {
        this.onResponseReceived = onResponseReceived;
    }

    public Consumer<String> getOnErrorEncountered() {
        return onErrorEncountered;
    }

    public void setOnErrorEncountered(Consumer<String> onErrorEncountered) {
        this.onErrorEncountered = onErrorEncountered;
    }
}
