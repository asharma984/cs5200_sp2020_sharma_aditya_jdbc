package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Page;
import edu.northeastern.cs5200.models.Widget;

public class WidgetImpl implements WidgetDao{
	java.sql.Connection con;
	PreparedStatement pstmt;
	Statement statement;
	public WidgetImpl() {
		try {
			con=Connection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void createWidgetForPage(int pageId, Widget widget) {
		String widgetInsert="insert into `widget`(`id`,`name`,`width`,`height`,`css_class`,`css_style`,"
				+ "`text`,`order`,"
				+ "`url`,`shareble`,`expandable`,`size`,`src`,`html`,`d_type`,`page`)"
				+ " values(?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?,?,?)";
		try {

			pstmt = con.prepareStatement(widgetInsert);
			pstmt.setInt(1, widget.getId());	
			pstmt.setString(2, widget.getName());
			pstmt.setInt(3, widget.getWidth());
			pstmt.setInt(4, widget.getHeight());
			pstmt.setString(5, widget.getCssClass());
			pstmt.setString(6, widget.getCssStyle());
			pstmt.setString(7, widget.getText());
			pstmt.setInt(8, widget.getOrder());
			pstmt.setString(9, widget.getUrl());
			pstmt.setBoolean(10, widget.isShareble());
			pstmt.setBoolean(11, widget.isExpandable());
			pstmt.setInt(12, widget.getSize());
			pstmt.setString(13, widget.getSource());
			pstmt.setString(14, widget.getHtml());
			pstmt.setString(15, widget.getDtype());
			pstmt.setInt(16, pageId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Widget> findAllWidgets(){
		List<Widget> widgets=new ArrayList<>();
		try {
			statement = con.createStatement();
			String sql ="select * from widget";
			ResultSet  result = statement.executeQuery(sql);
			while(result.next()) {
				
				Widget widget=new Widget(result.getInt("id"),result.getString("name"),
						result.getInt("width"),result.getInt("height"),result.getString("css_class"),
						result.getString("css_style"),result.getString("text"),result.getInt("order"),
						result.getString("url"),result.getBoolean("shareble"),result.getBoolean("expandable"),
						result.getInt("size"),result.getString("src"),result.getString("html"),
						result.getString("d_type"));
			    widgets.add(widget);
			}
			result.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch bloc
			e.printStackTrace();
		}
		return widgets;
		
	}
	public Widget findWidgetById(int widgetId) {
		Widget widgetResult=new Widget();
		try {
			String sql =	"select * from widget where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, widgetId);
		ResultSet  result = pstmt.executeQuery();
			while(result.next()) {
				
				Widget widget=new Widget(result.getInt("id"),result.getString("name"),
						result.getInt("width"),result.getInt("height"),result.getString("css_class"),
						result.getString("css_style"),result.getString("text"),result.getInt("order"),
						result.getString("url"),result.getBoolean("shareble"),result.getBoolean("expandable"),
						result.getInt("size"),result.getString("src"),result.getString("html"),
						result.getString("d_type"));
			   widgetResult=widget;
			}
			result.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch bloc
			e.printStackTrace();
		}
		return widgetResult;
	}
	public List<Widget> findWidgetsForPage(int pageId){
		List<Widget> widgets=new ArrayList<>();
		try {
			String sql =	"select * from page where page=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pageId);
		ResultSet  result = pstmt.executeQuery();
			while(result.next()) {
				
				Widget widget=new Widget(result.getInt("id"),result.getString("name"),
						result.getInt("width"),result.getInt("height"),result.getString("css_class"),
						result.getString("css_style"),result.getString("text"),result.getInt("order"),
						result.getString("url"),result.getBoolean("shareble"),result.getBoolean("expandable"),
						result.getInt("size"),result.getString("src"),result.getString("html"),
						result.getString("d_type"));
			    widgets.add(widget);
			}
			result.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch bloc
			e.printStackTrace();
		}
		return widgets;
	}
	public int updateWidget(int widgetId, Widget widget) {
		int row=0;
		String widgetUpdate="update page SET id=?, name=?,width=?,height=?,css_class=?,css_style=?,"
				+ "text=?,order=?,url=?,shareble=?,expandable=?,size=?,src=?,html=?,d_type=? where id =? ";
        try {
			
			pstmt = con.prepareStatement(widgetUpdate);
			pstmt.setInt(1, widget.getId());	
			pstmt.setString(2, widget.getName());
			pstmt.setInt(3, widget.getWidth());
			pstmt.setInt(4, widget.getHeight());
			pstmt.setString(5, widget.getCssClass());
			pstmt.setString(6, widget.getCssStyle());
			pstmt.setString(7, widget.getText());
			pstmt.setInt(8, widget.getOrder());
			pstmt.setString(9, widget.getUrl());
			pstmt.setBoolean(10, widget.isShareble());
			pstmt.setBoolean(11, widget.isExpandable());
			pstmt.setInt(12, widget.getSize());
			pstmt.setString(13, widget.getSource());
			pstmt.setString(14, widget.getHtml());
			pstmt.setString(15, widget.getDtype());
			pstmt.setInt(16, widgetId);
			row=pstmt.executeUpdate();
        } catch (SQLException e) {
			// TODO Auto-generated catch bloc
			e.printStackTrace();
		}
        return row;
	}
	public int deleteWidget(int widgetId) {
		int row=0;
		try {
			String deleteWidget="delete from widget where id=?";
			pstmt=con.prepareStatement(deleteWidget);
			pstmt.setInt(1, widgetId);
			row=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
}
