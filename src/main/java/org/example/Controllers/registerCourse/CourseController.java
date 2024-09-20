package org.example.Controllers.registerCourse;

import org.example.DTO.registerCourse.CourseDTO;
import org.example.DTO.registerCourse.ProgramDTO;
import org.example.Entities.courses_registration.Course;
import org.example.Entities.courses_registration.Program;
import org.example.Services.registerCourseServices.CourseService;

import java.util.List;

public class CourseController {
    private CourseService courseService;

    public CourseController() {
        this.courseService = new CourseService();
    }

    public void viewCoursesByProgram(ProgramDTO program){
      courseService.findCoursesByProgram(program);
    }

    public List<CourseDTO> viewAllCourses() {
        return courseService.findAllCourses();
    }

    public CourseDTO viewCourseById(long id) {return courseService.findCourseById(id);
    }

}
