package service.employee.impl;

import model.employee.User;
import repository.employee.IUser;
import repository.employee.impl.UserRepoImpl;
import service.employee.IUserService;

import java.util.List;

public class UserImpl implements IUserService {
    UserRepoImpl userRepo = new UserRepoImpl();
    @Override
    public List<User> selectAll() {
        return userRepo.selectAll();
    }
}
