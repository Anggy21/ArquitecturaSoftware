package org.example.Controllers.registerCourse;

import org.example.Entities.courses_registration.Program;
import org.example.Entities.courses_registration.StudentProgram;
import org.example.Services.registerCourseServices.StudentProgramService;

import java.util.List;

public class StudentProgramController {
    private StudentProgramService studentProgramService;

    public StudentProgramController() {
        this.studentProgramService = new StudentProgramService();
    }

    public StudentProgram findStudentProgramById(long id){
        return studentProgramService.findStudentProgramById(id);
    }
    public List<StudentProgram> findAllStudentProgram() {
        return studentProgramService.findAllStudentPrograms();
    }

    public List<Program> findProgramsByStudentsId(long id){
        return studentProgramService.findProgramsByStudentId(id);
    }
}
