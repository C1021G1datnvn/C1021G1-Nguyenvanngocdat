package repository;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Productreponssitory implements ProductInterface{
    CreateReponssitory createReponssitory = new CreateReponssitory();
    private static final String SELECT_ALL_Product = "SELECT * FROM product join category on product.category_id = category.category_id;";
    private static final String INSERT_PRODUCT = "INSERT INTO product(product_name,price,quantily,color,category_id) values (?,?,?,?,?);";
    private static final String DELETE_PRODUCT = "DELETE from product where product_id = ?";
    private static final String SELECT_ID_PRODUCT = "select * from product where product_id =?;";
    private static final String UPDATE_PRODUCT = "UPDATE product set product_name = ?,price= ?,quantily=?,color=?,category_id=? where product_id = ?;";

    @Override
    public List<Product> selectAll() {
        Connection connection = createReponssitory.getConnection();
        List<Product> productList = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_Product);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int product_id = resultSet.getInt("product_id");
                    String product_name = resultSet.getString("product_name");
                    Double price = resultSet.getDouble("price");
                    int quantily = resultSet.getInt("quantily");
                    String color = resultSet.getString("color");
                    int category_id = resultSet.getInt("category_id");
                    String category_name = resultSet.getString("category_name");
                    Product product = new Product(product_id, product_name, price, quantily, color, category_id, category_name);
                    productList.add(product);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return productList;
    }

    @Override
    public Product selectID(int id) {
        Product product = null;
        Connection connection = createReponssitory.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID_PRODUCT);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String nameProduct = resultSet.getString("product_name");
                double price = resultSet.getDouble("price");
                int quantily = resultSet.getInt("quantily");
                String color = resultSet.getString("color");
                int categoryId = resultSet.getInt("category_id");
                product = new Product(id, nameProduct, price, quantily, color, categoryId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public void create(Product product) {
        Connection connection = createReponssitory.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(INSERT_PRODUCT);
                preparedStatement.setString(1, product.getNameProduct());
                preparedStatement.setDouble(2, product.getPrice());
                preparedStatement.setInt(3, product.getQuantily());
                preparedStatement.setString(4, product.getColor());
                preparedStatement.setInt(5, product.getIdCategory());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public void remove(int id) {
        Connection connection = createReponssitory.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(DELETE_PRODUCT);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }


    @Override
    public void update(Product product) {
        Connection connection = createReponssitory.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);
            preparedStatement.setString(1, product.getNameProduct());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantily());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setInt(5, product.getIdCategory());
            preparedStatement.setInt(6, product.getIdProduct());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Product> searchName(String name) {
        List<Product> productList = new ArrayList<>();
        String query = "{Call search_name(?)}";

        CreateReponssitory createReponssitory = new CreateReponssitory();
        Connection connection = createReponssitory.getConnection();

        try {
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = callableStatement.executeQuery();
            Product product = new Product();
            while (resultSet.next()) {
                product.setIdProduct(resultSet.getInt("product_id"));
                product.setNameProduct(resultSet.getString("product_name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setQuantily(resultSet.getInt("quantily"));
                product.setColor(resultSet.getString("color"));
                product.setIdCategory(resultSet.getInt("category_id"));
                productList.add(product);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> searchColor(String color) {
        List<Product> productList = new ArrayList<>();
        String query = "{Call search_color(?)}";

        CreateReponssitory createReponssitory = new CreateReponssitory();
        Connection connection = createReponssitory.getConnection();

        try {
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, "%" + color + "%");
            ResultSet resultSet = callableStatement.executeQuery();
            Product product = new Product();
            while (resultSet.next()) {
                product.setIdProduct(resultSet.getInt("product_id"));
                product.setNameProduct(resultSet.getString("product_name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setQuantily(resultSet.getInt("quantily"));
                product.setColor(resultSet.getString("color"));
                product.setIdCategory(resultSet.getInt("category_id"));
                productList.add(product);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
