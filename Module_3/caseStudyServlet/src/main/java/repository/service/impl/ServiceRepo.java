package repository.service.impl;

import model.service.Service;
import repository.DBConnection;
import repository.service.IService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepo implements IService {
    DBConnection dbConnection = new DBConnection();
    @Override
    public List<Service> selectAllService() {
        Connection connection = dbConnection.getConnection();
        List<Service> serviceList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select  * from service join rent_type on service.rent_type_id = rent_type.rent_type_id join service_type on service.service_type_id = service_type.service_type_id;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int service_id = resultSet.getInt("service_id");
                String service_name = resultSet.getString("service_name");
                int service_area = resultSet.getInt("service_area");
                double service_cost = resultSet.getDouble("service_cost");
                int service_max_people = resultSet.getInt("service_max_people");
                String standard_room = resultSet.getString("standard_room");
                String description_other_convenience = resultSet.getString("description_other_convenience");
                double pool_area = resultSet.getDouble("pool_area");
                int number_of_floors = resultSet.getInt("number_of_floors");
                int rent_type_id = resultSet.getInt("rent_type_id");
                int service_type_id = resultSet.getInt("service_type_id");
                String rent_type_name = resultSet.getString("rent_type_name");
                String service_type_name = resultSet.getString("service_type_name");
                Service service = new Service(service_id, service_name, service_area, service_cost, service_max_people, standard_room,
                        description_other_convenience, pool_area, number_of_floors, rent_type_id, service_type_id, rent_type_name, service_type_name);
                serviceList.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceList;
    }

    @Override
    public void create(Service service) {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into service(service_name, service_area, service_cost, service_max_people, " +
                    "standard_room, description_other_convenience, pool_area, number_of_floors, rent_type_id, service_type_id) values (?,?,?,?,?,?,?,?,?,?);");
            preparedStatement.setString(1, service.getService_name());
            preparedStatement.setInt(2, service.getService_area());
            preparedStatement.setDouble(3, service.getService_cost());
            preparedStatement.setInt(4, service.getService_max_people());
            preparedStatement.setString(5, service.getStandard_room());
            preparedStatement.setString(6, service.getDescription_other_convenience());
            preparedStatement.setDouble(7, service.getPool_area());
            preparedStatement.setInt(8, service.getNumber_of_floors());
            preparedStatement.setInt(9, service.getRent_type_id());
            preparedStatement.setInt(10, service.getService_type_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
