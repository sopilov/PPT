package PPT.services;

import PPT.dao.UserDao;
import PPT.dao.UserDaoImpl;
import PPT.models.User;

import java.util.List;

public class UserService {
    private static final UserDao userDao = new UserDaoImpl();
    private static final UserService instance = new UserService();


    public static UserService getInstance () {
        return instance;
    }

    public User getUser (long id) {
        return userDao.getUser(id);
    }

    public List<User> getAllUsers () {
        return userDao.getAllUsers();
    }

    public void addUser (User user) {
        userDao.addUser(user);
    }

    public void updateUser (User user) {
        userDao.updateUser(user);
    }

    public void deleteUser (long id) {
        userDao.deleteUser(id);
    }
}
