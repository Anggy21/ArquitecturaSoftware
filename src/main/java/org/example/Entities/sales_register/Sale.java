package org.example.Entities.sales_register;

import java.sql.Date;
import java.time.LocalDateTime;

public class Sale {
    private long idSale;
    private Seller idSeller;
    private Client idClient;
    private Date date;
    private float total;

    public Sale() {
    }

    public Sale(long idSale, Seller idSeller, Client idClient, Date date, float total) {
        this.idSale = idSale;
        this.idSeller = idSeller;
        this.idClient = idClient;
        this.date = date;
        this.total = total;
    }

    public long getIdSale() {
        return idSale;
    }

    public void setIdSale(long idSale) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
