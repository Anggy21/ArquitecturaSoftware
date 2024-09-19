package Entities.sales_register;

public class SaleDetail {

    private long idSaleDetail;
    private Sale idSale;
    private Product idProduct;

    public SaleDetail() {
    }

    public SaleDetail(long idSaleDetail, Sale idSale, Product idProduct) {
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

    public Product getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
    }
}
