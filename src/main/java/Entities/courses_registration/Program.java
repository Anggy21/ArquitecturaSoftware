package Entities.courses_registration;

public class Program {
    private long idProgram;
    private String program;

    public Program() {
    }

    public Program(long id_program, String program) {
        this.idProgram = id_program;
        this.program = program;
    }

    public long getIdProgram() {
        return idProgram;
    }

    public void setIdProgram(long id_program) {
        this.idProgram = id_program;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
}
