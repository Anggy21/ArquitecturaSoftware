package org.example.Controllers.registerCourse;

import org.example.Entities.courses_registration.RegisterCourse;
import org.example.Services.registerCourseServices.RegisterCourseService;

import java.util.List;

public class RegisterCourseController {
    private RegisterCourseService registerCourseService;

    public RegisterCourseController(){
        this.registerCourseService = new RegisterCourseService();
    }

    public void registerCourse(RegisterCourse registerCourse){
        registerCourseService.registerCourse(registerCourse);
    }
    public void deleteRegisterCourse(long id){
        registerCourseService.deleteRegisterCourse(id);
    }

    public RegisterCourse findRegisterCourseById(long id){
        return registerCourseService.findRegisterCourseById(id);
    }

    public List<RegisterCourse> findAllRegisterCourses(){
        return registerCourseService.findAllRegisterCourses();
    }
}
