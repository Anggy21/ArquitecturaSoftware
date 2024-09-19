package org.example.Persistences.repository.studentsRepository;

import org.example.Entities.courses_registration.Course;
import org.example.Entities.courses_registration.Program;
import org.example.Persistences.repository.Repository;
import org.example.Persistences.connection.CoursesRegistrationDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository implements Repository<Course, Long> {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ProgramRepository programRepository;

    public CourseRepository(){
        connection = CoursesRegistrationDB.getConnection();
        programRepository = new ProgramRepository();
    }

    @Override
    public void save(Course course) {

    }

    @Override
    public void update(Course course) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Course findById(Long id) {
        Course course = new Course();
        try {
            String query = "SELECT * FROM courses WHERE id_courses = ?";
            preparedStatement = connection.prepareStatement(query);


            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery(query);

            while (resultSet.next()){
                course.setIdCourse(resultSet.getLong("id_courses"));
                course.setCourse(resultSet.getString("course"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return course;
    }

    @Override
    public List<Course> findAll() {
        List<Course> courseList = new ArrayList<>();

        try{
            String query = "SELECT * FROM courses";
            ResultSet resultSet = preparedStatement.executeQuery(query);

            while (resultSet.next()){
                Course course = new Course();

                int id = resultSet.getInt("id_courses");
                String namecourse = resultSet.getString("course");
                Program idProgram = programRepository.findById(resultSet.getLong("id_program"));


                course.setIdCourse(id);
                course.setCourse(namecourse);
                course.setIdProgram(idProgram);

                courseList.add(course);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return courseList;
    }
}
