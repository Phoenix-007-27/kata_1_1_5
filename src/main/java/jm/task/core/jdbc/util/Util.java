package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/kata", "root", "11111111");
    }
    public static Session HiberCon(){
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }
}
