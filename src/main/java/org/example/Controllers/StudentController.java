package org.example.Controllers;

import org.example.DTO.StudentDTO;
import org.example.Services.StudentService;
import org.example.utils.GenericMapper;

import java.util.List;

public class StudentController {
    private final StudentService studentService;

    public StudentController() {
        studentService = new StudentService();
    }

    public StudentDTO viewStudentById(long id) {
        return GenericMapper.map(studentService.findStudentById(id), StudentDTO.class);
    }

    public List<StudentDTO> viewAllStudents() {
        return GenericMapper.mapList(studentService.findAllStudents(), StudentDTO.class);
    }
}
