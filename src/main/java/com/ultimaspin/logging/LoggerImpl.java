package com.ultimaspin.logging;

import java.util.stream.Stream;

import static com.ultimaspin.logging.Duo.duo;
import static java.util.stream.Collectors.joining;

public class LoggerImpl implements Logger {

    private static final String DUO_SEPARATOR = " ";
    private static final String MESSAGE_KEY = "message";

    private final org.apache.logging.log4j.Logger log4jLogger;

    public LoggerImpl(org.apache.logging.log4j.Logger log4jLogger) {
        this.log4jLogger = log4jLogger;
    }

    private CharSequence convertToString(Duo[] duos) {
        return Stream.of(duos)
                .map(Duo::getDuoString)
                .collect(joining(DUO_SEPARATOR));
    }

    private CharSequence convertToString(String message, Duo[] duos) {
        Duo[] duosWithMessage = new Duo[duos.length + 1];
        System.arraycopy(duos, 0, duosWithMessage, 0, duos.length);
        duosWithMessage[duosWithMessage.length - 1] = duo(MESSAGE_KEY, message);
        return convertToString(duosWithMessage);
    }

    public void info(String message, Duo... duos) {
        CharSequence logMessage = convertToString(message, duos);
        log4jLogger.info(logMessage);
    }

    public void info(String message, Throwable t, Duo... duos) {
        CharSequence logMessage = convertToString(message, duos);
        log4jLogger.info(logMessage, t);
    }

    public void info(Duo... duos) {
        CharSequence logMessage = convertToString(duos);
        log4jLogger.info(logMessage);
    }

}
