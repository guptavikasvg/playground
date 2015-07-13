package dataAccess;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

class DBProperties {
    private static Logger logger = Logger.getLogger(DBProperties.class.getName());

    public static final String MYSQL_CONNECTION_PROPERTIES_FILE = "mysql.connection.properties";

    public static final String HOSTNAME;
    public static final int PORT;
    public static final String USERNAME;
    public static final String PASSWORD;

    static {
        Properties props = new Properties();
        try {
            props.load(DBProperties.class.getClassLoader().getResourceAsStream(MYSQL_CONNECTION_PROPERTIES_FILE));

            HOSTNAME = props.getProperty("hostname");
            PORT     = Integer.valueOf(props.getProperty("port"));
            USERNAME = props.getProperty("username");
            PASSWORD = props.getProperty("password");
        } catch (IOException e) {
            throw new RuntimeException("Unable to load DB connection properties " + MYSQL_CONNECTION_PROPERTIES_FILE);
        }
    }
}