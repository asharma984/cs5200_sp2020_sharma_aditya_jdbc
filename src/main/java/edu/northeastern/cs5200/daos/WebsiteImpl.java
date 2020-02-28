package edu.northeastern.cs5200.daos;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Website;

public class WebsiteImpl implements WebsiteDao{
	java.sql.Connection con;
	PreparedStatement pstmt;
	Statement statement;
	public WebsiteImpl() {
		try {
			con=Connection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createWebsiteForDeveloper(int developerId, Website website) {
		String websiteInsert="insert into `website`(`id`,`name`,`description`,`created`,`updated`,`visits`"
				+ ",`developer`)"
				+ " values(?, ?, ?, ?, ?, ?, ?)";
		try {

			pstmt = con.prepareStatement(websiteInsert);
			pstmt.setInt(1, website.getId());	
			pstmt.setString(2, website.getName());
			pstmt.setString(3, website.getDescription());
			pstmt.setDate(4,(java.sql.Date) website.getCreated());
			pstmt.setDate(5, (java.sql.Date)website.getUpdated());
			pstmt.setInt(6, website.getVisits());
			pstmt.setInt(7, developerId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Website> findAllWebsites(){
		List<Website> websites=new ArrayList<>();
		try {
			statement = con.createStatement();
			String sql =	"select * from website";
			ResultSet  result = statement.executeQuery(sql);
			while(result.next()) {
				
				Website website=new Website(result.getInt("id"),result.getString("name"),
						result.getString("description"),result.getDate("created"),result.getDate("updated"),
						result.getInt("visits"));
			    websites.add(website);
			}
			result.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch bloc
			e.printStackTrace();
		}
		return websites;
		
	}
	public List<Website> findWebsitesForDeveloper(int developerId){
		List<Website> websites=new ArrayList<>();
		try {
			String sql =	"select * from website where developer=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, developerId);
		ResultSet  result = pstmt.executeQuery();
			while(result.next()) {
				
				Website website=new Website(result.getInt("id"),result.getString("name"),
						result.getString("description"),result.getDate("created"),result.getDate("updated"),
						result.getInt("visits"));
			    websites.add(website);
			}
			result.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch bloc
			e.printStackTrace();
		}
		return websites;
	}
	public Website findWebsiteById(int websiteId) {
		 Website websiteResult=new Website();
		try {
			String sql =	"select * from website where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, websiteId);
		ResultSet  result = pstmt.executeQuery();
			while(result.next()) {
				
				Website website=new Website(result.getInt("id"),result.getString("name"),
						result.getString("description"),result.getDate("created"),result.getDate("updated"),
						result.getInt("visits"));
			   websiteResult=website;
			}
			result.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch bloc
			e.printStackTrace();
		}
		return websiteResult;
	}
	public int updateWebsite(int websiteId, Website website) {
		int row=0;
         try {
			
			String updateWebsite ="update website SET id=?, name=?,description=?,"
					+ "created=?,updated=?,visits=? where id =? ";
			pstmt = con.prepareStatement(updateWebsite);
			pstmt.setInt(1,website.getId());
			pstmt.setString(2,website.getName());
			pstmt.setString(3,website.getDescription());
			pstmt.setDate(4, (java.sql.Date)website.getCreated());
			pstmt.setDate(5, (java.sql.Date)website.getUpdated());
			pstmt.setInt(6,website.getVisits());
			pstmt.setInt(7,websiteId);
		   row=pstmt.executeUpdate();
         } catch (SQLException e) {
 			// TODO Auto-generated catch bloc
 			e.printStackTrace();
 		}
         return row;
	}
	public int deleteWebsite(int websiteId) {
		int row=0;
		try {
			String deleteWebsite="delete from website where id=?";
			pstmt=con.prepareStatement(deleteWebsite);
			pstmt.setInt(1, websiteId);
			row=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
}
