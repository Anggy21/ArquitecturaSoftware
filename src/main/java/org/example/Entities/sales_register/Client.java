package org.example.Entities.sales_register;

public class Client {
    private long idClient;
    private String dniClient;
    private String nameClient;
    private String lnClient;

    public Client() {
    }

    public Client(Long idClient, String dniClient, String nameClient, String lnClient) {
        this.idClient = idClient;
        this.dniClient = dniClient;
        this.nameClient = nameClient;
        this.lnClient = lnClient;
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public String getDniClient() {
        return dniClient;
    }

    public void setDniClient(String dniClient) {
        this.dniClient = dniClient;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getLnClient() {
        return lnClient;
    }

    public void setLnClient(String lnClient) {
        this.lnClient = lnClient;
    }
}
