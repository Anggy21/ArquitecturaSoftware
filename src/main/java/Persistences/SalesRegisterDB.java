package Persistences;

import java.sql.Connection;

public class SalesRegisterDB {
    private Connection connection;

    public SalesRegisterDB(){
        ConnectionDB.setConnection("jdbc:mysql://localhost:3306/sales_register", "root", "root");
        connection = ConnectionDB.getConnection();
    }
}
