package org.example.Entities.sales_register;

public class Seller {
    private long idSeller;
    private String dniSeller;
    private String nameSeller;
    private String lnSeller;

    public Seller() {
    }

    public Seller(long idSeller,  String nameSeller, String lnSeller,String dniSeller) {
        this.idSeller = idSeller;
        this.dniSeller = dniSeller;
        this.nameSeller = nameSeller;
        this.lnSeller = lnSeller;
    }

    public long getIdSeller() {
        return idSeller;
    }

    public void setIdSeller(long idSeller) {
        this.idSeller = idSeller;
    }

    public String getDniSeller() {
        return dniSeller;
    }

    public void setDniSeller(String dniSeller) {
        this.dniSeller = dniSeller;
    }

    public String getNameSeller() {
        return nameSeller;
    }
    
    public void setNameSeller(String nameSeller) {
        this.nameSeller = nameSeller;
    }

    public String getLnSeller() {
        return lnSeller;
    }

    public void setLnSeller(String lnSeller) {
        this.lnSeller = lnSeller;
    }
}
