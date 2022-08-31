package com.bots.RacoonShared.Logging.Loggers;

import com.bots.RacoonShared.Logging.Log;

public abstract class LoggerBase implements Logger {
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
