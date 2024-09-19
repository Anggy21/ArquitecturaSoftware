package org.example.utils;

import org.example.DTO.salesRegister.SaleDetailDTO;
import org.example.Entities.sales_register.Sale;
import org.example.Entities.sales_register.SaleDetail;
import org.example.Persistences.repository.sales.ProductRepository;
import org.example.Persistences.repository.sales.SaleRepository;

public class SaleDetailMapper {

    private final static SaleRepository saleRepository = new SaleRepository();
    private final static ProductRepository productRepository = new ProductRepository();

    public static SaleDetail mapToSale(SaleDetailDTO saleDetailDTO){
        SaleDetail saleDetail = new SaleDetail();
        saleDetail.setIdSale(saleRepository.findById(saleDetailDTO.getIdSale()));
        saleDetail.setIdProduct(productRepository.findById(saleDetailDTO.getIdProduct()));

        return saleDetail;
    }

    public static SaleDetailDTO mapToSaleDTO(SaleDetail saleDetail){
        SaleDetailDTO saleDetailDTO = new SaleDetailDTO();
        saleDetailDTO.setIdSale(saleDetail.getIdSale().getIdSale());
        saleDetailDTO.setIdProduct(saleDetail.getIdProduct().getIdProduct());

        return saleDetailDTO;
    }

}
