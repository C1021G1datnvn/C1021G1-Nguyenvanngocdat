package repository.employee.impl;

import model.employee.Division;
import model.employee.EducationDegree;
import repository.DBConnection;
import repository.employee.IEducationDegree;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepo implements IEducationDegree {
    DBConnection dbConnection = new DBConnection();
    @Override
    public List<EducationDegree> selectAll() {
        Connection connection = dbConnection.getConnection();
        List<EducationDegree> educationDegrees = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from education_degree");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int education_degree_id = resultSet.getInt("education_degree_id");
                String education_degree_name = resultSet.getString("education_degree_name");
                EducationDegree educationDegree = new EducationDegree(education_degree_id, education_degree_name);
                educationDegrees.add(educationDegree);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return educationDegrees;
    }
}
