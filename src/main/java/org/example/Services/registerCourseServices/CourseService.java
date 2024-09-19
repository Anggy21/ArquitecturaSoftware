package org.example.Services.registerCourseServices;

import org.example.Entities.courses_registration.Course;
import org.example.Entities.courses_registration.Program;
import org.example.Persistences.repository.studentsRepository.CourseRepository;

import java.util.List;

public class CourseService {
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course findCourseById(long id) {
        return courseRepository.findById(id);
    }
    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    public List<Course> findCoursesByProgram(Program program) {
        return courseRepository.findCoursesByProgram(program);
    }

}
