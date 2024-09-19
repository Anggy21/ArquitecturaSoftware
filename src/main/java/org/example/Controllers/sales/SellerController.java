package org.example.Controllers.sales;

import org.example.DTO.salesRegister.SellerDTO;
import org.example.Services.saleServices.SellerService;

import java.util.List;

public class SellerController {

    private final SellerService sellerService;

    public SellerController() {
        this.sellerService = new SellerService();
    }

    public List<SellerDTO> findAll() {
        return sellerService.getAllSellers();
    }

    public SellerDTO findById(long id) {
        return sellerService.getSellerById(id);
    }
}
