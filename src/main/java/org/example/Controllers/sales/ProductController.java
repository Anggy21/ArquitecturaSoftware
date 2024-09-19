package org.example.Controllers.sales;

import org.example.DTO.salesRegister.ProductDTO;
import org.example.Services.saleServices.ProductService;

import java.util.List;

public class ProductController {

    private final ProductService productService;

    public ProductController(){
        this.productService = new ProductService();
    }

    public void saveProduct(ProductDTO productDTO){
        productService.addProduct(productDTO);
    }

    public void updateProduct(ProductDTO productDTO){
        productService.updateProduct(productDTO);
    }

    public void deleteProduct(Long id){
        productService.deleteProduct(id);
    }

    public ProductDTO findProductById(Long id){
        return productService.getProduct(id);
    }

    public List<ProductDTO> findAllProducts(){
        return productService.getProducts();
    }


}
