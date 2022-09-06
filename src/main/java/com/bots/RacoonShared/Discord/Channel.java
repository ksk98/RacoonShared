package com.bots.RacoonShared.Discord;

public record Channel(String channelId, String channelName) {
    @Override
    public String toString() {
        return channelName;
    }
}
