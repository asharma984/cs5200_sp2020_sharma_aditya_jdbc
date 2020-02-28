package edu.northeastern.cs5200.models;

public class Phone {
private String phone;
private boolean primary;
public Phone() {
	phone="";
	primary=false;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public boolean isPrimary() {
	return primary;
}
public void setPrimary(boolean primary) {
	this.primary = primary;
}
}
