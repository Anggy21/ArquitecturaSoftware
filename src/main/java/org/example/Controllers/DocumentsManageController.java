package org.example.Controllers;

import org.example.Services.facade.DocumentsManagementFacade;

public class DocumentsManageController {

    private final DocumentsManagementFacade documentsManagementFacade;

    public DocumentsManageController(){
        this.documentsManagementFacade = new DocumentsManagementFacade();
    }

    public String convertDocument(String format, String path){
        return documentsManagementFacade.convertDocument(format, path);
    }

}
