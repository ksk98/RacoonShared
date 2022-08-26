package com.bots.RacoonShared.SocketCommunication;

import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class CommunicationUtil {
    /***
     * Use given PrintWriter to send given data.
     * @throws IOException if PrintWriter has encountered an error
     */
    public static void sendTo(PrintWriter out, JSONObject object) throws IOException {
        out.print(object + "\r\n\r\n");
        out.flush();

        if (out.checkError())
            throw new IOException("An error was caught by the given PrintWriter instance.");
    }

    /***
     * Read incoming data from given DataInputStream.
     * @throws IOException if DataInputStream has encountered an error
     */
    public static String readUntilEndFrom(DataInputStream in) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int endReadingStage = 0;
        while (endReadingStage < 4) {
            char c = in.readChar();
            if ((endReadingStage == 0 || endReadingStage == 2) && c == '\r')
                endReadingStage += 1;
            else if ((endReadingStage == 1 || endReadingStage == 3) && c == '\n')
                endReadingStage += 1;
            else
                endReadingStage = 0;

            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }
}
