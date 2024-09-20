package org.example.Services.facade;

import Controllers.ProductController;
import Controllers.SaleController;
import Controllers.SellerController;
import DTO.ProductDTO;
import DTO.SaleDTO;
import DTO.SellerDTO;

import java.util.List;

public class SaleFacade {

    private final SaleController saleController;
    private final ProductController productController;
    private final SellerController sellerController;

    public SaleFacade(){
        this.saleController = new SaleController();
        this.productController = new ProductController();
        this.sellerController = new SellerController();
    }

    public String registerSale(SaleDTO saleDTO, List<ProductDTO> productDTOS){
        saleController.registerSale(saleDTO,productDTOS);

        return "Venta registrada correctamente";
    }

    public List<ProductDTO> viewAllProducts(){
        return productController.findAllProducts();
    }

    public ProductDTO viewProductById(long id){
        return productController.findProductById(id);
    }

    public List<SellerDTO> getAllSeller(){
        return sellerController.findAll();
    }

    public SellerDTO getSellerById(long id){
        return sellerController.findById(id);
    }
}
