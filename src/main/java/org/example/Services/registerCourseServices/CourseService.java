package org.example.Services.registerCourseServices;

import org.example.DTO.registerCourse.CourseDTO;
import org.example.DTO.registerCourse.ProgramDTO;
import org.example.Entities.courses_registration.Course;
import org.example.Entities.courses_registration.Program;
import org.example.Persistences.repository.studentsRepository.CourseRepository;
import org.example.utils.GenericMapper;

import java.util.List;

public class CourseService {
    private CourseRepository courseRepository;

    public CourseService() {
        courseRepository = new CourseRepository();
    }

    public CourseDTO findCourseById(long id) {
        return GenericMapper.map(courseRepository.findById(id), CourseDTO.class);
    }
    public List<CourseDTO> findAllCourses() {
        return GenericMapper.mapList(courseRepository.findAll(), CourseDTO.class);
    }

    public List<Course> findCoursesByProgram(ProgramDTO program) {
        return courseRepository.findCoursesByProgram(GenericMapper.map(program,Program.class));
    }

}
