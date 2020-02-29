package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.User;

public class UserImpl implements UserDao{
	java.sql.Connection con;
	PreparedStatement pstmt;
	Statement statement;
	public UserImpl()
	{
		try {
			con=Connection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createUser(User user) {
		String personInsert="insert into `person`(id,first_name,last_name,user_name,password,email,dob)"
				+ " values(?, ?, ?, ?, ?, ?, ?)";
		String userInsert = "insert into `user`(`id`,`user_agreement`) values(?, ?)";
		String phoneInsert = "insert into `phone`(`phone`,`primary`,`person`) values(?, ?,?)";
		String addressInsert="insert into `address`(`street1`,`street2`,`city`,`state`,`zip`,`primary`,`person`) "
				+ "values(?, ?, ?, ?, ?, ?, ?)";
			
		try {
			pstmt = con.prepareStatement(personInsert);
			pstmt.setInt(1, user.getId());	
			pstmt.setString(2, user.getFirstName());
			pstmt.setString(3, user.getLastName());
			pstmt.setString(4, user.getUserName());
			pstmt.setString(5, user.getPassword());
			pstmt.setString(6, user.getEmail());
			pstmt.setDate(7, user.getDob());
			pstmt.executeUpdate();
			
			pstmt = con.prepareStatement(userInsert);
			pstmt.setInt(1, user.getId());	
			pstmt.setBoolean(2, user.isUserAgreement());
			pstmt.executeUpdate();
			
			
			
			pstmt = con.prepareStatement(addressInsert);
			pstmt.setString(1, user.getAddress().getStreet1());	
			pstmt.setString(2,user.getAddress().getStreet2());
			pstmt.setString(3, user.getAddress().getCity());
			pstmt.setString(4, user.getAddress().getState());
			pstmt.setString(5, user.getAddress().getZip());
			pstmt.setBoolean(6, user.getAddress().isPrimary());
			pstmt.setInt(7, user.getId());
			pstmt.executeUpdate();
			
			pstmt = con.prepareStatement(phoneInsert);
			pstmt.setString(1, user.getPhone().getPhone());	
			pstmt.setBoolean(2, user.getPhone().isPrimary());
			pstmt.setInt(3, user.getId());	
			pstmt.executeUpdate();
//			con.close();
//			Connection.closeConnection();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
