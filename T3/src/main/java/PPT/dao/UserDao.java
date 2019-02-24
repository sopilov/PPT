package PPT.dao;

import PPT.models.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public interface UserDao {

    User getUser (long id);

    User getUser (String login);

    List<User> getAllUsers ();

    void addUser (User user);

    void updateUser (User user);

    void deleteUser (long id);
}
