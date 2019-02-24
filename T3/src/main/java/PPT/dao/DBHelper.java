package PPT.dao;

import PPT.models.User;
import PPT.utils.PropertiesReader;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private static final DBHelper instance = new DBHelper();

    private DBHelper() {
    }

    public static DBHelper getInstance(){
        return instance;
    }

    public Connection getConnection() {
        try {
            String driver = PropertiesReader.getPropertyJDBC("Driver");
            Class.forName(driver);
            String url = PropertiesReader.getPropertyJDBC("URL");
            Connection connection = DriverManager.getConnection(url);
            return  connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        for (String propertyName : PropertiesReader.getPropertyNamesHibernate()) {
            configuration.setProperty(propertyName, PropertiesReader.getPropertyHibernate(propertyName));
        }
        return configuration;
    }
}
