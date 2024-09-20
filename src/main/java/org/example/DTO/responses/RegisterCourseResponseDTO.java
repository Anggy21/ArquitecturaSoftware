package org.example.DTO.responses;

public class RegisterCourseResponseDTO {
    private String student;
    private String course;
    private String program;

    public RegisterCourseResponseDTO(){}

    public RegisterCourseResponseDTO(String student, String course, String program){
        this.student = student;
        this.course = course;
        this.program = program;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
}
