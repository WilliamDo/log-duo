package com.ultimaspin.logging;

public interface Logger {

    void info(Duo... duos);

    void info(String message, Duo... duos);

    void info(String message, Throwable t, Duo... duos);

}
