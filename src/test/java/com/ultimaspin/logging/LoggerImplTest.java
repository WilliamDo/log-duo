package com.ultimaspin.logging;

import org.junit.Test;

import static com.ultimaspin.logging.Duo.duo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LoggerImplTest {

    @Test
    public void info() {
        org.apache.logging.log4j.Logger mockLogger = mock(org.apache.logging.log4j.Logger.class);
        Logger logger = new LoggerImpl(mockLogger);
        logger.info(duo("message", "Hello World"), duo("foo", "bar"));
        logger.info("Hello World", duo("foo", "bar"));
        logger.info("Exception", new Exception(), duo("foo", "bar"));

        verify(mockLogger).info((CharSequence) "message=\"Hello World\" foo=\"bar\"");
        verify(mockLogger).info((CharSequence) "foo=\"bar\" message=\"Hello World\"");
        verify(mockLogger).info(
                (CharSequence) eq("foo=\"bar\" message=\"Exception\""),
                any(Exception.class)
        );
    }
}
