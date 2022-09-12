package com.bots.RaccoonShared.SocketCommunication;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;

public abstract class CommunicationUtil {
    /***
     * Use given PrintWriter to send given data.
     * @throws IOException if BufferedWriter has encountered an error
     */
    public static void sendTo(BufferedWriter out, JSONObject object) throws IOException {
        out.write(object + "\r\n\r\n");
        out.flush();
    }

    /***
     * Read incoming data from given DataInputStream.
     * @throws IOException if DataInputStream has encountered an error
     */
    public static String readUntilEndFrom(DataInputStream in) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int endReadingStage = 0;
        while (endReadingStage < 4) {
            int c = in.readByte();
            if ((endReadingStage == 0 || endReadingStage == 2) && c == '\r')
                endReadingStage += 1;
            else if ((endReadingStage == 1 || endReadingStage == 3) && c == '\n')
                endReadingStage += 1;
            else
                endReadingStage = 0;

            stringBuilder.append((char)c);
        }

        return stringBuilder.toString();
    }
}
