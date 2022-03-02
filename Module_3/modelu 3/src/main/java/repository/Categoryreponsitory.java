package repository;

import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Categoryreponsitory implements CategoryInterface{
    private static final String SELECT_ALL_CATEGORY = "SELECT * FROM category;";

    CreateReponssitory createReponssitory = new CreateReponssitory();
    @Override
    public List<Category> selectAll() {
        Connection connection = createReponssitory.getConnection();
        List<Category> categoryList = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int category_id = resultSet.getInt("category_id");
                    String category_name = resultSet.getString("category_name");
                    categoryList.add(new Category(category_id,category_name));
                }

            } catch ( SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return categoryList;
    }
}
