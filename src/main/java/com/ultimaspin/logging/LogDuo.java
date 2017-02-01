package com.ultimaspin.logging;

import org.apache.logging.log4j.LogManager;

public class LogDuo {

    public static Logger getLogger(Class<?> clazz) {
        return new LoggerImpl(LogManager.getLogger(clazz));
    }

}
