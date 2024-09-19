package org.example.Controllers.sales;

import org.example.DTO.salesRegister.ProductDTO;
import org.example.DTO.salesRegister.SaleDTO;
import org.example.Services.saleServices.SaleService;

import java.util.List;

public class SaleController {

    private final SaleService saleService;

    public SaleController() {
        this.saleService = new SaleService();
    }

    public void registerSale(SaleDTO saleDTO, List<ProductDTO> products) {
        saleService.registerSale(saleDTO, products);
    }

    public SaleDTO getSales(Long id) {
        return saleService.findById(id);
    }

    public List<SaleDTO> getAllSales() {
        return saleService.findAll();
    }
}
