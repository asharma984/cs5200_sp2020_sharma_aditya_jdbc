package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Website {
private int id;
private String name;
private String description;
private Date created;
private Date updated;
private int visits;
private Developer developer;
private List<Page> pages;


public Website(int id,String name,String description,Date current,Date updated,int visits)
{
	this.id=id;
	this.name=name;
	this.description=description;
	this.created=current;
	this.updated=updated;
	this.visits=visits;
}
public Website() {
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Date getCreated() {
	return created;
}
public void setCreated(Date created) {
	this.created = created;
}
public Date getUpdated() {
	return updated;
}
public void setUpdated(Date updated) {
	this.updated = updated;
}
public int getVisits() {
	return visits;
}
public void setVisits(int visits) {
	this.visits = visits;
}
public Developer getDeveloper() {
	return developer;
}
public void setDeveloper(Developer developer) {
	this.developer = developer;
}
public List<Page> getPages() {
	return pages;
}
public void setPages(List<Page> pages) {
	this.pages = pages;
}
}
