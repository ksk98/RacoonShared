package com.bots.RaccoonShared.Logging.Loggers;

import com.bots.RaccoonShared.Logging.Exceptions.LogException;
import com.bots.RaccoonShared.Logging.Log;

/***
 * Base implementation of Logger interface.
 */
public abstract class Logger implements ILogger {
    /***
     * Handle a log that couldn't be handled with primary method with a fallback method.
     * @param log log to handle
     * @param error error that occurred during primary handling of log
     */
    protected abstract void fallbackLog(Log log, String error);

    /***
     * Log display implementation method.
     * @param log log to display
     * @throws LogException when log could not be displayed with primary method
     */
    protected abstract void displayLog(Log log) throws LogException;

    @Override
    public final void log(Log log) {
        try {
            displayLog(log);
        } catch (LogException e) {
            fallbackLog(log, e.toString());
        }
    }

    @Override
    public void log(String caller, String message) {
        log(new Log(caller, message, COLOR_DEFAULT));
    }

    @Override
    public void logError(String caller, String message) {
        log(new Log(caller, message, COLOR_ERROR));
    }

    @Override
    public void logSuccess(String caller, String message) {
        log(new Log(caller, message, COLOR_SUCCESS));
    }

    @Override
    public void logInfo(String caller, String message) {
        log(new Log(caller, message, COLOR_INFO));
    }
}
