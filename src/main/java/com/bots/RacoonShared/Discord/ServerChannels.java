package com.bots.RacoonShared.Discord;

import java.io.Serializable;
import java.util.List;

public class ServerChannels implements Serializable {
    public final String serverId;
    public final String serverName;
    public final List<Channel> channels;
    private int lastSelectedChannelIndex = 0;

    public ServerChannels(String serverId, String serverName, List<Channel> channels) {
        this.serverId = serverId;
        this.serverName = serverName;
        this.channels = channels;
    }

    public int getLastSelectedChannelIndex() {
        return lastSelectedChannelIndex;
    }

    public void setLastSelectedChannelIndex(int lastSelectedChannelIndex) {
        this.lastSelectedChannelIndex = lastSelectedChannelIndex;
    }

    @Override
    public String toString() {
        return serverName;
    }
}
