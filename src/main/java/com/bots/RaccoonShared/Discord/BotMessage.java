package com.bots.RaccoonShared.Discord;

import java.io.Serializable;

public class BotMessage implements Serializable {
    public final String serverId, channelId, message;

    public BotMessage(String serverId, String channelId, String message) {
        this.serverId = serverId;
        this.channelId = channelId;
        this.message = message;
    }
}
