package utilities;

import java.util.logging.*;
import java.io.IOException;

public class LogSetup{
    public static final String LOGGER_NAME = "myLogger";
    private static final String logName = "logs/log%g.txt";

    public static void setupLog() throws IOException {
        Logger logger = Logger.getLogger(LOGGER_NAME);
        FileHandler fileHandler = new FileHandler(logName, false);
        fileHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(fileHandler);
        //logger.addHandler(new ConsoleHandler());
        logger.setLevel(Level.INFO);
    }
}
