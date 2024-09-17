package Entities.sales_register;

public class Product {
    private int idProduct;
    private String product;
    private float price;

    public Product() {
    }
    public Product(int idProduct, String product, float price) {
        this.idProduct = idProduct;
        this.product = product;
        this.price = price;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
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
