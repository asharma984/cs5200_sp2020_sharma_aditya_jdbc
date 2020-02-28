package edu.northeastern.cs5200.models;

public class User extends Person{
private boolean userAgreement;
public User( int userID,String firstName,String lastName ) {
	super(userID,firstName,lastName,"user","password","xyz@abc.com",null,null,null);
	this.userAgreement = true;
	
}

public boolean isUserAgreement() {
	return userAgreement;
}

public void setUserAgreement(boolean userAgreement) {
	this.userAgreement = userAgreement;
}
}
