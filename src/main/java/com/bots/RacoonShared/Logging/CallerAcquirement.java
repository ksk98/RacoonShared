package com.bots.RacoonShared.Logging;

import com.bots.RacoonShared.Logging.Loggers.Logger;
import com.bots.RacoonShared.Logging.Loggers.LoggerBase;

/***
 * Used to acquire name of the class or method calling the code.
 */
public class CallerAcquirement {
    private static CallerAcquirement instance = null;
    private Logger logger = new LoggerBase() {
        @Override
        public void log(Log log) {
            System.out.println(log);
        }
    };

    private CallerAcquirement() {

    }

    public static CallerAcquirement getInstance() {
        if (instance == null)
            instance = new CallerAcquirement();

        return instance;
    }

    public String getClassName(int depth) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length == 0) {
            logger.log(new Log(
                    getClass().getCanonicalName() + ": " + getClass().getEnclosingMethod().getName(),
                    "Received an empty stack trace array when trying to dig for a caller class name.",
                    Logger.COLOR_ERROR)
            );
        } else {
            try {
                return Thread.currentThread().getStackTrace()[depth + 2].getClassName();
            } catch (ArrayIndexOutOfBoundsException e) {
                logger.log(new Log(
                        getClass().getCanonicalName() + ": " + getClass().getEnclosingMethod().getName(),
                        "Depth of " + depth + " was too deep for current stack trace.",
                        Logger.COLOR_ERROR)
                );
            }
        }

        return "???";
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
