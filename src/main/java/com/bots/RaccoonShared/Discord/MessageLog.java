package com.bots.RaccoonShared.Discord;

import java.awt.*;
import java.io.Serializable;

public record MessageLog(String serverId, String channelId, String username,
                         Color userColor, String message, boolean userIsBot,
                         boolean hasEmbeds) implements Serializable {
}
