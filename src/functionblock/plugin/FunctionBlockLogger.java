package functionblock.plugin;

import javax.swing.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by X on 14-1-6.
 */
public class FunctionBlockLogger {
    private static Logger logger = Logger.getLogger(FunctionBlockLogger.class.getName());

    public static void regLogger() {
        String logPath = System.getProperty("user.home") + FunctionBlockConstants.LoggerConstants.LOGGER_FILE_NAME;
        FileHandler fileHandler;
        try {
            fileHandler = new FileHandler(logPath, true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.setLevel(Level.ALL);
            logger.addHandler(fileHandler);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Function Block插件日志启动失败");
        }
    }

    public static boolean log(String msg, Level level) {
        if (logger == null) {
            return false;
        }
        logger.log(level, msg);
        return true;
    }

    public static boolean log(String msg) {
        return log(msg, Level.INFO);
    }
}
