import com.bots.RaccoonShared.Discord.BotMessage;
import com.bots.RaccoonShared.Discord.Channel;
import com.bots.RaccoonShared.Discord.MessageLog;
import com.bots.RaccoonShared.Discord.ServerChannels;
import com.bots.RaccoonShared.Util.SerializationUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class SocketDataTransportClassesSerializationTests {

    @Test
    public void BotMessageSerialization() {
        BotMessage in = new BotMessage("serverId", "channelId", "message");
        serializeDeserializeAndAssertEquals(in, BotMessage.class);
    }

    @Test
    public void ChannelAndServerChannelSerialization() {
        Channel inChannel = new Channel("channelId", "channelName");
        serializeDeserializeAndAssertEquals(inChannel, Channel.class);

        List<Channel> channels = new LinkedList<>();
        channels.add(inChannel);

        ServerChannels inServerChannels = new ServerChannels("serverId", "serverName", channels);
        ServerChannels outServerChannels = serializeAndDeserialize(inServerChannels, ServerChannels.class);

        if (outServerChannels == null) return;

        Assertions.assertEquals(inServerChannels.serverId, outServerChannels.serverId);
        Assertions.assertEquals(inServerChannels.serverName, outServerChannels.serverName);
        Assertions.assertEquals(inServerChannels.getLastSelectedChannelIndex(), outServerChannels.getLastSelectedChannelIndex());
        Assertions.assertEquals(inServerChannels.channels, outServerChannels.channels);
    }

    @Test
    public void MessageLogSerialization() {
        MessageLog in = new MessageLog(
                "serverId", "channelId", "username", Color.CYAN,
                "message", true, true
        );

        serializeDeserializeAndAssertEquals(in, MessageLog.class);
    }

    private <T extends Serializable> void serializeDeserializeAndAssertEquals(T in, Class<T> clazz) {
        T out = serializeAndDeserialize(in, clazz);

        Assertions.assertEquals(in, out);
    }

    private <T extends Serializable> T serializeAndDeserialize(T in, Class<T> clazz) {
        String serialized;
        try {
            serialized = SerializationUtil.toString(in);
            return clazz.cast(SerializationUtil.fromString(serialized));
        } catch (IOException | ClassNotFoundException e) {
            Assertions.fail(e.toString());
            return null;
        }
    }
}
