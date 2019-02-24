package PPT.utils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class PropertiesReader {

    private static Properties properties_dao_type = getPropertiesDAOType();
    private static Properties properties_hibernate = getPropertiesHibernate();
    private static Properties properties_jdbc = getPropertiesJDBC();

    private static Properties getPropertiesDAOType () {
        Properties properties = new Properties();
        try (InputStream input = Class.forName("PPT.utils.PropertiesReader").getResourceAsStream("/config_dao_type.properties")) {
            properties.load(input);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    private static Properties getPropertiesHibernate () {
        Properties properties = new Properties();
        try (InputStream input = Class.forName("PPT.utils.PropertiesReader").getResourceAsStream("/config_hibernate.properties")) {
            properties.load(input);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    private static Properties getPropertiesJDBC () {
        Properties properties = new Properties();
        try (InputStream input = Class.forName("PPT.utils.PropertiesReader").getResourceAsStream("/config_jdbc.properties")) {
            properties.load(input);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String getDAOType () {
        return properties_dao_type.getProperty("type");
    }

    public static String getPropertyHibernate (String key) {
        return properties_hibernate.getProperty(key);
    }

    public static String getPropertyHibernate (String key, String defaultValue) {
        return properties_hibernate.getProperty(key, defaultValue);
    }

    public static Set<String> getPropertyNamesHibernate () {
        return properties_hibernate.stringPropertyNames();
    }

    public static String getPropertyJDBC (String key) {
        return properties_jdbc.getProperty(key);
    }

    public static String getPropertyJDBC (String key, String defaultValue) {
        return properties_jdbc.getProperty(key, defaultValue);
    }
}
