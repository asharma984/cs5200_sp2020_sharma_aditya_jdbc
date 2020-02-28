package edu.northeastern.cs5200.models;

import java.sql.Date;



public abstract class Person {
private int id;
private Phone phone;
private Address address;
private String firstName;
private String lastName;
private String userName;
private String password;
private String email;
private Date dob;
public Person() {
	
}
public Person(int id,String firstName, String lastName,String userName,
		String password, String email,Date dob,Phone phone,Address address) {
	// TODO Auto-generated constructor stub
	this.id=id;
	this.firstName=firstName;
	this.lastName=lastName;
	this.userName=userName;
	this.password=password;
	this.email=email;
	this.dob=dob;
	if(phone==null)
	{
	phone=new Phone();
	}
	else {
		this.phone=phone;
	}
	if(address==null)
	{
		address=new Address();
	}
	else {
	this.address=address;
	}
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Phone getPhone() {
	return phone;
}
public void setPhone(Phone phone) {
	this.phone = phone;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}


}
