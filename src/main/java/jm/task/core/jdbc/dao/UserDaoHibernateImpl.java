package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    private SessionFactory sessionFactory = Util.HiberCon();



    @Override
    public void createUsersTable() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String sql = "CREATE TABLE IF NOT EXISTS Users (id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR (255) NOT NULL, " +
                    "lastname VARCHAR(255) NOT NULL, age TINYINT NOT NULL)";
            session.createSQLQuery(sql).executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            session.close();
        }

    }

    @Override
    public void dropUsersTable() {
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            String sql = "DROP TABLE IF EXISTS Users";
            session.createSQLQuery(sql).executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            session.close();
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.save(new User(name, lastName, age));
            session.getTransaction().commit();
            System.out.println("User с именем " + name + " добавлен в базу данных");
        } catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            session.close();
        }

    }

    @Override
    public void removeUserById(long id) {
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = null;
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            list = session.createQuery("from User", User.class).list();
            session.getTransaction().commit();
        } catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return list;
    }

    @Override
    public void cleanUsersTable() {
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            String sql = "DELETE from Users";
            session.createQuery("delete User").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            session.close();
        }

    }
}
