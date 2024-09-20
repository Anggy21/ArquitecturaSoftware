package org.example.DTO.registerCourse;

import org.example.Entities.courses_registration.RegisterCourse;

public class RegisterCourseDTO {
    private long idRegister;
    private long idStudent;
    private long idCourse;

    public RegisterCourseDTO(){}

    public RegisterCourseDTO(long idRegister, long idStudent, long idCourse){
        this.idRegister = idRegister;
        this.idStudent = idStudent;
        this.idCourse = idCourse;
    }

    public long getIdRegister() {
        return idRegister;
    }

    public void setIdRegister(long idRegister) {
        this.idRegister = idRegister;
    }

    public long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(long idStudent) {
        this.idStudent = idStudent;
    }

    public long getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(long idCourse) {
        this.idCourse = idCourse;
    }
}
