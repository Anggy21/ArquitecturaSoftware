package Entities.courses_registration;

public class StudentProgram {

    private int idStudentProgram;
    private Student idStudent;
    private Program idProgram;

    public StudentProgram() {
    }

    public StudentProgram(int idStudentProgram, Student idStudent, Program idProgram) {
        this.idStudentProgram = idStudentProgram;
        this.idStudent = idStudent;
        this.idProgram = idProgram;
    }

    public int getIdStudentProgram() {
        return idStudentProgram;
    }

    public void setIdStudentProgram(int idStudentProgram) {
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
