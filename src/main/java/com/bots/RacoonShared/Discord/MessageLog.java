package com.bots.RacoonShared.Discord;

import java.awt.*;

public class MessageLog {
    public final String serverId, channelId;
    public final String username;
    public final Color userColor;
    public final String message;
    private boolean userIsBot = false, hasEmbeds = false;

    public MessageLog(String serverId, String channelId,
                      String username, Color userColor, String message) {
        this.serverId = serverId;
        this.channelId = channelId;
        this.username = username;
        this.userColor = userColor;
        this.message = message;
    }

    public boolean userIsBot() {
        return userIsBot;
    }

    public MessageLog setUserIsBot(boolean userIsBot) {
        this.userIsBot = userIsBot;
        return this;
    }

    public boolean hasEmbeds() {
        return hasEmbeds;
    }

    public MessageLog setHasEmbeds(boolean hasEmbeds) {
        this.hasEmbeds = hasEmbeds;
        return this;
    }
}
