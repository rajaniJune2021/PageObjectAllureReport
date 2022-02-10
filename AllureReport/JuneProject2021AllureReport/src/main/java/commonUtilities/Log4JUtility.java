package commonUtilities;

import org.apache.log4j.Logger;

public class Log4JUtility {

    static Logger log = Logger.getLogger("devpinoyLogger");

    public static void logDebug(String message){
        log.debug(message);
    }
    public static  void logInfo(String message){
        log.info(message);
    }

    public static  void logWarn(String message){
        log.warn(message);
    }

    public static  void logError(String message){
        log.error(message);
    }

    public static  void logFatal(String message){
        log.fatal(message);
    }

}
