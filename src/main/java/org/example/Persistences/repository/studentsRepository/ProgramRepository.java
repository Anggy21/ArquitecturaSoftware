package org.example.Persistences.repository.studentsRepository;

import org.example.Entities.courses_registration.Program;
import org.example.Persistences.repository.Repository;
import org.example.Persistences.connection.CoursesRegistrationDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgramRepository implements Repository<Program, Long> {
    Connection connection;
    PreparedStatement preparedStatement;

    public ProgramRepository(){
        connection = CoursesRegistrationDB.getConnection();
    }
    @Override
    public void save(Program program) {

    }

    @Override
    public void update(Program program) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Program findById(Long id) {
        Program program = new Program();

        try {
            String query = "SELECT * FROM programs WHERE id_program = ?";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int idProgram = resultSet.getInt("id_program");
                String nameProgram = resultSet.getString("program");

                program.setIdProgram(idProgram);
                program.setProgram(nameProgram);
            }

            preparedStatement.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return program;
    }

    @Override
    public List<Program> findAll() {
        List<Program> programList = new ArrayList<>();

        String query = "SELECT * FROM programs";

        try {
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Program program = new Program();

                int idProgram = resultSet.getInt("id_program");
                String nameProgram = resultSet.getString("program");

                program.setIdProgram(idProgram);
                program.setProgram(nameProgram);

                programList.add(program);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return programList;
    }
}
