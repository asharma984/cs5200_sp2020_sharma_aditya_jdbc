package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Role;

public class RoleImpl implements RoleDao {
	java.sql.Connection con;
	PreparedStatement pstmt;
	Statement statement;
	Map<Integer,String> roleMap;
	
	public RoleImpl() {
		roleMap=new HashMap<>();
		roleMap.put(1,"owner");
		roleMap.put(2,"admin");
		roleMap.put(3,"writer");
		roleMap.put(4,"editor");
		roleMap.put(5,"reviewer");
		try {
			con=Connection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void assignWebsiteRole(int developerId, int websiteId, int roleId) {
		String websiteRole="insert into `website_role`(role,developer,website)"
				+ " values(?, ?, ?)";
		try {

			pstmt = con.prepareStatement(websiteRole);
			pstmt.setString(1, roleMap.get(roleId));	
			pstmt.setInt(2, developerId);
			pstmt.setInt(3, websiteId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void assignPageRole(int developerId, int pageId, int roleId) {
		String pageRole="insert into `page_role`(role,developer,page)"
				+ " values(?, ?, ?)";
		try {

			pstmt = con.prepareStatement(pageRole);
			pstmt.setString(1, roleMap.get(roleId));	
			pstmt.setInt(2, developerId);
			pstmt.setInt(3, pageId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteWebsiteRole(int developerId, int websiteId, int roleId) {
		String websiteRole="delete from `website_role` where role=? AND developer=? AND website=?";
		try {

			pstmt = con.prepareStatement(websiteRole);
			pstmt.setString(1, roleMap.get(roleId));	
			pstmt.setInt(2, developerId);
			pstmt.setInt(3, websiteId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deletePageRole(int developerId, int pageId, int roleId) {
		String pageRole="delete from `page_role` where role=? AND developer=? AND page=?";
				
		try {

			pstmt = con.prepareStatement(pageRole);
			pstmt.setString(1, roleMap.get(roleId));	
			pstmt.setInt(2, developerId);
			pstmt.setInt(3, pageId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
