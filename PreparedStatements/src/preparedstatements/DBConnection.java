
package preparedstatements;

//Java imports
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Søren Spangsberg
 */
public class DBConnection {
    
    public final static String DB_DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public final static String DB_URL = "jdbc:sqlserver://DB-server;databaseName=DBNAME";
    public final static String DB_USERNAME = "";
    public final static String DB_PASSWORD = "";
        
    /**
     * 
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException
    {
        Connection con = null;
        
        Class.forName(DB_DRIVER_CLASS);
        
        //create the connection
        con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        
        return con;
    }
}
