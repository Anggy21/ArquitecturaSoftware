package Persistences;

import Entities.courses_registration.Course;
import Entities.courses_registration.Program;
import Entities.courses_registration.RegisterCourse;
import Entities.courses_registration.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
