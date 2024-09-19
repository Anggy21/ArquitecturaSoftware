package org.example.Services.registerCourseServices;

import org.example.Entities.courses_registration.Course;
import org.example.Entities.courses_registration.Program;
import org.example.Entities.courses_registration.RegisterCourse;
import org.example.Entities.courses_registration.Student;
import org.example.Persistences.repository.studentsRepository.CourseRepository;
import org.example.Persistences.repository.studentsRepository.RegisterCourseRepository;

import java.util.ArrayList;
import java.util.List;

public class RegisterCourseService {
    private final RegisterCourseRepository registerCourseRepository;
    private final CourseService courseService;
    private final StudentProgramService studentProgramService;


    public RegisterCourseService(RegisterCourseRepository registerCourseRepository, CourseService courseService, StudentProgramService studentProgramService) {
        this.registerCourseRepository = registerCourseRepository;
        this.courseService = courseService;
        this.studentProgramService = studentProgramService;
    }

    public void registerCourse(RegisterCourse registerCourse) {
        List<Program> programs = studentProgramService.findProgramsByStudentId(registerCourse.getIdStudent().getIdStudent());

        List<Course> courses = new ArrayList<>();

        for (Program program : programs) {
            courses.addAll(courseService.findCoursesByProgram(program));
        }

        if (!courses.contains(registerCourse.getIdCourse())) {
            return;
        }

        registerCourseRepository.save(registerCourse);
    }

    public void deleteRegisterCourse(long id)  {
        registerCourseRepository.delete(id);
    }

    public RegisterCourse findRegisterCourseById(long registerId) {
        return registerCourseRepository.findById(registerId);
    }

    public List<RegisterCourse> findAllRegisterCourses() {
        List<RegisterCourse> allRegisterCourses = registerCourseRepository.findAll();
        return allRegisterCourses;
    }
}
