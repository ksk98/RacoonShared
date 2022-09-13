package com.bots.RaccoonShared.Logging;

import com.bots.RaccoonShared.Logging.Exceptions.LogException;
import com.bots.RaccoonShared.Logging.Loggers.ILogger;
import com.bots.RaccoonShared.Logging.Loggers.Logger;

/***
 * Used to acquire name of the class or method calling the code.
 */
public class CallerAcquirement {
    private static CallerAcquirement instance = null;
    private ILogger ILogger = new Logger() {
        @Override
        public void fallbackLog(Log log, String error) {

        }

        @Override
        public void displayLog(Log log) throws LogException {
            System.out.println(log.toString());
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
            ILogger.logError(
                    getClass().getCanonicalName() + ": " + getClass().getEnclosingMethod().getName(),
                    "Received an empty stack trace array when trying to dig for a caller class name."
            );
        } else {
            try {
                return Thread.currentThread().getStackTrace()[depth + 2].getClassName();
            } catch (ArrayIndexOutOfBoundsException e) {
                ILogger.logError(
                        getClass().getCanonicalName() + ": " + getClass().getEnclosingMethod().getName(),
                        "Depth of " + depth + " was too deep for current stack trace."
                );
            }
        }

        return "???";
    }

    public void setLogger(ILogger ILogger) {
        this.ILogger = ILogger;
    }
}
