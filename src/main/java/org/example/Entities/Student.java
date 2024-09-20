package org.example.Entities;

public class Student {
    private long idStudent;
    private String codeStudent;
    private String nameStudent;

    private String lnStudent;

    public Student() {
    }

    public Student(long idStudent, String codStudent, String nameStudent, String lnStudent) {
        this.idStudent = idStudent;
        this.codeStudent = codStudent;
        this.nameStudent = nameStudent;
        this.lnStudent = lnStudent;
    }

    public long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(long idStudent) {
        this.idStudent = idStudent;
    }

    public String getCodeStudent() {
        return codeStudent;
    }

    public void setCodeStudent(String codeStudent) {
        this.codeStudent = codeStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getLnStudent() {
        return lnStudent;
    }

    public void setLnStudent(String lnStudent) {
        this.lnStudent = lnStudent;
    }
}
