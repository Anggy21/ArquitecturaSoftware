package org.example.Entities.courses_registration;

public class RegisterCourse {
    private long idRegister;
    private Student idStudent;
    private Course idCourse;



    public RegisterCourse() {
    }
    public RegisterCourse(long id_register, Student id_student, Course id_course) {
        this.idRegister = id_register;
        this.idStudent = id_student;
        this.idCourse = id_course;
    }

    public long getIdRegister() {
        return idRegister;
    }

    public void setIdRegister(long idRegister) {
        this.idRegister = idRegister;
    }

    public Student getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Student idStudent) {
        this.idStudent = idStudent;
    }

    public Course getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Course idCourse) {
        this.idCourse = idCourse;
    }

}
