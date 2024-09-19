package org.example;

import org.example.Controllers.StudentController;
import org.example.Persistences.repository.studentsRepository.StudentReposiroty;
import org.example.Services.registerCourseServices.StudentService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService(new StudentReposiroty());
        StudentController studentController = new StudentController(studentService);

        studentController.viewAllStudents();
    }
}