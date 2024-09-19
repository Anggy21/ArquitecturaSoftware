package org.example.Entities.sales_register;

public class Sale {
    private int idSale;
    private Seller idSeller;
    private Client idClient;
    private String date;
    private float total;

    public Sale() {
    }

    public Sale(int idSale, Seller idSeller, Client idClient, String date, float total) {
        this.idSale = idSale;
        this.idSeller = idSeller;
        this.idClient = idClient;
        this.date = date;
        this.total = total;
    }

    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    public Seller getIdSeller() {
        return idSeller;
    }

    public void setIdSeller(Seller idSeller) {
        this.idSeller = idSeller;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
