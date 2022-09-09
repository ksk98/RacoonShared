package com.bots.RacoonShared.SocketCommunication;

public enum SocketOperationIdentifiers {
    // SERVER -> CLIENT
    LOG_SERVER_LOG_TO_CLIENT(),     // Server sends own log that will be displayed in client app as remote log
    LOG_MESSAGE_TO_CLIENT(),        // Server sends discord message received by bot to be displayed in client app
    UPDATE_SERVER_CHANNEL_LIST(),   // Server sends list of servers and channels that the bot is in to be used by client app
    SSL_HANDSHAKE_COMPLETE(),       // Server sends SSL handshake confirmation to client

    // CLIENT -> SERVER
    CLIENT_LOGIN(),                 // Client attempts to authorize with username and password
    CLIENT_DISCONNECT(),            // Client announces to server about disconnection
    REQUEST_SERVER_CHANNEL_LIST(),  // Client attempts to manually trigger UPDATE_SERVER_CHANNEL_LIST
    SEND_MESSAGE_AS_BOT()           // Client sends a message as bot
    ;


    @Override
    public String toString() {
        return this.name();
    }
}
