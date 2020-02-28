package edu.northeastern.cs5200.daos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Address;
import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.Phone;

public class DeveloperImpl implements DeveloperDao {
	java.sql.Connection con;
	PreparedStatement pstmt;
	Statement statement;
	public DeveloperImpl()
	{
		try {
			con=Connection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createDeveloper(Developer developer) {
		String personInsert="insert into `person`(id,first_name,last_name,user_name,password,email,dob)"
				+ " values(?, ?, ?, ?, ?, ?, ?)";
		String developerInsert = "insert into `developer`(`id`,`developer_key`) values(?, ?)";
		String phoneInsert = "insert into `phone`(`phone`,`primary`,`person`) values(?, ?,?)";
		String addressInsert="insert into `address`(`street1`,`street2`,`city`,`state`,`zip`,`primary`,`person`) "
				+ "values(?, ?, ?, ?, ?, ?, ?)";
			
		try {
			pstmt = con.prepareStatement(personInsert);
			pstmt.setInt(1, developer.getId());	
			pstmt.setString(2, developer.getFirstName());
			pstmt.setString(3, developer.getLastName());
			pstmt.setString(4, developer.getUserName());
			pstmt.setString(5, developer.getPassword());
			pstmt.setString(6, developer.getEmail());
			pstmt.setDate(7, developer.getDob());
			pstmt.executeUpdate();
			
			pstmt = con.prepareStatement(developerInsert);
			pstmt.setInt(1, developer.getId());	
			pstmt.setString(2, developer.getDeveloperKey());
			pstmt.executeUpdate();
			
			
			
			pstmt = con.prepareStatement(addressInsert);
			pstmt.setString(1, developer.getAddress().getStreet1());	
			pstmt.setString(2,developer.getAddress().getStreet2());
			pstmt.setString(3, developer.getAddress().getCity());
			pstmt.setString(4, developer.getAddress().getState());
			pstmt.setString(5, developer.getAddress().getZip());
			pstmt.setBoolean(6, developer.getAddress().isPrimary());
			pstmt.setInt(7, developer.getId());
			pstmt.executeUpdate();
			
			pstmt = con.prepareStatement(phoneInsert);
			pstmt.setString(1, developer.getPhone().getPhone());	
			pstmt.setBoolean(2, developer.getPhone().isPrimary());
			pstmt.setInt(3, developer.getId());	
			pstmt.executeUpdate();
//			con.close();
//			Connection.closeConnection();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public List<Developer> findAllDevelopers(){
		List<Developer> developers=new ArrayList<>();
		try {
			String sql =	"select * from developer,person where developer.id=person.id ";
			pstmt = con.prepareStatement(sql);
		ResultSet  result = pstmt.executeQuery();
			while(result.next()) {
				String firstName=result.getString("first_name");
				String lastName=result.getString("last_name");
				String userName=result.getString("username");
				String password=result.getString("password");
				String email=result.getString("email");
				Date dob=result.getDate("dob");
				int id=result.getInt("id");
				String developerKey=result.getString("developer_key");
//				Phone phone=new Phone();
//				phone.setPhone(result.getString("phone"));
//				phone.setPrimary(result.getBoolean("ph.primary"));
//				Address address=new Address();
//				address.setCity(result.getString("city"));
//				address.setPrimary(result.getBoolean("a.primary"));
//				address.setState(result.getString("state"));
//				address.setStreet1(result.getString("street1"));
//				address.setStreet2(result.getString("street2"));
//				address.setZip(result.getString("zip"));
				
			
				Developer developer=new Developer(developerKey,id,firstName,
						lastName);
				developers.add(developer);
			}
			result.close();
			//con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch bloc
			e.printStackTrace();
		}
		return developers;
		
	}
	public Developer findDeveloperById(int developerId) {
		Developer developer = new Developer();
		try {
			String sql =	"select * from developer,person where developer.id=person.id AND developer.id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, developerId);
		ResultSet  result = pstmt.executeQuery();
			while(result.next()) {
				String firstName=result.getString("first_name");
				String lastName=result.getString("last_name");
				String userName=result.getString("user_name");
				String password=result.getString("password");
				String email=result.getString("email");
				Date dob=result.getDate("dob");
				int id=result.getInt("id");
				String developerKey=result.getString("developer_key");
				
			
				 Developer resultDeveloper=new Developer(developerKey,id,firstName,
						lastName);
				developer=resultDeveloper;
			}
			result.close();
			//con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch bloc
			e.printStackTrace();
		}
		return developer;
	}
	public Developer findDeveloperByUsername(String username) {
		Developer developer = new Developer();
		try {
			
//				String sql =	"select * from `developer` d JOIN `phone` ph ON ph.person=d.id"
//					+ " JOIN address a ON a.person=ph.person"
//					+ "JOIN person p ON p.id=ph.person where p.user_name="+username;
				String sql =	"select * from developer,person where developer.id=person.id AND user_name=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, username);
			ResultSet  result = pstmt.executeQuery();
			while(result.next()) {
				String firstName=result.getString("first_name");
				String lastName=result.getString("last_name");
				String userName=result.getString("user_name");
				String password=result.getString("password");
				String email=result.getString("email");
				Date dob=result.getDate("dob");
				int id=result.getInt("id");
				String developerKey=result.getString("developer_key");

				Developer resultDeveloper=new Developer(developerKey,id,firstName,
					lastName);
				developer=resultDeveloper;
			}
			result.close();
			//con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch bloc
			e.printStackTrace();
		}
		return developer;
		
	}
	public Developer findDeveloperByCredentials(String username, String password) {
		Developer developer = new Developer();
		try {
			String sql =	"select * from developer,person where developer.id=person.id "
					+ "AND person.user_name=? AND person.password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
		ResultSet  result = pstmt.executeQuery();
			while(result.next()) {
				String firstName=result.getString("first_name");
				String lastName=result.getString("last_name");
				String userName=result.getString("user_name");
				String pass=result.getString("password");
				String email=result.getString("email");
				Date dob=result.getDate("dob");
				int id=result.getInt("id");
				String developerKey=result.getString("developer_key");
				Phone phone=new Phone();
				phone.setPhone(result.getString("phone"));
				phone.setPrimary(result.getBoolean("ph.primary"));
				Address address=new Address();
				address.setCity(result.getString("city"));
				address.setPrimary(result.getBoolean("a.primary"));
				address.setState(result.getString("state"));
				address.setStreet1(result.getString("street1"));
				address.setStreet2(result.getString("street2"));
				address.setZip(result.getString("zip"));
				
			
				 Developer resultDeveloper=new Developer(developerKey,id,firstName,
						lastName,userName,pass, email, dob,phone,address);
				developer=resultDeveloper;
			}
			result.close();
			//con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch bloc
			e.printStackTrace();
		}
		return developer;
	}
	public int updateDeveloper(int developerId, Developer developer) {
		int row=0;
		try {
			
			String firstName=developer.getFirstName();
			String lastName=developer.getLastName();
			String userName=developer.getFirstName();
			String pass=developer.getPassword();
			String email=developer.getEmail();;
			Date dob=developer.getDob();
			int id=developer.getId();
			String developerKey=developer.getDeveloperKey();
			Phone phone=developer.getPhone();
			String phoneno=phone.getPhone();
			boolean prim=phone.isPrimary();
			Address address=developer.getAddress();
			String city=address.getCity();
			String street1=address.getStreet1();
			String street2=address.getStreet2();
			String zip=address.getZip();
			String state=address.getState();
			boolean primary=address.isPrimary();
			String updateDeveloper ="update developer SET id=?, developer_key=? where id =? ";
			pstmt = con.prepareStatement(updateDeveloper);
			pstmt.setInt(1,id);
			pstmt.setString(2,developerKey);
			pstmt.setInt(3,developerId);
		   row=pstmt.executeUpdate();
		   
		   String updatePerson ="update person SET first_name=?,last_name=?,"
		   		+ "user+name=?,password=?,email=?,dob=?,id=? where id =? ";
			pstmt = con.prepareStatement(updatePerson);
			pstmt.setString(1,firstName);
			pstmt.setString(2,lastName);
			pstmt.setString(3,userName);
			pstmt.setString(4,pass);
			pstmt.setString(5,email);
			pstmt.setDate(6,dob);
			pstmt.setInt(7,id);
			pstmt.setInt(8,developerId);
		   pstmt.executeUpdate();
		   
		   String updateAddress ="update address SET street1=?,street2=?,"
			   		+ "city=?,state=?,zip=?,primary=?,person=? where person =? ";
				pstmt = con.prepareStatement(updateAddress);
				pstmt.setString(1,street1);
				pstmt.setString(2,street2);
				pstmt.setString(3,city);
				pstmt.setString(4,state);
				pstmt.setString(5,zip);
				pstmt.setBoolean(6,primary);
				pstmt.setInt(7,id);
				pstmt.setInt(8,developerId);
			   pstmt.executeUpdate();
			   String updatePhone ="update phone SET phone=?,primary=?,person=? where person =? ";
					pstmt = con.prepareStatement(updatePhone);
					pstmt.setString(1,phoneno);
					pstmt.setBoolean(2,prim);
					pstmt.setInt(3,id);
					pstmt.setInt(4,developerId);
				   pstmt.executeUpdate();
				   //con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return row;

	}
	public int deleteDeveloper(int developerId) {
		int row=0;
		try {
			String deleteDeveloper="delete from developer where id=?";
			pstmt=con.prepareStatement(deleteDeveloper);
			pstmt.setInt(1, developerId);
			row=pstmt.executeUpdate();
			String deletePerson="delete from person where id=?";
			pstmt=con.prepareStatement(deletePerson);
			pstmt.setInt(1, developerId);
			pstmt.executeUpdate();
			String deleteAddress="delete from phone where person=?";
			pstmt=con.prepareStatement(deleteAddress);
			pstmt.setInt(1, developerId);
			pstmt.executeUpdate();
			String deletePhone="delete from address where id=?";
			pstmt=con.prepareStatement(deletePhone);
			pstmt.setInt(1, developerId);
			pstmt.executeUpdate();
			//con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
}
