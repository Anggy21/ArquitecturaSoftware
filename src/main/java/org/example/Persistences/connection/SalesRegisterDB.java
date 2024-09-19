package org.example.Persistences.connection;

import java.sql.Connection;

public class SalesRegisterDB {
    private static Connection connection;

    private SalesRegisterDB(){
        ConnectionDB.setConnection("jdbc:mysql://localhost:3306/sales_register", "root", "root");
        connection = ConnectionDB.getConnection();
    }

    public static Connection getConnection(){

        if (connection == null){
            new SalesRegisterDB();
        }

        return connection;
    }
}
