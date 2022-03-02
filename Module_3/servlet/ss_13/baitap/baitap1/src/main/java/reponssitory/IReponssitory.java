package reponssitory;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IReponssitory {
    List<User> selectAll() throws SQLException;
    void insertUser(User user);
    User selectUser(int id);
    void delete(int id);
    void update(User user);
    List<User> search(String country);
}
