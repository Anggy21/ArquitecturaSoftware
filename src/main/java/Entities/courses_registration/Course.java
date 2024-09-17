package Entities.courses_registration;

public class Course {
    private int idCourse;
    private String course;
    private Program idProgram;

    public Course() {
    }
    public Course(int id_course, String course, Program id_program) {
        this.idCourse = id_course;
        this.course = course;
        this.idProgram = id_program;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int id_course) {
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
