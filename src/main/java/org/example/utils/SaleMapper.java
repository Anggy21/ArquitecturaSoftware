package org.example.utils;

import org.example.DTO.salesRegister.SaleDTO;
import org.example.Entities.sales_register.Sale;
import org.example.Persistences.repository.sales.ClientRepository;
import org.example.Persistences.repository.sales.SellerRepository;

public class SaleMapper {

    private final static ClientRepository clientRepository = new ClientRepository();
    private final static SellerRepository sellerRepository = new SellerRepository();

    public static SaleDTO toSaleDTO(Sale sale){
        SaleDTO saleDTO = new SaleDTO();
        saleDTO.setIdSale(sale.getIdSale());
        saleDTO.setDate(sale.getDate());
        saleDTO.setTotal(sale.getTotal());
        saleDTO.setIdSeller(sale.getIdSeller().getIdSeller());
        saleDTO.setIdClient(sale.getIdClient().getIdClient());
        return saleDTO;
    }

    public static Sale toSale(SaleDTO saleDTO){
        Sale sale = new Sale();
        sale.setIdSale(saleDTO.getIdSale());
        sale.setDate(saleDTO.getDate());
        sale.setTotal(saleDTO.getTotal());
        sale.setIdSeller(sellerRepository.findById(saleDTO.getIdSeller()));
        sale.setIdClient(clientRepository.findById(saleDTO.getIdClient()));
        return sale;
    }

}
