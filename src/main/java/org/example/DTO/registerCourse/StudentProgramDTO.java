package org.example.DTO.registerCourse;

public class StudentProgramDTO {
    private long idStudentProgram;
    private long idStudent;
    private long idProgram;

    public StudentProgramDTO(){}
    public StudentProgramDTO(long idStudentProgram, long idStudent, long idProgram){
        this.idStudentProgram = idStudentProgram;
        this.idStudent = idStudent;
        this.idProgram = idProgram;
    }

    public long getIdStudentProgram() {
        return idStudentProgram;
    }

    public void setIdStudentProgram(long idStudentProgram) {
        this.idStudentProgram = idStudentProgram;
    }

    public long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(long idStudent) {
        this.idStudent = idStudent;
    }

    public long getIdProgram() {
        return idProgram;
    }

    public void setIdProgram(long idProgram) {
        this.idProgram = idProgram;
    }
}
