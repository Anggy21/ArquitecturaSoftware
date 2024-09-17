package Entities.courses_registration;

public class Program {
    private int idProgram;
    private String program;

    public Program() {
    }

    public Program(int id_program, String program) {
        this.idProgram = id_program;
        this.program = program;
    }

    public int getIdProgram() {
        return idProgram;
    }

    public void setIdProgram(int id_program) {
        this.idProgram = id_program;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
}
