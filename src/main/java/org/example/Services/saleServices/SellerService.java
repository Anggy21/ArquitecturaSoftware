package org.example.Services.saleServices;

import org.example.DTO.salesRegister.SellerDTO;
import org.example.Persistences.repository.sales.SellerRepository;
import org.example.utils.GenericMapper;

import java.util.List;

public class SellerService {

    private final SellerRepository sellerRepository;

    public SellerService() {
        this.sellerRepository = new SellerRepository();
    }

    public SellerDTO getSellerById(long id) {
        return GenericMapper.map(sellerRepository.findById(id), SellerDTO.class);
    }

    public List<SellerDTO> getAllSellers() {
        return GenericMapper.mapList(sellerRepository.findAll(), SellerDTO.class);
    }

}
