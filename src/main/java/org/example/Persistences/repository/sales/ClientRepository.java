package org.example.Persistences.repository.sales;

import org.example.Entities.sales_register.Client;
import org.example.Persistences.connection.SalesRegisterDB;
import org.example.Persistences.repository.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository implements Repository<Client,Long> {

    private final Connection connection;
    private PreparedStatement preparedStatement;

    public ClientRepository(){
        connection = SalesRegisterDB.getConnection();
    }

    @Override
    public void save(Client client) {

        try {
            preparedStatement = connection.prepareStatement("insert into clients values(?,?,?)");

            preparedStatement.setString(1,client.getDniClient());
            preparedStatement.setString(2,client.getNameClient());
            preparedStatement.setString(3,client.getLnClient());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Client client) {
        try {
            preparedStatement = connection.prepareStatement("update clients set name_client = ?,ln_client = ? where id_client = ?");

            preparedStatement.setString(1, client.getNameClient());
            preparedStatement.setString(2, client.getLnClient());
            preparedStatement.setLong(3,client.getIdClient());

            preparedStatement.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long aLong) {
        try {
            preparedStatement = connection.prepareStatement("delete from clients where id_client = ?");

            preparedStatement.setLong(1,aLong);
            preparedStatement.execute();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Client findById(Long aLong) {

        Client client;

        try {
            preparedStatement = connection.prepareStatement("select * from clients where id_client = ?");

            preparedStatement.setLong(1,aLong);

            client = createClient(preparedStatement.executeQuery());

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return client;
    }

    @Override
    public List<Client> findAll() {

        List<Client> clients = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement("select * from clients");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                clients.add(createClient(resultSet));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return clients;
    }

    public Client findByDNI(String dni){
        Client client;

        try {
            preparedStatement = connection.prepareStatement("select * from clients where dni_client = ?");

            preparedStatement.setString(1,dni);

            client = createClient(preparedStatement.executeQuery());

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return client;
    }

    private Client createClient(ResultSet resultSet){
         Client client = new Client();

        try {

            client.setIdClient(resultSet.getLong("id_client"));
            client.setNameClient(resultSet.getString("name_client"));
            client.setLnClient(resultSet.getString("ln_client"));
            client.setDniClient(resultSet.getString("dni_client"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return client;
    }
}
