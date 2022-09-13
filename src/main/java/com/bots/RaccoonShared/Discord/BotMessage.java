package com.bots.RaccoonShared.Discord;

import java.io.Serializable;

public record BotMessage(String serverId, String channelId, String message) implements Serializable {
    
}
