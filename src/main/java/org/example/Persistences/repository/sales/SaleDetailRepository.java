package org.example.Persistences.repository.sales;

import org.example.Entities.sales_register.SaleDetail;
import org.example.Persistences.connection.SalesRegisterDB;
import org.example.Persistences.repository.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SaleDetailRepository implements Repository<SaleDetail,Long> {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private final ProductRepository productRepository;
    private final SaleRepository saleRepository;

    public SaleDetailRepository(){
        connection = SalesRegisterDB.getConnection();
        productRepository = new ProductRepository();
        saleRepository = new SaleRepository();
    }

    @Override
    public void save(SaleDetail saleDetail) {

        try {
            preparedStatement = connection.prepareStatement("insert into sale_details values(?,?)");

            preparedStatement.setLong(1,saleDetail.getIdSale().getIdSale());
            preparedStatement.setLong(2,saleDetail.getIdProduct().getIdProduct());

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(SaleDetail saleDetail) {
        throw new RuntimeException("Method not allowed");
    }

    @Override
    public void delete(Long aLong) {
        throw new RuntimeException("Method not allowed");
    }

    @Override
    public SaleDetail findById(Long aLong) {
        throw new RuntimeException("Method not allowed");
    }

    @Override
    public List<SaleDetail> findAll() {
        throw new RuntimeException("Method not allowed");
    }

    public List<SaleDetail> findByIdSale(Long idSale){

        List<SaleDetail> saleDetails = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement("select * from sale_details where id_sale = ?");

            preparedStatement.setLong(1,idSale);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                saleDetails.add(createSaleDetail(resultSet));
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return saleDetails;
    }

    private SaleDetail createSaleDetail(ResultSet resultSet){

        SaleDetail saleDetail = new SaleDetail();

        try {

            saleDetail.setIdSale(saleRepository.findById(resultSet.getLong("id_sale")));
            saleDetail.setIdProduct(productRepository.findById(resultSet.getLong("id_product")));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return saleDetail;
    }
}
