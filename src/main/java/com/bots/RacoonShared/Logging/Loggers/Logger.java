package com.bots.RacoonShared.Logging.Loggers;

import com.bots.RacoonShared.Logging.Exceptions.LogException;
import com.bots.RacoonShared.Logging.Log;

import java.awt.*;

/***
 * Displays program logs.
 */
public interface Logger {
    Color COLOR_DEFAULT = Color.BLACK;
    Color COLOR_ERROR = new Color(252, 31, 31);
    Color COLOR_SUCCESS = new Color(47, 213, 24);
    Color COLOR_INFO = new Color(31, 142, 252);

    /***
     * Display a given log.
     */
    void log(Log log);

    /***
     * Create and display a log consisting of a given message, a caller determined by context and a black font color.
     * @param message - displayed message
     */
    void log(String caller, String message);

    /***
     * Create and display a log consisting of a given message, a caller determined by context and a red font color.
     * @param message - displayed message
     */
    void logError(String caller, String message);

    /***
     * Create and display a log consisting of a given message, a caller determined by context and a green font color.
     * @param message - displayed message
     */
    void logSuccess(String caller, String message);

    /***
     * Create and display a log consisting of a given message, a caller determined by context and a blue font color.
     * @param message - displayed message
     */
    void logInfo(String caller, String message);
}

