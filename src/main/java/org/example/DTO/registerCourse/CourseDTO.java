package org.example.DTO.registerCourse;

public class CourseDTO {
    private long idCourse;
    private String course;
    private long idProgram;

    public CourseDTO(){}

    public CourseDTO(long idCourse, String course, long idProgram){
        this.idCourse = idCourse;
        this.course = course;
        this.idProgram = idProgram;
    }

    public long getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(long idCourse) {
        this.idCourse = idCourse;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public long getIdProgram() {
        return idProgram;
    }

    public void setIdProgram(long idProgram) {
        this.idProgram = idProgram;
    }
}
