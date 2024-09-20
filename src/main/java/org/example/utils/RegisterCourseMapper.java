package org.example.utils;

import org.example.DTO.registerCourse.RegisterCourseDTO;
import org.example.Entities.courses_registration.Course;
import org.example.Entities.courses_registration.RegisterCourse;
import org.example.Persistences.repository.studentsRepository.CourseRepository;
import org.example.Persistences.repository.studentsRepository.StudentReposiroty;

public class RegisterCourseMapper {
    private static final CourseRepository courseRepository = new CourseRepository();
    private static final StudentReposiroty studentReposiroty = new StudentReposiroty();

    public static RegisterCourse mapToRegisterCourse(RegisterCourseDTO registerCourseDTO) {
        RegisterCourse registerCourse = new RegisterCourse();
        registerCourse.setIdRegister(registerCourseDTO.getIdRegister());
        registerCourse.setIdStudent(studentReposiroty.findById(registerCourseDTO.getIdStudent()));
        registerCourse.setIdCourse(courseRepository.findById(registerCourseDTO.getIdCourse()));
        return registerCourse;
    }

    public static RegisterCourseDTO mapToRegisterCourseDTO(RegisterCourse registerCourse){
        RegisterCourseDTO registerCourseDTO = new RegisterCourseDTO();
        registerCourseDTO.setIdRegister(registerCourse.getIdRegister());
        registerCourseDTO.setIdStudent(registerCourse.getIdStudent().getIdStudent());
        registerCourseDTO.setIdCourse(registerCourse.getIdCourse().getIdCourse());
        return registerCourseDTO;
    }
}
