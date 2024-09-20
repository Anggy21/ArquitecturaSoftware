package org.example.Services.registerCourseServices;

import org.example.Entities.courses_registration.Student;
import org.example.Persistences.repository.studentsRepository.StudentReposiroty;

import java.util.List;

public class StudentService {
    private StudentReposiroty studentReposiroty;

    public StudentService() {
        this.studentReposiroty = new StudentReposiroty();
    }
    public Student findStudentById(long id) {
        return studentReposiroty.findById(id);
    }
    public List<Student> findAllStudents() {
        return studentReposiroty.findAll();
    }
}
