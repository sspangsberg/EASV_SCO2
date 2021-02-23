package thisbankapprocks;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private SQLServerDataSource dataSource;

    public DBConnector() {
        this.dataSource = new SQLServerDataSource();
        this.dataSource.setServerName("");
        this.dataSource.setDatabaseName("");
        this.dataSource.setUser("");
        this.dataSource.setPassword("");
    }

    public Connection getConnection() throws SQLServerException {
        return dataSource.getConnection();
    }
}
