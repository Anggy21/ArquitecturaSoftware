package org.example.Services.registerCourseServices;

import org.example.Entities.courses_registration.StudentProgram;
import org.example.Persistences.repository.studentsRepository.StudentProgramRepository;

import java.util.List;

public class StudentProgramService {
    private StudentProgramRepository studentProgramRepository;

    public StudentProgramService(StudentProgramRepository studentProgramRepository) {
        this.studentProgramRepository = studentProgramRepository;
    }

    public StudentProgram findStudentProgramById(long id) {
        return studentProgramRepository.findById(id);
    }
    public List<StudentProgram> findAllStudentPrograms() {
        List<StudentProgram> allStudentPrograms = studentProgramRepository.findAll();
        return allStudentPrograms;
    }
}
