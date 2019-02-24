package PPT.dao;

import PPT.utils.PropertiesReader;

public class UserDaoFactory {

    private UserDaoFactory() {

    }

    public static UserDao getUserDao() {
        String type = PropertiesReader.getDAOType();
        UserDao userDao = null;
        if (type.equals("Hibernate")) {
            userDao = new UserDaoHibernateImpl();
        } else {
            if (type.equals("JDBC")) {
                userDao = new UserDaoJDBCImpl();
            }
        }
        return userDao;
    }
}
