package org.example.Controllers;

import org.example.Entities.courses_registration.Student;
import org.example.Services.registerCourseServices.StudentService;

public class StudentController {
    private StudentService studentService;

    public StudentController() {
    }
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    public void viewStudentById(long id) {
        Student student = studentService.findStudentById(id);

        System.out.println("Student ID: " + student.getIdStudent());
        System.out.println("Student Code: " + student.getCodeStudent());
        System.out.println("Student Name: " + student.getNameStudent());
        System.out.println("Student Last Name: " + student.getLnStudent());
    }

    public void viewAllStudents() {
        studentService.findAllStudents().forEach(student -> {
            System.out.println("Student ID: " + student.getIdStudent());
            System.out.println("Student Code: " + student.getCodeStudent());
            System.out.println("Student Name: " + student.getNameStudent());
            System.out.println("Student Last Name: " + student.getLnStudent());
        });
    }
}
