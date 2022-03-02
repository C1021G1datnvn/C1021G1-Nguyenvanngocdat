package repository.customer.impl;

import model.customer.Customer;
import repository.DBConnection;
import repository.customer.CustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerImpl implements CustomerRepository {
    DBConnection dbConnection = new DBConnection();

    @Override
    public List<Customer> findAll() {
        Connection connection = dbConnection.getConnection();
        List<Customer> customerList = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement("select * from customer join customer_type on customer.customer_type_id = customer_type.customer_type_id;");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int customer_id = resultSet.getInt("customer_id");
                    String customer_name = resultSet.getString("customer_name");
                    String customer_birthday = resultSet.getString("customer_birthday");
                    Boolean customer_gender = resultSet.getBoolean("customer_gender");
                    String customer_id_card = resultSet.getString("customer_id_card");
                    String customer_phone = resultSet.getString("customer_phone");
                    String customer_email = resultSet.getString("customer_email");
                    String customer_address = resultSet.getString("customer_address");
                    int customer_type_id = resultSet.getInt("customer_type_id");
                    String customer_type_name = resultSet.getString("customer_type_name");
                    Customer customer = new Customer(customer_id, customer_name, customer_birthday, customer_gender, customer_id_card,customer_phone, customer_email,customer_address,customer_type_id,customer_type_name);
                    customerList.add(customer);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return customerList;
    }

    @Override
    public void create(Customer customer) {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into customer(customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address,customer_type_id) values (?,?,?,?,?,?,?,?);");
            if (connection != null) {
                preparedStatement.setString(1, customer.getCustomer_name());
                preparedStatement.setString(2, customer.getCustomer_birthday());
                preparedStatement.setBoolean(3, customer.getCustomer_gender());
                preparedStatement.setString(4, customer.getCustomer_id_card());
                preparedStatement.setString(5, customer.getCustomer_phone());
                preparedStatement.setString(6, customer.getCustomer_email());
                preparedStatement.setString(7, customer.getCustomer_address());
                preparedStatement.setInt(8, customer.getCustomer_type_id());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int customer_id) {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from customer where customer_id = ?");
            if (connection != null) {
                preparedStatement.setInt(1, customer_id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Customer customer) {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE customer set customer_name = ?,customer_birthday= ?,customer_gender=?,customer_id_card=?" +
                    ",customer_phone=?,customer_email= ?, customer_address =?,customer_type_id=? where customer_id = ?;");
            preparedStatement.setString(1, customer.getCustomer_name());
            preparedStatement.setString(2, customer.getCustomer_birthday());
            preparedStatement.setBoolean(3, customer.getCustomer_gender());
            preparedStatement.setString(4, customer.getCustomer_id_card());
            preparedStatement.setString(5, customer.getCustomer_phone());
            preparedStatement.setString(6, customer.getCustomer_email());
            preparedStatement.setString(7, customer.getCustomer_address());
            preparedStatement.setInt(8, customer.getCustomer_type_id());
            preparedStatement.setInt(9, customer.getCustomer_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer selectCustomer(int customer_id) {
        Customer customer = null;
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email, customer_address,customer_type_id from customer where customer_id = ?;");
            preparedStatement.setInt(1, customer_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String customer_name = resultSet.getString("customer_name");
                String customer_birthday = resultSet.getString("customer_birthday");
                boolean customer_gender = Boolean.parseBoolean(resultSet.getString("customer_gender"));
                String customer_id_card = resultSet.getString("customer_id_card");
                String customer_phone = resultSet.getString("customer_phone");
                String customer_email = resultSet.getString("customer_email");
                String customer_address = resultSet.getString("customer_address");
                int customer_type_id = Integer.parseInt(resultSet.getString("customer_type_id"));
                customer = new Customer(customer_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone
                , customer_email, customer_address, customer_type_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<Customer> search(String customer_name) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from customer join customer_type on customer_type.customer_type_id = customer.customer_type_id  where customer_name like ?;");
            preparedStatement.setString(1,"%"+customer_name+"%");
            resultSet = preparedStatement.executeQuery();
            Customer customer = null;
            while (resultSet.next()) {
                customer = new Customer();
                customer.setCustomer_id(resultSet.getInt("customer_id"));
                customer.setCustomer_name(resultSet.getString("customer_name"));
                customer.setCustomer_birthday(resultSet.getString("customer_birthday"));
                customer.setCustomer_gender(Boolean.valueOf(resultSet.getString("customer_gender")));
                customer.setCustomer_id_card(resultSet.getString("customer_id_card"));
                customer.setCustomer_phone(resultSet.getString("customer_phone"));
                customer.setCustomer_email(resultSet.getString("customer_email"));
                customer.setCustomer_address(resultSet.getString("customer_address"));
                customer.setCustomer_type_id(resultSet.getInt("customer_type_id"));
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }
}
