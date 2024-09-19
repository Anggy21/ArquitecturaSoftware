package org.example.Services.saleServices;

import org.example.DTO.salesRegister.SellerDTO;
import org.example.Persistences.repository.sales.SellerRepository;
import org.example.utils.GenericMapper;

public class SellerService {

    private final SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public SellerDTO getSellerById(long id) {
        return GenericMapper.map(sellerRepository.findById(id), SellerDTO.class);
    }

}
