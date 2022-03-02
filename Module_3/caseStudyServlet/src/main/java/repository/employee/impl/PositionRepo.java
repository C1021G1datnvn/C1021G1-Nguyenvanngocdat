package repository.employee.impl;

import model.employee.Posision;
import repository.DBConnection;
import repository.employee.IPosision;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepo implements IPosision {
    DBConnection dbConnection = new DBConnection();
    @Override
    public List<Posision> selectAll() {
        Connection connection = dbConnection.getConnection();
        List<Posision> posisionList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from posision");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int position_id = resultSet.getInt("position_id");
                String position_name = resultSet.getString("position_name");
                Posision posision = new Posision(position_id, position_name);
                posisionList.add(posision);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posisionList;
    }
}
