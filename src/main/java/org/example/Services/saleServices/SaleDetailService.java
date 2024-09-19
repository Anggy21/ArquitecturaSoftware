package org.example.Services.saleServices;

import org.example.DTO.salesRegister.SaleDetailDTO;
import org.example.Entities.sales_register.SaleDetail;
import org.example.Persistences.repository.sales.SaleDetailRepository;
import org.example.utils.SaleDetailMapper;

import java.util.List;

public class SaleDetailService {

    private final SaleDetailRepository saleDetailRepository;

    public SaleDetailService() {
        this.saleDetailRepository = new SaleDetailRepository();
    }

    public void save(SaleDetailDTO saleDetail) {
        saleDetailRepository.save(SaleDetailMapper.mapToSale(saleDetail));
    }

    public List<SaleDetail> findAllByIdSale(long idSale) {
        return saleDetailRepository.findByIdSale(idSale);
    }



}
