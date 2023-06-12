package dao;
import static utils.DBUtils.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojos.User;

public class UserDaoImpl implements UserDao{
	private Connection cn;
	private PreparedStatement pst1,pst2;

	public UserDaoImpl(String url,String userName,String pass) throws SQLException {
		//open connection
		cn=openConnection(url,userName,pass);
		pst1=cn.prepareStatement("Select * from users where email=? and password=?");
		pst2=cn.prepareStatement("Update users set status=1 where id=?");
		System.out.println("User dao created");
	}
	
	@Override
	public User authenticateUser(String email, String password) throws SQLException {
		pst1.setString(1, email);
		pst1.setString(2, password);
		try(ResultSet rst1=pst1.executeQuery()) {
			if(rst1.next()) { //=>success
//int id,String firstName,String lastName,String email,String password,Date dob,boolean votingStatus,String role
			return new User(rst1.getInt(1),rst1.getString(2),rst1.getString(3),email,password,rst1.getDate(6)
						,rst1.getBoolean(7),rst1.getString(8));
			}
		}	
		return null;
	}
	
	@Override
	public String updateVotingStatus(int voterId) throws SQLException {
		//set in param
		pst2.setInt(1,voterId);
		//exec query
		int updatecount=pst2.executeUpdate();
		if(updatecount==1)
			return "Updated voting status";
		return "Updating voting status failed";
	}
	
	//clean up
	public void cleanUp() throws SQLException {
		if(pst1!=null)
			pst1.close();
		if(pst2!=null)
			pst2.close();
		closeConnection();
		System.out.println("User Dao cleaned");
	}
}
