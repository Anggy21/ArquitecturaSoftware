package org.example.documentsManagement;

public class PdfManager implements DocumentsManager {
    @Override
    public String convert(String path) {
        return "Archivo convertido a pdf";
    }
}
