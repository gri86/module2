package factories;

import logger.BufferedFileLogger;
import logger.ConsoleLogger;
import logger.Loggable;

public class LoggerFactory {
    public static Loggable getLogger(){
        return new BufferedFileLogger(10);
    }
}
