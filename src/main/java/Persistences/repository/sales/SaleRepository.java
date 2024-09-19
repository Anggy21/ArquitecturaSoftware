package Persistences.repository.sales;

import Entities.sales_register.Product;
import Entities.sales_register.Sale;
import Persistences.SalesRegisterDB;
import Persistences.repository.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SaleRepository implements Repository<Sale,Long> {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private final ClientRepository clientRepository;

    SaleRepository(){
        connection = SalesRegisterDB.getConnection();
        clientRepository = new ClientRepository();
    }

    @Override
    public void save(Sale sale) {
        try {
            preparedStatement = connection.prepareStatement("insert into register_sales values(?,?,?,?)");

            preparedStatement.setLong(1,sale.getIdSeller().getIdSeller());
            preparedStatement.setLong(2,sale.getIdClient().getIdClient());
            preparedStatement.setDate(3, Date.valueOf(sale.getDate().toLocalDate()));
            preparedStatement.setFloat(4,sale.getTotal());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Sale sale) {
        throw new RuntimeException("Method not allowed");
    }

    @Override
    public void delete(Long aLong) {
        throw new RuntimeException("Method not allowed");
    }

    @Override
    public Sale findById(Long aLong) {
        Sale sale;

        try {
            preparedStatement = connection.prepareStatement("select * from register_sales where id_sale = ?");

            preparedStatement.setLong(1,aLong);

            sale = createSale(preparedStatement.executeQuery());

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return sale;
    }

    @Override
    public List<Sale> findAll() {

        List<Sale> sales = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement("select * from products");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                sales.add(createSale(resultSet));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return sales;
    }

    private Sale createSale(ResultSet resultSet){

        Sale sale = new Sale();

        try {

            sale.setDate(resultSet.getDate("date"));
            sale.setIdSale(resultSet.getInt("id_sale"));
            sale.setIdClient(clientRepository.findById(resultSet.getLong("id_client")));
            sale.setTotal(resultSet.getFloat("total"));
            sale.setIdSeller();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return product;
    }
}
