package org.example.DTO.salesRegister;

public class ProductDTO {

    private long idProduct;
    private String product;
    private float price;

    public ProductDTO() {
    }
    public ProductDTO(long idProduct, String product, float price) {
        this.idProduct = idProduct;
        this.product = product;
        this.price = price;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
