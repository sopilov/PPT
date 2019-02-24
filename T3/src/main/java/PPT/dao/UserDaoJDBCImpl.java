package PPT.dao;

import PPT.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final Connection connection;

    public UserDaoJDBCImpl() {
        this.connection = DBHelper.getInstance().getConnection();
    }

    @Override
    public User getUser (long id) {
        User user = null;
        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("select * from users where id = " + id);
            resultSet.next();
            user = new User(resultSet.getLong("id"), resultSet.getString("login"), resultSet.getString("password"), resultSet.getString("nickname"), resultSet.getString("role"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User getUser(String login) {
        User user = null;
        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("select * from users where login = '" + login + "'");
            resultSet.next();
            user = new User(resultSet.getLong("id"), resultSet.getString("login"), resultSet.getString("password"), resultSet.getString("nickname"), resultSet.getString("role"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAllUsers () {
        List<User> usersList = new ArrayList<>();

        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()) {
                usersList.add(new User(resultSet.getLong("id"), resultSet.getString("login"), resultSet.getString("password"), resultSet.getString("nickname"), resultSet.getString("role")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return usersList;
    }

    @Override
    public void addUser (User user) {
        try (Statement statement = connection.createStatement()){
            String sql = "insert into users (login, password, nickname, role) values ('" + user.getLogin() + "', '" + user.getPassword() + "', '" + user.getNickname()  + "', '" + user.getRole()+ "')";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser (User user) {
        try (Statement statement = connection.createStatement()){
            String sql = "update users set login = '" + user.getLogin() + "', password = '" + user.getPassword() + "', nickname = '" + user.getNickname()  + "', role = '" + user.getRole() + "' where id = " + user.getId();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser (long id) {
        try (Statement statement = connection.createStatement()){
            String sql = "delete from users where id = " + id;
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
