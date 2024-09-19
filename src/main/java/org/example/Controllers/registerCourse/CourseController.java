package org.example.Controllers.registerCourse;

import org.example.Entities.courses_registration.Course;
import org.example.Entities.courses_registration.Program;
import org.example.Services.registerCourseServices.CourseService;

import java.util.List;

public class CourseController {
    private CourseService courseService;

    public CourseController(){
    }
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    public void viewCoursesByProgram(Program program){
        List<Course> coursesList = courseService.findCoursesByProgram(program);

        for (Course course : coursesList) {
            System.out.println(course);
        }
    }

}
