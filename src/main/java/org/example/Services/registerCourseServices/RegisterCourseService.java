package org.example.Services.registerCourseServices;

import org.example.DTO.registerCourse.ProgramDTO;
import org.example.DTO.registerCourse.RegisterCourseDTO;
import org.example.Entities.courses_registration.Course;
import org.example.Entities.courses_registration.Program;
import org.example.Entities.courses_registration.RegisterCourse;
import org.example.Entities.courses_registration.Student;
import org.example.Persistences.repository.studentsRepository.CourseRepository;
import org.example.Persistences.repository.studentsRepository.RegisterCourseRepository;
import org.example.utils.GenericMapper;
import org.example.utils.RegisterCourseMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RegisterCourseService {
    private final RegisterCourseRepository registerCourseRepository;
    private final CourseService courseService;
    private final StudentProgramService studentProgramService;


    public RegisterCourseService(){
        this.registerCourseRepository = new RegisterCourseRepository();
        this.courseService = new CourseService();
        this.studentProgramService = new StudentProgramService();
    }

    public void registerCourse(RegisterCourseDTO registerCourse) {
        List<Program> programs = studentProgramService.findProgramsByStudentId(registerCourse.getIdStudent());

        List<Course> courses = new ArrayList<>();

        for (Program program : programs) {
            ProgramDTO programDTO = GenericMapper.map(program, ProgramDTO.class);
            courses.addAll(courseService.findCoursesByProgram(programDTO));
        }

        Optional<Course> courseFiltered = courses.stream().filter(course -> course.getIdCourse() == registerCourse.getIdCourse()).findFirst();

        if (courseFiltered.isEmpty())
            return;

        registerCourseRepository.save(RegisterCourseMapper.mapToRegisterCourse(registerCourse));
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
