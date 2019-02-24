package PPT.dao;

import PPT.models.User;
import PPT.utils.PropertiesReader;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao{
    private final SessionFactory sessionFactory;

    public UserDaoHibernateImpl() {
        Configuration configuration = DBHelper.getInstance().getConfiguration();
        sessionFactory = createSessionFactory(configuration);
    }


    public SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    @Override
    public User getUser (long id) {
        try (Session session = sessionFactory.openSession()) {
            return (User) session.get(User.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User getUser(String login) {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from User where login = :login");
            query.setParameter("login", login);
            User user = (User) query.uniqueResult();
            return user;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> getAllUsers () {
        try (Session session = sessionFactory.openSession()) {
            List<User> usersList = session.createQuery("from User", User.class).list();
            return usersList;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addUser (User user) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    @Override
    public void updateUser (User user) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    @Override
    public void deleteUser (long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("delete from User where id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
        }

    }
}
