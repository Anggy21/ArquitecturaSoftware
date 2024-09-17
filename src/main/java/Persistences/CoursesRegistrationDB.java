package Persistences;

import Entities.courses_registration.Course;
import Entities.courses_registration.Program;
import Entities.courses_registration.RegisterCourse;
import Entities.courses_registration.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoursesRegistrationDB {
    private Connection connection;

    public CoursesRegistrationDB(){
        ConnectionDB.setConnection("jdbc:mysql://localhost:3306/courses_registration", "root", "root");
        connection = ConnectionDB.getConnection();
    }


    public List<Student> selectStudents(){
        List<Student> studentList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String query = "SELECT *FROM students";

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Student student = new Student();

                int id = resultSet.getInt("id_students");
                String codeStudent = resultSet.getString("code_student");
                String nameStudent = resultSet.getString("name_student");
                String lnStudent = resultSet.getString("ln_student");

                student.setIdStudent(id);
                student.setCodeStudent(codeStudent);
                student.setNameStudent(nameStudent);
                student.setLnStudent(lnStudent);

                studentList.add(student);
            }

            resultSet.close();
            statement.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return studentList;
    }

    public void insertCourse(RegisterCourse registerCourse){
        String query = "INSERT INTO register_course(id_register, id_student, idProgram, id_course) values (?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, registerCourse.getIdRegister());
            preparedStatement.setInt(2, registerCourse.getIdStudent().getIdStudent());
            preparedStatement.setInt(3, registerCourse.getIdProgram().getIdProgram());
            preparedStatement.setInt(4, registerCourse.getIdCourse().getIdCourse());



            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteCourse(int idCourse){
        String query = "DELETE FROM register_course WHERE id_register = ?";


    }
}
