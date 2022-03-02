package repository.employee;

import model.employee.User;

import java.util.List;

public interface IUser {
    List<User> selectAll();
}
