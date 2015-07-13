package utils;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Place holder for Utility methods that can be shared by the entire codebase
 */
public class Utils {
    private static Logger logger = Logger.getLogger(Utils.class.getName());

    static void closeQuietly(AutoCloseable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                logger.log(Level.WARNING, "Could not close closeable resource.", e);
            }
        }
    }
}
