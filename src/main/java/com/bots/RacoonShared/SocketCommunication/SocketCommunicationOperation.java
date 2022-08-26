package com.bots.RacoonShared.SocketCommunication;

import org.json.JSONObject;

import java.util.function.Consumer;

/***
 * Resembles a single operation related to sending a request.
 * Given consumers will be used during the lifecycle of a request either
 * when response is available or an error occured.
 */
public class SocketCommunicationOperation {
    private JSONObject request = null;
    private Consumer<JSONObject> onResponse = response -> {};
    private Consumer<String> onError = errorMessage -> {};


    public JSONObject getRequest() {
        return request;
    }

    public void setRequest(JSONObject request) {
        this.request = request;
    }

    public Consumer<JSONObject> getOnResponse() {
        return onResponse;
    }

    public void setOnResponse(Consumer<JSONObject> onResponse) {
        this.onResponse = onResponse;
    }

    public Consumer<String> getOnError() {
        return onError;
    }

    public void setOnError(Consumer<String> onError) {
        this.onError = onError;
    }
}
