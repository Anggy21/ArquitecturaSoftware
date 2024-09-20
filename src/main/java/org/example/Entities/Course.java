package org.example.Entities;

public class Course {
    private long idCourse;
    private String course;
    private Program idProgram;

    public Course() {
    }
    public Course(long id_course, String course, Program id_program) {
        this.idCourse = id_course;
        this.course = course;
        this.idProgram = id_program;
    }

    public long getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(long id_course) {
        this.idCourse = id_course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Program getIdProgram() {
        return idProgram;
    }

    public void setIdProgram(Program id_program) {
        this.idProgram = id_program;
    }
}
