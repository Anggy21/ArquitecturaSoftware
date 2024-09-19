package org.example.DTO.salesRegister;

import org.example.Entities.sales_register.Product;
import org.example.Entities.sales_register.Sale;

public class SaleDetailDTO {

    private long idSaleDetail;
    private long idSale;
    private long idProduct;

    public SaleDetailDTO() {
    }

    public SaleDetailDTO(long idSaleDetail, long idSale, long idProduct) {
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

    public long getIdSale() {
        return idSale;
    }

    public void setIdSale(long idSale) {
        this.idSale = idSale;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }
}
