package org.example.Entities;

public class StudentProgram {

    private long idStudentProgram;
    private Student idStudent;
    private Program idProgram;

    public StudentProgram() {
    }

    public StudentProgram(long idStudentProgram, Student idStudent, Program idProgram) {
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

    public Student getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Student idStudent) {
        this.idStudent = idStudent;
    }

    public Program getIdProgram() {
        return idProgram;
    }

    public void setIdProgram(Program idProgram) {
        this.idProgram = idProgram;
    }
}
