package org.example.Persistences.repository.sales;

import org.example.Entities.sales_register.Seller;
import org.example.Persistences.connection.SalesRegisterDB;
import org.example.Persistences.repository.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SellerRepository implements Repository<Seller,Long> {

    private final Connection connection;
    private PreparedStatement preparedStatement;

    public SellerRepository(){
        connection = SalesRegisterDB.getConnection();
    }

    @Override
    public void save(Seller seller) {
        throw new RuntimeException("Method not allowed");
    }

    @Override
    public void update(Seller seller) {
        throw new RuntimeException("Method not allowed");
    }

    @Override
    public void delete(Long aLong) {
        throw new RuntimeException("Method not allowed");
    }

    @Override
    public Seller findById(Long aLong) {

        Seller seller;

        try {
            preparedStatement = connection.prepareStatement("select * from register_sales where id_sale = ?");

            preparedStatement.setLong(1,aLong);

            seller = createSeller(preparedStatement.executeQuery());

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return seller;

    }

    @Override
    public List<Seller> findAll() {

        List<Seller> sellers = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement("select * from sellers");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                sellers.add(createSeller(resultSet));
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return sellers;
    }

    private Seller createSeller(ResultSet resultSet){
        try {
            return new Seller(resultSet.getLong("id_seller"),resultSet.getString("name_seller"),resultSet.getString("ln_seller"),resultSet.getString("dni_seller"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
