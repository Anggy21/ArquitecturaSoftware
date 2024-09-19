package org.example.Services.saleServices;

import org.example.DTO.salesRegister.ProductDTO;
import org.example.DTO.salesRegister.SaleDTO;
import org.example.DTO.salesRegister.SaleDetailDTO;
import org.example.Entities.sales_register.Product;
import org.example.Entities.sales_register.Sale;
import org.example.Persistences.repository.sales.SaleRepository;
import org.example.utils.GenericMapper;
import org.example.utils.SaleMapper;

import java.util.List;

public class SaleService {

    private final SaleRepository saleRepository;
    private final SaleDetailService saleDetailService;

    public SaleService() {
        this.saleRepository = new SaleRepository();
        this.saleDetailService = new SaleDetailService();
    }

    public void registerSale(SaleDTO saleDTO, List<ProductDTO> products) {
        saleRepository.save(SaleMapper.toSale(saleDTO));

        products.forEach(product -> {

            SaleDetailDTO saleDetailDTO = new SaleDetailDTO();
            saleDetailDTO.setIdSale(saleDTO.getIdSale());
            saleDetailDTO.setIdProduct(product.getIdProduct());

            saleDetailService.save(saleDetailDTO);
        });

    }

    public SaleDTO findById(long id) {
        return GenericMapper.map(saleRepository.findById(id), SaleDTO.class);
    }

    public List<SaleDTO> findAll(){
        return GenericMapper.mapList(saleRepository.findAll(), SaleDTO.class);
    }

}
