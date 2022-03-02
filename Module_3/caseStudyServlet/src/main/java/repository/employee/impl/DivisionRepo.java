package repository.employee.impl;

import model.employee.Division;
import model.employee.User;
import repository.DBConnection;
import repository.employee.IDivision;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepo implements IDivision {
    DBConnection dbConnection = new DBConnection();
    @Override
    public List<Division> selectAll() {
        Connection connection = dbConnection.getConnection();
        List<Division> divisionList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from division");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int division_id = resultSet.getInt("division_id");
                String division_name = resultSet.getString("division_name");
                Division division = new Division(division_id, division_name);
                divisionList.add(division);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return divisionList;
    }
}
