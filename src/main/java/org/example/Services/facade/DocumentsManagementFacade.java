package org.example.Services.facade;

import Controllers.DocumentsManagementController;

public class DocumentsManagementFacade {

    private final DocumentsManagementController documentsManagementController;

    public DocumentsManagementFacade(){
        this.documentsManagementController = new DocumentsManagementController();
    }

    public String convertDocument(String format,String path){
        return documentsManagementController.convertFile(format,path);
    }

}
