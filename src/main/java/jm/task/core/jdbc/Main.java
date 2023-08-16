package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {


//        UserServiceImpl userService = new UserServiceImpl();
//        userService.createUsersTable();
//        userService.dropUsersTable();
//        userService.cleanUsersTable();
//        userService.saveUser("Tim", "Sol", (byte) 25);
//        userService.saveUser("Tom", "Soyer", (byte) 26);
//        userService.saveUser("Jim", "Carry", (byte) 27);
//        userService.saveUser("Sara", "Boyl", (byte) 28);
//        userService.removeUserById(2);
//        List<User> users = userService.getAllUsers();
//        System.out.println(users);

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml") // Укажите путь к вашему файлу конфигурации
                .buildSessionFactory();

        // Создание сессии
        try (Session session = sessionFactory.openSession()) {
            System.out.println("Подключение к базе данных успешно!");
        } catch (Exception e) {
            System.err.println("Ошибка подключения к базе данных: " + e.getMessage());
        } finally {
            // Закрытие фабрики сессий
            sessionFactory.close();
        }




    }
}
