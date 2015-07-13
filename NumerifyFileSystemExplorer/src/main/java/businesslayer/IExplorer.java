package businesslayer;

import java.sql.SQLException;

/**
 * Created by vgupta on 6/14/15.
 */
public interface IExplorer {
    /**
     * Process a directory by finding every file under it and storing it in the database.
     * @param path - a directory path
     * @throws SQLException - thrown when an error is encountered while connecting/writing to the database.
     */
    void processDirectory(String path) throws SQLException;

    /**
     * Searches for all occurences of given <code>fileName</code> and prints their complete paths on the console.
     * @param fileName - name of the file to be searched
     * @throws SQLException - thrown when an error is encountered while connecting to/reading the database.
     */
    void search(String fileName) throws SQLException;

    /**
     * Shut down the explorer.
     */
    void close();
}
