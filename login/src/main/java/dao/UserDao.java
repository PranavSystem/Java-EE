package dao;

import java.sql.SQLException;

import pojo.User;

public interface UserDao {
	User authenticateUser(String email,String password) throws SQLException;
}
