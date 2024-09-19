package org.example.Controllers.documentsManagement;

import org.example.Services.documentsManagement.DocumentsConverterService;

public class DocumentsManagementController {

    private final DocumentsConverterService documentsConverterService;

    public DocumentsManagementController(){
        documentsConverterService = new DocumentsConverterService();
    }

    public String convertFile(String format,String path){
        return documentsConverterService.convertToFormat(format,path);
    }

}
