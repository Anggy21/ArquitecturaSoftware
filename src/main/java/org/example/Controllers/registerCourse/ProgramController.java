package org.example.Controllers.registerCourse;

import org.example.Entities.courses_registration.Program;
import org.example.Services.registerCourseServices.ProgramService;

import java.util.List;

public class ProgramController {
    private ProgramService programService;

    public ProgramController() {
        this.programService = new ProgramService();
    }

    public void findProgramById(long id){
        programService.findProgramById(id);
        
    }

    public void viewPrograms(){
        programService.findAllPrograms();
    }
}
