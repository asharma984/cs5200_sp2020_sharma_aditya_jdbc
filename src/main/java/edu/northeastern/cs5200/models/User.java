package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.time.LocalDate;

public class User extends Person{
private boolean userAgreement;
public User( int userID,String firstName,String lastName ) {
	super(userID,firstName,lastName,"user","password","xyz@abc.com",
			Date.valueOf(LocalDate.of(2000, 12, 12)),new Phone(),new Address());
	this.userAgreement = true;
	
}

public boolean isUserAgreement() {
	return userAgreement;
}

public void setUserAgreement(boolean userAgreement) {
	this.userAgreement = userAgreement;
}
}
