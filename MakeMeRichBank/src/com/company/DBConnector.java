package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    public final static String DB_DRIVER_CLASS = "";
    public final static String DB_URL = "";
    public final static String DB_USERNAME = "";
    public final static String DB_PASSWORD = "";

    /**
     * DB connector that returns a connection
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName(DB_DRIVER_CLASS);
        conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        return conn;
    }
}
