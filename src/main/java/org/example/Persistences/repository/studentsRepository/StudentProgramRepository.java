package org.example.Persistences.repository.studentsRepository;

import org.example.Entities.courses_registration.Program;
import org.example.Entities.courses_registration.StudentProgram;
import org.example.Persistences.repository.Repository;
import org.example.Persistences.connection.CoursesRegistrationDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentProgramRepository implements Repository<StudentProgram, Long> {
    Connection connection;
    PreparedStatement preparedStatement;
    ProgramRepository programRepository;
    StudentReposiroty studentReposiroty;

    public StudentProgramRepository(){
        connection = CoursesRegistrationDB.getConnection();
        programRepository = new ProgramRepository();
        studentReposiroty = new StudentReposiroty();
    }
    @Override
    public void save(StudentProgram studentProgramRepository) {

    }

    @Override
    public void update(StudentProgram studentProgramRepository) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public StudentProgram findById(Long id) {
        StudentProgram studentProgram = new StudentProgram();

        try{
            String query = "SELECT * FROM student_program WHERE id_students_programs = ?";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                studentProgram.setIdStudentProgram(resultSet.getLong("id_students_programs"));
                studentProgram.setIdStudent(studentReposiroty.findById(resultSet.getLong("id_student")));
                studentProgram.setIdProgram(programRepository.findById(resultSet.getLong("id_program")));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return studentProgram;
    }

    @Override
    public List<StudentProgram> findAll() {
        List<StudentProgram> studentProgramList = new ArrayList<>();

        try{
            String query = "SELECT * FROM students_programs";
            preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                StudentProgram studentProgram = new StudentProgram();

                studentProgram.setIdStudentProgram(resultSet.getLong("id_students_programs"));
                studentProgram.setIdStudent(studentReposiroty.findById(resultSet.getLong("id_student")));
                studentProgram.setIdProgram(programRepository.findById(resultSet.getLong("id_program")));

                studentProgramList.add(studentProgram);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return studentProgramList;
    }

    public List<Program> findProgramByStudentId(long id) {
        List<Program> programList = new ArrayList<>();

        try {
            String query = "SELECT * FROM students_programs WHERE id_student = ?";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Program program;
                program = programRepository.findById(resultSet.getLong("id_program"));

                programList.add(program);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return programList;
    }
}
