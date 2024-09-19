package org.example.Entities.sales_register;

public class SaleDetail {

    private int idSaleDetail;
    private Sale idSale;
    private Product idProduct;

    public SaleDetail() {
    }

    public SaleDetail(int idSaleDetail, Sale idSale, Product idProduct) {
        this.idSaleDetail = idSaleDetail;
        this.idSale = idSale;
        this.idProduct = idProduct;
    }

    public int getIdSaleDetail() {
        return idSaleDetail;
    }

    public void setIdSaleDetail(int idSaleDetail) {
        this.idSaleDetail = idSaleDetail;
    }

    public Sale getIdSale() {
        return idSale;
    }

    public void setIdSale(Sale idSale) {
        this.idSale = idSale;
    }

    public Product getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
    }
}
