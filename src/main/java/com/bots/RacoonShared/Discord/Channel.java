package com.bots.RacoonShared.Discord;

import java.io.Serializable;

public record Channel(String channelId, String channelName) implements Serializable {
    @Override
    public String toString() {
        return channelName;
    }
}
