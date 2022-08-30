package com.bots.RacoonShared.Logging;

import com.bots.RacoonShared.Logging.Loggers.Logger;
import com.bots.RacoonShared.Logging.Loggers.LoggerBase;

/***
 * Used to acquire name of the class or method calling the code.
 */
public class CallerAcquirement {
    private final int baseDepth = 2;
    private static CallerAcquirement instance = null;
    private Logger logger = new LoggerBase(0) {
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

    public String getMethodName() {
        return getMethodName(baseDepth + 1);
    }

    public String getMethodName(int additionalDepth) {
        try {
            return Thread.currentThread().getStackTrace()[additionalDepth + baseDepth].getMethodName();
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.logError(getClassName() + " received an empty stack trace array when trying to get a method name.");
        }

        return "???";
    }

    public String getClassName() {
        return getClassName(baseDepth + 1);
    }

    public String getClassName(int additionalDepth) {
        try {
            return Thread.currentThread().getStackTrace()[additionalDepth + baseDepth].getClassName();
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.logError("Utility class received an empty stack trace array when trying to get a class name.");
        }

        return "???";
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
