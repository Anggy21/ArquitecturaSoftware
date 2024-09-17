package Persistences.repository.studentsRepository;

import Entities.courses_registration.RegisterCourse;
import Persistences.CoursesRegistrationDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegisterCourseRepository implements Repository<RegisterCourse, Long>{
    Connection connection;
    PreparedStatement preparedStatement;
    StudentReposiroty studentReposiroty;
    CourseRepository courseRepository;
    ProgramRepository programRepository;
    RegisterCourse registerCourse;

    public RegisterCourseRepository(){
        connection = CoursesRegistrationDB.getConnection();
        studentReposiroty = new StudentReposiroty();
        courseRepository = new CourseRepository();
        programRepository = new ProgramRepository();
        registerCourse = new RegisterCourse();
    }
    @Override
    public void save(RegisterCourse registerCourse) {
        String query = "INSERT INTO register_course(id_register, id_student, idProgram, id_course) values (?,?,?,?)";

        try {

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setLong(1, registerCourse.getIdRegister());
            preparedStatement.setLong(2, registerCourse.getIdStudent().getIdStudent());
            preparedStatement.setLong(3, registerCourse.getIdProgram().getIdProgram());
            preparedStatement.setLong(4, registerCourse.getIdCourse().getIdCourse());



            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void update(RegisterCourse registerCourse) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public RegisterCourse findById(Long id) {
        try{
            String query = "SELECT * FROM register_course WHERE id_register = ?";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                createRegisterCourse(resultSet);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return registerCourse;
    }

    @Override
    public List<RegisterCourse> findAll() {
        List<RegisterCourse> registerCoursesList = new ArrayList<>();

        try{
            String query = "SELECT * FROM register_course";
            preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                registerCoursesList.add(createRegisterCourse(resultSet));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return registerCoursesList;
    }

    public RegisterCourse createRegisterCourse(ResultSet resultSet){

        try{
            registerCourse.setIdRegister(resultSet.getLong("id_register"));
            registerCourse.setIdStudent(studentReposiroty.findById(resultSet.getLong("id_student")));
            registerCourse.setIdProgram(programRepository.findById(resultSet.getLong("id_program")));
            registerCourse.setIdCourse(courseRepository.findById(resultSet.getLong("id_course")));
        }catch (Exception e){
            e.printStackTrace();
        }

        return registerCourse;
    }

}
