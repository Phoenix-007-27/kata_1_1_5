package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {


    private UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();

    public void createUsersTable() throws SQLException {

        userDaoHibernate.createUsersTable();
    }

    public void dropUsersTable() throws SQLException {

        userDaoHibernate.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {

        userDaoHibernate.saveUser(name, lastName, age);

    }

    public void removeUserById(long id) throws SQLException {


        userDaoHibernate.removeUserById(id);

    }

    public List<User> getAllUsers() throws SQLException {

        return userDaoHibernate.getAllUsers();
    }

    public void cleanUsersTable() throws SQLException {

        userDaoHibernate.cleanUsersTable();
    }
}
