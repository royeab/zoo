//package utilities.Log;
//
//import org.apache.logging.log4j.core.appender.ConsoleAppender;
//import utilities.Log.exceptions.LogFileException;
//import org.apache.logging.log4j.*;
//
////import java.util.logging.*;
////import java.io.IOException;
//
//public class LogSetup{
//    public static final String LOGGER_NAME = "myLogger";
//    private static final String logName = "logs/log%g.txt";
//
//    public static void setupLog() throws LogFileException {
//        Logger logger = LogManager.getLogger(LOGGER_NAME);
//        ConsoleAppender consoleAppender = new ConsoleAppender();
//        LogManager logManager = LogManager.
//
//        FileHandler fileHandler;
//        try {
//            fileHandler = new FileHandler(logName, false);
//        }
//        catch (IOException ioException) {
//            throw new LogFileException(ioException.getMessage());
//        }
//
//        fileHandler.setFormatter(new SimpleFormatter());
//        logger.addHandler(fileHandler);
//        logger.setLevel(Level.INFO);
//    }
//}
