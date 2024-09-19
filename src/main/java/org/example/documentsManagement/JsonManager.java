package org.example.documentsManagement;

public class JsonManager implements DocumentsManager{
    @Override
    public String convert(String path) {
        return "Archivo convertido a formato JSON";
    }
}
