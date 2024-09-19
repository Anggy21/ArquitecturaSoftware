package org.example.Persistences.connection;

import java.sql.*;

public class CoursesRegistrationDB {
    private static Connection connection;

    private CoursesRegistrationDB(){
        ConnectionDB.setConnection("jdbc:mysql://localhost:3306/courses_registration", "root", "root");
        connection = ConnectionDB.getConnection();
    }

    public static Connection getConnection() {
        if (connection == null){
            new CoursesRegistrationDB();
        }
        return connection;
    }


}
