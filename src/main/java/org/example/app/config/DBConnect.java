package org.example.app.config;

import org.example.app.view.AppView;

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
            props.load(DBConnect.class.getClassLoader().getResourceAsStream("db/jdbc.properties"));
            conn = DriverManager.getConnection(props.getProperty("dbDriver")+ props.getProperty("dbName"), props.getProperty("username"), props.getProperty("password"));
        } catch (IOException | SQLException e) {
            new AppView().getOutput(e.getMessage());
        }
    return conn;
    }
}
