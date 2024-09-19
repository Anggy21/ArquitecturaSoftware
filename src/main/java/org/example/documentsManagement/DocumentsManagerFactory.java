package org.example.documentsManagement;

public class DocumentsManagerFactory {

    public static DocumentsManager getFormat(String format){
        return switch (format){
            case "JSON" -> jsonManagerFormat();
            case "PDF" -> pdfManagerFormat();
            case "XML" -> xmlManagerFormat();
            default -> throw new RuntimeException("Formato inválido");
        };
    }

    public static JsonManager jsonManagerFormat(){
        return new JsonManager();
    }

    public static PdfManager pdfManagerFormat(){
        return new PdfManager();
    }

    public static XMLManager xmlManagerFormat(){
        return new XMLManager();
    }

}
