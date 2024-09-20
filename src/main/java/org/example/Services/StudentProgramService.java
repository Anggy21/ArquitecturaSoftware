package org.example.Services;

import org.example.Entities.Program;
import org.example.Entities.StudentProgram;
import org.example.Persistences.repository.studentsRepository.StudentProgramRepository;

import java.util.List;

public class StudentProgramService {
    private StudentProgramRepository studentProgramRepository;

    public StudentProgramService() {
        this.studentProgramRepository = new StudentProgramRepository();
    }

    public StudentProgram findStudentProgramById(long id) {
        return studentProgramRepository.findById(id);
    }
    public List<StudentProgram> findAllStudentPrograms() {
        return studentProgramRepository.findAll();
    }

    public List<Program> findProgramsByStudentId(long id) {
        return studentProgramRepository.findProgramByStudentId(id);
    }
}
