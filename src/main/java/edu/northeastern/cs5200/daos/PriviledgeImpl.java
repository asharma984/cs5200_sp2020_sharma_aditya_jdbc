package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import edu.northeastern.cs5200.Connection;

public class PriviledgeImpl implements PriviledgeDao{
	java.sql.Connection con;
	PreparedStatement pstmt;
	Statement statement;
	
	
	public PriviledgeImpl() {
		
		try {
			con=Connection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void assignWebsitePrivilege(int developerId, int websiteId, String priviledge) {
		String websitePriviledge="insert into `website_privilege`(`priviledge`,`developer`,`website`)"
				+ " values(?, ?, ?)";
		try {

			pstmt = con.prepareStatement(websitePriviledge);
			pstmt.setString(1, priviledge);	
			pstmt.setInt(2, developerId);
			pstmt.setInt(3, websiteId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void assignPagePriviledge(int developerId, int pageId, String priviledge) {
		String pagePriviledge="insert into `page_priviledge`(`priviledge`,`developer`,`page`)"
				+ " values(?, ?, ?)";
		try {

			pstmt = con.prepareStatement(pagePriviledge);
			pstmt.setString(1, priviledge);	
			pstmt.setInt(2, developerId);
			pstmt.setInt(3, pageId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteWebsitePriviledge(int developerId, int websiteId, String priviledge) {
		String websitePriviledge="delete from `website_priviledge` where priviledge=? AND "
				+ "developer=? AND website=?";
		try {

			pstmt = con.prepareStatement(websitePriviledge);
			pstmt.setString(1, priviledge);	
			pstmt.setInt(2, developerId);
			pstmt.setInt(3, websiteId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deletePagePriviledge(int developerId, int pageId, String priviledge) {
		String pagePriviledge="delete from `page_priviledge` where priviledge=? AND developer=? AND page=?";
		
		try {

			pstmt = con.prepareStatement(pagePriviledge);
			pstmt.setString(1, priviledge);	
			pstmt.setInt(2, developerId);
			pstmt.setInt(3, pageId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
