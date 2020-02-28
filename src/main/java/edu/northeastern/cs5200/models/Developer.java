package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Developer extends Person{
private String developerKey;
private List<Website> websites;
public Developer() {
	super();
}

public Developer(String developerKey, int developerID,String firstName,String lastName ) {
	super(developerID,firstName,lastName,"user","password",
			"xyz@abc.com",Date.valueOf(LocalDate.of(2000, 12, 12)),new Phone(),new Address());
	this.developerKey = developerKey;
	
}
public Developer(String developerKey, int developerID,String firstName,String lastName,String userName,
		String password,String email,Date dob) {
	super(developerID,firstName,lastName,userName,password,email,dob,new Phone(),new Address());
	this.developerKey = developerKey;
}
public Developer(String developerKey, int developerID,String firstName,String lastName,String userName,
		String password,String email,Date dob,Phone phone,Address address) {
	super(developerID,firstName,lastName,userName,password,email,dob,phone,address);
	this.developerKey = developerKey;
}
public String getDeveloperKey() {
	return developerKey;
}
public void setDeveloperKey(String developerKey) {
	this.developerKey = developerKey;
}
public List<Website> getWebsites() {
	return websites;
}
public void setWebsites(List<Website> websites) {
	this.websites = websites;
}
}
