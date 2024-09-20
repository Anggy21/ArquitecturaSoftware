package org.example.DTO.registerCourse;

public class ProgramDTO {
    private long idProgram;
    private String program;

    public ProgramDTO(){}

    public ProgramDTO(long idProgram, String program){
        this.idProgram = idProgram;
        this. program = program;
    }

    public long getIdProgram() {
        return idProgram;
    }

    public void setIdProgram(long idProgram) {
        this.idProgram = idProgram;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
}
