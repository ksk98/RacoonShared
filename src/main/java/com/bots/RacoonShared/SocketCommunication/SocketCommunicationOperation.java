package com.bots.RacoonShared.SocketCommunication;

import org.json.JSONObject;

import java.util.function.Consumer;

/***
 * Resembles a single operation related to sending data.
 */
public class SocketCommunicationOperation {
    private JSONObject request = null;
    private boolean waitForResponse = true;
    private Consumer<JSONObject> onResponseReceived = response -> {};
    private Consumer<String> onErrorEncountered = errorMessage -> {};


    public JSONObject getRequest() {
        return request;
    }

    public void setRequest(JSONObject request) {
        this.request = request;
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
