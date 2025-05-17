package org.example.app.config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnect {

    public static Connection connect(){
        Properties props = new Properties();
        Connection conn = null;

        try {
            props.load(DBConnect.class.getResourceAsStream("db/idbc.properties"));
            conn = DriverManager.getConnection(props.getProperty("dbDriver")+ props.getProperty("dbName"), props.getProperty("username"), props.getProperty("password"));
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    return conn;
    }
}
