package service;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUser {
    List<User> listUserAll() throws SQLException;
    void addUser(User user);
    void delete(int id);
    void update(User user);
    User selectId(int id);
    List<User> search(String country);
}
