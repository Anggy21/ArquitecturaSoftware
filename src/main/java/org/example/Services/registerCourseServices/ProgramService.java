package org.example.Services.registerCourseServices;

import org.example.Entities.courses_registration.Program;
import org.example.Persistences.repository.studentsRepository.ProgramRepository;

import java.util.List;

public class ProgramService {
    private ProgramRepository programRepsiory;

    public ProgramService() {
        this.programRepsiory = new ProgramRepository();
    }

    public Program findProgramById(long id) {
        return programRepsiory.findById(id);
    }

    public List<Program> findAllPrograms() {
        return programRepsiory.findAll();
    }

}
