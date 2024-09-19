package Persistences.repository.sales;

import Entities.sales_register.Client;
import Entities.sales_register.Product;
import Persistences.CoursesRegistrationDB;
import Persistences.SalesRegisterDB;
import Persistences.repository.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements Repository<Product,Long> {

    private final Connection connection;
    private PreparedStatement preparedStatement;

    ProductRepository(){
        connection = SalesRegisterDB.getConnection();
    }

    @Override
    public void save(Product product) {
        try {
            preparedStatement = connection.prepareStatement("insert into products values(?,?)");

            preparedStatement.setString(1,product.getProduct());
            preparedStatement.setFloat(2,product.getPrice());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Product product) {
        try {
            preparedStatement = connection.prepareStatement("update clients set product= ?,price = ? where id_product = ?");

            preparedStatement.setString(1, product.getProduct());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setLong(3,product.getIdProduct());

            preparedStatement.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long aLong) {
        try {
            preparedStatement = connection.prepareStatement("delete from products where id_product = ?");

            preparedStatement.setLong(1,aLong);
            preparedStatement.execute();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product findById(Long aLong) {
        Product product;

        try {
            preparedStatement = connection.prepareStatement("select * from products where id_product = ?");

            preparedStatement.setLong(1,aLong);

            product = createProduct(preparedStatement.executeQuery());

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return product;
    }

    @Override
    public List<Product> findAll() {

        List<Product> products = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement("select * from products");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                products.add(createProduct(resultSet));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

    private Product createProduct(ResultSet resultSet){

        Product product = new Product();

        try {

            product.setPrice(resultSet.getFloat("price"));
            product.setIdProduct(resultSet.getLong("id_product"));
            product.setProduct(resultSet.getString("product"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return product;
    }
}
