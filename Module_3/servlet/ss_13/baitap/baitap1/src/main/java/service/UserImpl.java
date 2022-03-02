package service;

import model.User;
import reponssitory.ReponssitoryImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserImpl implements IUser{
  ReponssitoryImpl rpst = new ReponssitoryImpl();
    @Override
    public List<User> listUserAll() {
        List<User> listUserAll = null;
        try {
            listUserAll = this.rpst.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listUserAll;
    }

    @Override
    public void addUser(User user) {
        rpst.insertUser(user);
    }

    @Override
    public void delete(int id) {
        rpst.delete(id);
    }

    @Override
    public void update(User user) {
        rpst.update(user);
    }

    @Override
    public User selectId(int id) {
        User user = rpst.selectUser(id);
       return user;
    }

    @Override
    public List<User> search(String country) {
        List<User> userList = rpst.search(country);
        return userList;
    }


}
