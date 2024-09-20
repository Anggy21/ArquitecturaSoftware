package org.example.Controllers;

import org.example.DTO.ProgramDTO;
import org.example.Services.ProgramService;
import org.example.utils.GenericMapper;

import java.util.List;

public class ProgramController {
    private final ProgramService programService;

    public ProgramController() {
        this.programService = new ProgramService();
    }

    public ProgramDTO findProgramById(long id){
        return GenericMapper.map(programService.findProgramById(id), ProgramDTO.class);
        
    }

    public List<ProgramDTO> viewPrograms(){
        return GenericMapper.mapList(programService.findAllPrograms(), ProgramDTO.class);
    }
}
