package repository.service.impl;

import model.service.ServiceType;
import repository.DBConnection;
import repository.service.IServiceType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRepo implements IServiceType {
    DBConnection dbConnection = new DBConnection();

    @Override
    public List<ServiceType> selectAllService() {
        Connection connection = dbConnection.getConnection();
        List<ServiceType> serviceTypeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from service_type");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int service_type_id = resultSet.getInt("service_type_id");
                String service_type_name = resultSet.getString("service_type_name");
                ServiceType serviceType = new ServiceType(service_type_id, service_type_name);
                serviceTypeList.add(serviceType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceTypeList;
    }
}
