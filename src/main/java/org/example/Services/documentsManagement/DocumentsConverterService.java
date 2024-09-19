package org.example.Services.documentsManagement;

import org.example.documentsManagement.DocumentsManagerFactory;

public class DocumentsConverterService {

    public String convertToFormat(String format,String path){
        return DocumentsManagerFactory.getFormat(format).convert(path);
    }

}
