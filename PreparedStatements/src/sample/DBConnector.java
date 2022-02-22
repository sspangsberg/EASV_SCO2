
package sample;

//Java imports
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Søren Spangsberg
 */
public class DBConnector {

    private SQLServerDataSource dataSource;

    public DBConnector() {
        this.dataSource = new SQLServerDataSource();
        this.dataSource.setServerName("10.176.111.31");
        this.dataSource.setDatabaseName("UserDB42");
        this.dataSource.setUser("smsj");
        this.dataSource.setPassword("easv_smsj");
    }

    public Connection getConnection() throws SQLServerException {
        return dataSource.getConnection();
    }
}
