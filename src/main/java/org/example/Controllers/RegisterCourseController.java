package org.example.Controllers;

import org.example.DTO.RegisterCourseDTO;
import org.example.DTO.responses.RegisterCourseResponseDTO;
import org.example.Services.RegisterCourseService;
import org.example.utils.RegisterCourseMapper;

import java.util.List;

public class RegisterCourseController {
    private final RegisterCourseService registerCourseService;

    public RegisterCourseController(){
        this.registerCourseService = new RegisterCourseService();
    }

    public void registerCourse(RegisterCourseDTO registerCourse){
        registerCourseService.registerCourse(registerCourse);
    }

    public void deleteRegisterCourse(long id){
        registerCourseService.deleteRegisterCourse(id);
    }

    public RegisterCourseResponseDTO findRegisterCourseById(long id){
        return RegisterCourseMapper.mapToRegisterCourseResponseDTO(registerCourseService.findRegisterCourseById(id));
    }

    public List<RegisterCourseResponseDTO> findAllRegisterCourses(){
        return registerCourseService.findAllRegisterCourses().stream().map(RegisterCourseMapper::mapToRegisterCourseResponseDTO).toList();
    }
}
