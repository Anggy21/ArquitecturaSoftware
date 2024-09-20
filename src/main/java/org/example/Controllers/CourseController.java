package org.example.Controllers;

import org.example.DTO.CourseDTO;
import org.example.DTO.ProgramDTO;
import org.example.Services.CourseService;
import org.example.utils.GenericMapper;

import java.util.List;

public class CourseController {
    private final CourseService courseService;

    public CourseController() {
        this.courseService = new CourseService();
    }

    public List<CourseDTO> viewCoursesByProgram(ProgramDTO program){
      return GenericMapper.mapList(courseService.findCoursesByProgram(program), CourseDTO.class);
    }

    public List<CourseDTO> viewAllCourses() {
        return GenericMapper.mapList(courseService.findAllCourses(), CourseDTO.class);
    }

    public CourseDTO viewCourseById(long id) {
        return GenericMapper.map(courseService.findCourseById(id), CourseDTO.class);
    }

}
