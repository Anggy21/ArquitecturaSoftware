package org.example.DTO.salesRegister;

import org.example.Entities.sales_register.Product;
import org.example.Entities.sales_register.Sale;

public class SaleDetailDTO {

    private long idSaleDetail;
    private Sale idSale;
    private long idProduct;

    public SaleDetailDTO() {
    }

    public SaleDetailDTO(long idSaleDetail, Sale idSale, long idProduct) {
        this.idSaleDetail = idSaleDetail;
        this.idSale = idSale;
        this.idProduct = idProduct;
    }

    public long getIdSaleDetail() {
        return idSaleDetail;
    }

    public void setIdSaleDetail(long idSaleDetail) {
        this.idSaleDetail = idSaleDetail;
    }

    public Sale getIdSale() {
        return idSale;
    }

    public void setIdSale(Sale idSale) {
        this.idSale = idSale;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }
}
