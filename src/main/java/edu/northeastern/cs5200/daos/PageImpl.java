package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Page;
import edu.northeastern.cs5200.models.Website;

public class PageImpl implements PageDao {
	java.sql.Connection con;
	PreparedStatement pstmt;
	Statement statement;
	public PageImpl()
	{
		try {
			con=Connection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void createPageForWebsite(int websiteId, Page page) {
		String pageInsert="insert into `page`(`id`,`title`,`description`,`created`,`updated`,`views`,`website`)"
				+ " values(?, ?, ?, ?, ?, ?, ?)";
		try {

			pstmt = con.prepareStatement(pageInsert);
			pstmt.setInt(1, page.getId());	
			pstmt.setString(2, page.getTitle());
			pstmt.setString(3, page.getDescription());
			pstmt.setDate(4,page.getCreated());
			pstmt.setDate(5, page.getUpdated());
			pstmt.setInt(6, page.getViews());
			pstmt.setInt(7, websiteId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Page> findAllPages(){
		List<Page> pages=new ArrayList<>();
		try {
			statement = con.createStatement();
			String sql ="select * from page";
			ResultSet  result = statement.executeQuery(sql);
			while(result.next()) {
				
				Page page=new Page(result.getInt("id"),result.getString("title"),
						result.getString("description"),result.getDate("created"),result.getDate("updated"),
						result.getInt("views"));
			    pages.add(page);
			}
			result.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch bloc
			e.printStackTrace();
		}
		return pages;
	}
	public Page findPageById(int pageId) {
		 Page pageResult=new Page();
			try {
				
				String sql =	"select * from page where id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, pageId);
			ResultSet  result = pstmt.executeQuery();
				
				while(result.next()) {
					
					Page page=new Page(result.getInt("id"),result.getString("title"),
							result.getString("description"),result.getDate("created"),result.getDate("updated"),
							result.getInt("views"));
				   pageResult=page;
				}
				result.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch bloc
				e.printStackTrace();
			}
			return pageResult;
	}
	public List<Page> findPagesForWebsite(int websiteId){
		List<Page> pages=new ArrayList<>();
		try {
			String sql =	"select * from page where website=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, websiteId);
		ResultSet  result = pstmt.executeQuery();
			while(result.next()) {
				
				Page page=new Page(result.getInt("id"),result.getString("title"),
						result.getString("description"),result.getDate("created"),result.getDate("updated"),
						result.getInt("views"));
			    pages.add(page);
			}
			result.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch bloc
			e.printStackTrace();
		}
		return pages;
	}
	public int updatePage(int pageId, Page page) {
		int row=0;
        try {
			
			String updatePage ="update page SET id=?, title=?,description=?,"
					+ "created=?,updated=?,views=? where id =? ";
			pstmt = con.prepareStatement(updatePage);
			pstmt.setInt(1,page.getId());
			pstmt.setString(2,page.getTitle());
			pstmt.setString(3,page.getDescription());
			pstmt.setDate(4, (java.sql.Date)page.getCreated());
			pstmt.setDate(5, (java.sql.Date)page.getUpdated());
			pstmt.setInt(6,page.getViews());
			pstmt.setInt(7,pageId);
		   row=pstmt.executeUpdate();
        } catch (SQLException e) {
			// TODO Auto-generated catch bloc
			e.printStackTrace();
		}
        return row;
	}
	public int deletePage(int pageId) {
		int row=0;
		try {
			String deletePage="delete from page where id=?";
			pstmt=con.prepareStatement(deletePage);
			pstmt.setInt(1, pageId);
			row=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
}
