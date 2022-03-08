package util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
public class LoggerTest {

    private static final Logger logger = Logger.getLogger(
            LoggerTest.class);

    private LoggerTest() {
    }

    private static Logger getLogger() {
        if (logger == null) {
            new LoggerTest();
        }
        return logger;
    }

    public static void log(Level level, String msg) {
        getLogger().log(level, msg);

    }
}

