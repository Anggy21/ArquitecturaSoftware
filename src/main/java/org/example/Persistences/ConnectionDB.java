package org.example.Persistences;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static Connection connectionDB;
    private ConnectionDB() {
    }
    public static void setConnection(String url, String user, String password) {
        Connection connection;

        try {

            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Connection aux = connectionDB;
        if(aux != null) {
            try {
                aux.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        connectionDB = connection;
    }

    public static Connection getConnection() {
        return connectionDB;
    }
}

