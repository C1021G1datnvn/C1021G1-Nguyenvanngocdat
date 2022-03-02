package repository.service.impl;

import model.service.RentType;
import repository.DBConnection;
import repository.service.IRentType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepo implements IRentType {
    DBConnection dbConnection = new DBConnection();
    List<model.service.RentType> rentTypeList = new ArrayList<>();
    @Override
    public List<model.service.RentType> selectAllService() {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from rent_type;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int rent_type_id = resultSet.getInt("rent_type_id");
                String rent_type_name = resultSet.getString("rent_type_name");
                Double rent_type_cost = resultSet.getDouble("rent_type_cost");
                model.service.RentType rentType = new model.service.RentType(rent_type_id, rent_type_name, rent_type_cost);
                rentTypeList.add(rentType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentTypeList;
    }
}
