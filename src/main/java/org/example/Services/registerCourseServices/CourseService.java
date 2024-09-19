package org.example.Services.registerCourseServices;

import org.example.Entities.courses_registration.Course;
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
        List<Course> allCourses = courseRepository.findAll();
        return allCourses;
    }
}
