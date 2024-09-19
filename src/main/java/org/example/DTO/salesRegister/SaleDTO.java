package org.example.DTO.salesRegister;

import org.example.Entities.sales_register.Client;
import org.example.Entities.sales_register.Seller;

import java.sql.Date;

public class SaleDTO {

    private long idSale;
    private long idSeller;
    private long idClient;
    private Date date;
    private float total;

    public SaleDTO() {
    }

    public SaleDTO(long idSale, long idSeller, long idClient, Date date, float total) {
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

    public long getIdSeller() {
        return idSeller;
    }

    public void setIdSeller(long idSeller) {
        this.idSeller = idSeller;
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
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
