package dao;

import java.sql.Connection;
import static utils.DBUtils.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.User;

public class UserDaoImpl implements UserDao {
	//fields
	private Connection cn;
	private PreparedStatement pst1;
	
	public UserDaoImpl() throws SQLException{
		//open connection
		cn=openConnection();
		pst1=cn.prepareStatement("select * from users where email=? and password=?");
		System.out.println("Dao User created");
	}

	@Override
	public User authenticateUser(String email, String password) throws SQLException {
		//set in params
		pst1.setString(1, email);
		pst1.setString(2, password);
		try(ResultSet rst1=pst1.executeQuery()) {
			if(rst1!=null) {	
//int id, String firstName, String lastName, String email, String password, Date dob, boolean votingStatus, String role
				return new User(rst1.getInt(1),rst1.getString(2),rst1.getString(3),email,password,
						rst1.getDate(6),rst1.getBoolean(7),rst1.getString(8));
			}
			return null;
		}
		
	}
	
	public void cleanUp() throws SQLException {
		if(pst1!=null)
			pst1.close();
		closeConnection();
		System.out.println("User dao cleaned up");
	}

}
