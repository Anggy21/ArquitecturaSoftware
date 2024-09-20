package org.example.Controllers;

import org.example.DTO.ProgramDTO;
import org.example.Services.StudentProgramService;
import org.example.utils.GenericMapper;

import java.util.List;

public class StudentProgramController {

    private final StudentProgramService studentProgramService;

    public StudentProgramController() {
        studentProgramService = new StudentProgramService();
    }

    public List<ProgramDTO> findProgramsByStudentId(Long id){
        return GenericMapper.mapList(studentProgramService.findProgramsByStudentId(id), ProgramDTO.class);
    }
}
