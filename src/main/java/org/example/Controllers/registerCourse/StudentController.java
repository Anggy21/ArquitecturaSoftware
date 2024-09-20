package org.example.Controllers.registerCourse;

import org.example.Entities.courses_registration.Student;
import org.example.Services.registerCourseServices.StudentService;

import java.util.List;

public class StudentController {
    private StudentService studentService;

    public StudentController() {
        studentService = new StudentService();
    }

    public Student viewStudentById(long id) {
        return studentService.findStudentById(id);
    }

    public List<Student> viewAllStudents() {
        return studentService.findAllStudents();
    }
}
