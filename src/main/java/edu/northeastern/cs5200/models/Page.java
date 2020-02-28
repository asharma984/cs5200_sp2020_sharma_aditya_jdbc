package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.List;

public class Page {
private int id;
private String title;
private String description;
private Date created;
private Date updated;
private int views;
private Website website;
private List<Widget> widgets;



public Page(int id,String title,String description,Date created,Date updated,int views)
{this.id=id;
this.title=title;
this.description=description;
this.created=created;
this.updated=updated;
this.views=views;
	
}
public Page() {
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
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
public int getViews() {
	return views;
}
public void setViews(int views) {
	this.views = views;
}
public Website getWebsite() {
	return website;
}
public void setWebsite(Website website) {
	this.website = website;
}
public List<Widget> getWidgets() {
	return widgets;
}
public void setWidgets(List<Widget> widgets) {
	this.widgets = widgets;
}

}
