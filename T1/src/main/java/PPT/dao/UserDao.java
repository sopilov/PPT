package PPT.dao;

import PPT.models.User;

import java.sql.Connection;
import java.util.List;

public interface UserDao {

    Connection getConnection ();

    User getUser (long id);

    List<User> getAllUsers ();

    void addUser (User user);

    void updateUser (User user);

    void deleteUser (long id);
}
