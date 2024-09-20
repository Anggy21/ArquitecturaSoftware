package org.example.Services;

import org.example.DTO.ProgramDTO;
import org.example.Entities.Course;
import org.example.Entities.Program;
import org.example.Persistences.repository.studentsRepository.CourseRepository;
import org.example.utils.GenericMapper;

import java.util.List;

public class CourseService {
    private CourseRepository courseRepository;

    public CourseService() {
        courseRepository = new CourseRepository();
    }

    public Course findCourseById(long id) {
        return courseRepository.findById(id);
    }
    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    public List<Course> findCoursesByProgram(ProgramDTO program) {
        return courseRepository.findCoursesByProgram(GenericMapper.map(program,Program.class));
    }

}
