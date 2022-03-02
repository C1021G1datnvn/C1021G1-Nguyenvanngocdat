package repository.customer.impl;

import model.customer.CustomerType;
import repository.DBConnection;
import repository.customer.CustomerTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeImpl implements CustomerTypeRepository {
    DBConnection dbConnection = new DBConnection();
    @Override
    public List<CustomerType> findAll() {
        Connection connection = dbConnection.getConnection();
        List<CustomerType> customerTypeList = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement("select * from customer_type");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int customer_type_id = resultSet.getInt("customer_type_id");
                    String customer_type_name = resultSet.getString("customer_type_name");
                    CustomerType customerType = new CustomerType(customer_type_id, customer_type_name);
                    customerTypeList.add(customerType);
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
        return customerTypeList;
    }
}
