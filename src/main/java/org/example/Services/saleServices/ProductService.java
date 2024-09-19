package org.example.Services.saleServices;

import org.example.DTO.salesRegister.ProductDTO;
import org.example.Entities.sales_register.Product;
import org.example.Persistences.repository.sales.ProductRepository;
import org.example.utils.GenericMapper;

import java.util.List;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(ProductDTO productDTO) {
        productRepository.save(GenericMapper.map(productDTO, Product.class));
    }

    public void updateProduct(ProductDTO productDTO) {
        productRepository.update(GenericMapper.map(productDTO, Product.class));
    }

    public void deleteProduct(Long idProduct) {
        productRepository.delete(idProduct);
    }

    public ProductDTO getProduct(Long idProduct) {
        return GenericMapper.map(productRepository.findById(idProduct),ProductDTO.class);
    }

    public List<ProductDTO> getProducts() {
        return GenericMapper.mapList(productRepository.findAll(),ProductDTO.class);
    }

}
