package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserServiceImpl;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {

        UserServiceImpl userService = new UserServiceImpl();
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.cleanUsersTable();
        userService.saveUser("Tim", "Sol", (byte) 25);
        userService.saveUser("Tom", "Soyer", (byte) 26);
        userService.saveUser("Jim", "Carry", (byte) 27);
        userService.saveUser("Sara", "Boyl", (byte) 28);
        userService.removeUserById(2);


    }
}
