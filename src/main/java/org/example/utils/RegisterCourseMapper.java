package org.example.utils;

import org.example.DTO.RegisterCourseDTO;
import org.example.DTO.responses.RegisterCourseResponseDTO;
import org.example.Entities.RegisterCourse;
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

    public static RegisterCourseResponseDTO mapToRegisterCourseResponseDTO(RegisterCourse registerCourse){
        RegisterCourseResponseDTO registerCourseResponseDTO = new RegisterCourseResponseDTO();
        registerCourseResponseDTO.setStudent(registerCourse.getIdStudent().getNameStudent());
        registerCourseResponseDTO.setCourse(registerCourse.getIdCourse().getCourse());
        registerCourseResponseDTO.setProgram(registerCourse.getIdCourse().getIdProgram().getProgram());
        return registerCourseResponseDTO;
    }
}
