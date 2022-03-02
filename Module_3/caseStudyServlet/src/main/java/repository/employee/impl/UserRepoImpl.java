package repository.employee.impl;

import model.employee.User;
import repository.DBConnection;
import repository.employee.IUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepoImpl implements IUser {
    DBConnection dbConnection = new DBConnection();
    @Override
    public List<User> selectAll() {
        Connection connection = dbConnection.getConnection();
        List<User> listUser = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from `user`");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                User user = new User(username, password);
                listUser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listUser;
    }
}
