package PPT.services;

import PPT.dao.UserDao;
import PPT.dao.UserDaoFactory;
import PPT.dao.UserDaoHibernateImpl;
import PPT.dao.UserDaoJDBCImpl;
import PPT.models.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static final UserDao userDao = UserDaoFactory.getUserDao();
    private static final UserServiceImpl instance = new UserServiceImpl();


    private  UserServiceImpl(){
    };

    public static UserServiceImpl getInstance () {
        return instance;
    }

    @Override
    public User getUser (long id) {
        return userDao.getUser(id);
    }

    @Override
    public User getUser(String login) {
        return userDao.getUser(login);
    }

    @Override
    public List<User> getAllUsers () {
        return userDao.getAllUsers();
    }

    @Override
    public void addUser (User user) {
        userDao.addUser(user);
    }

    @Override
    public void updateUser (User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser (long id) {
        userDao.deleteUser(id);
    }
}
