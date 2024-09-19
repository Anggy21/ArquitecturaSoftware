package org.example.Services.registerCourseServices;

import org.example.Entities.courses_registration.Course;
import org.example.Entities.courses_registration.Program;
import org.example.Entities.courses_registration.RegisterCourse;
import org.example.Entities.courses_registration.Student;
import org.example.Persistences.repository.studentsRepository.RegisterCourseRepository;

import java.util.List;

public class RegisterCourseService {
    private RegisterCourseRepository registerCourseRepository;

    public RegisterCourseService(RegisterCourseRepository registerCourseRepository) {
        this.registerCourseRepository = registerCourseRepository;
    }

    public void registerCourse(long registerId, Student studentId, Course courseId, Program programId) throws Exception {
    if (studentId == null || courseId == null || programId == null) {
            throw new Exception("Id cannot be null");
        }

        RegisterCourse registerCourse = new RegisterCourse(registerId, studentId, courseId);

        registerCourseRepository.save(registerCourse);
    }

    public void deleteRegisterCourse(long registerId) throws Exception {
        if (registerId != 0) {
            registerCourseRepository.delete(registerId);
        } else {
            throw new Exception("Id cannot found");
        }
    }

    public RegisterCourse findRegisterCourseById(long registerId) {
        return registerCourseRepository.findById(registerId);
    }

    public List<RegisterCourse> findAllRegisterCourses() {
        List<RegisterCourse> allRegisterCourses = registerCourseRepository.findAll();
        return allRegisterCourses;
    }
}
