package org.example.Persistences.repository.studentsRepository;

import org.example.Entities.courses_registration.Student;
import org.example.Persistences.repository.Repository;
import org.example.Persistences.connection.CoursesRegistrationDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentReposiroty implements Repository<Student, Long> {
    Connection connection;
    PreparedStatement preparedStatement;

    public StudentReposiroty(){
        connection = CoursesRegistrationDB.getConnection();
    }

    @Override
    public void save(Student student) {

    }
    @Override
    public void update(Student student) {

    }
    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Student findById(Long aLong) {
        Student student = new Student();
        try {
            String query = "SELECT * FROM students WHERE id_students = ?";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setLong(1, aLong);
            ResultSet resultSet = preparedStatement.executeQuery(query);

            while (resultSet.next()){
                student.setIdStudent(resultSet.getLong("id_students"));
                student.setCodeStudent(resultSet.getString("code_student"));
                student.setNameStudent(resultSet.getString("name_student"));
                student.setLnStudent(resultSet.getString("ln_student"));

            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> findAll() {

        List<Student> studentList = new ArrayList<>();

        try {
            String query = "SELECT * FROM students";
            preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student();

                long id = resultSet.getLong("id_student");
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
            preparedStatement.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return studentList;
    }
}
