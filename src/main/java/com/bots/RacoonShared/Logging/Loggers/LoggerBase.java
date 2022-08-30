package com.bots.RacoonShared.Logging.Loggers;

import com.bots.RacoonShared.Logging.Log;

public abstract class LoggerBase implements Logger {
    private final int baseDepth = 2;
    protected final int depth;

    /***
     * @param additionalDepth should be 1 when class is extended or 0 when implemented directly
     */
    protected LoggerBase(int additionalDepth) {
        this.depth = baseDepth + additionalDepth;
    }

    @Override
    public void log(String message) {
        log(new Log(depth, message, COLOR_DEFAULT));
    }

    @Override
    public void logError(String message) {
        log(new Log(depth, message, COLOR_ERROR));
    }

    @Override
    public void logSuccess(String message) {
        log(new Log(depth, message, COLOR_SUCCESS));
    }

    @Override
    public void logInfo(String message) {
        log(new Log(depth, message, COLOR_INFO));
    }
}
