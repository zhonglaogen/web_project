package service.impl;

import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import service.ITestService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserSeriveIMpl implements ITestService {
    @Autowired
    private UserDao userDao ;

    @Override
    public int addUser(User user) throws SQLException, IOException, ClassNotFoundException {
        if (user == null) {
            return 0;
        }
        return userDao.addUser(user);
    }

    @Override
    public User findUserByID(int id) throws SQLException, IOException, ClassNotFoundException {

        return userDao.findUserByID(id);
    }

    @Override
    public List<User> findByUserAge(int age) throws SQLException, IOException, ClassNotFoundException {
        return userDao.findUserByAge(age);
    }
}
