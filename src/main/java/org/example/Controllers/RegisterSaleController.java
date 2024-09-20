package org.example.Controllers;

import DTO.ProductDTO;
import DTO.SaleDTO;
import DTO.SellerDTO;
import Entities.Seller;
import org.example.Services.facade.SaleFacade;

import java.util.List;

public class RegisterSaleController {

    private final SaleFacade saleFacade;

    public RegisterSaleController(){
        this.saleFacade = new SaleFacade();
    }

    public String registerSale(SaleDTO saleDTO, List<ProductDTO> products){
        return saleFacade.registerSale(saleDTO, products);
    }

    public List<ProductDTO> getAllProducts(){
        return saleFacade.viewAllProducts();
    }

    public ProductDTO getProductById(long id){
        return saleFacade.viewProductById(id);
    }

    public List<SellerDTO> getAllSellers(){
        return saleFacade.getAllSeller();
    }

    public SellerDTO getSellerById(long id){
        return saleFacade.getSellerById(id);
    }
}
