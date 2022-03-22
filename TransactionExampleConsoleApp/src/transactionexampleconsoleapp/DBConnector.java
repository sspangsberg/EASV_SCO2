package transactionexampleconsoleapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author smsj
 */
public class DBConnector {

    public final static String DB_DRIVER_CLASS = "";
    public final static String DB_URL = "";
    public final static String DB_USERNAME = "";
    public final static String DB_PASSWORD = "";

    /**
     * 
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {        
     
        Connection conn = null;
        Class.forName(DB_DRIVER_CLASS);
        conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        return conn;
    }
}
