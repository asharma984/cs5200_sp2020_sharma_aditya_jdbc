package edu.northeastern.cs5200.models;

public class Widget {
private int id;
private String name;
private int width;
private int height;
private String cssClass;
private String cssStyle;
private String text;
private int order;
private String url;
private boolean shareable;
private boolean expandable;
private String source;
private int size;
private String html;
private Page page;
private String dtype;


public Widget(int id,String name,int width,int height,String cssClass,String cssStyle,String text,int order)
{
	this.id=id;
	this.name=name;
	this.width=width;
	this.height=height;
	this.cssClass=cssClass;
	this.cssStyle=cssStyle;
	this.text=text;
	this.order=order;

}
public Widget(int id,String name,int width,int height,String cssClass,String cssStyle,String text,int order,
		String url,boolean shareable,boolean expandable,int size,String source,String html,String dtype)
{
	this.id=id;
	this.name=name;
	this.width=width;
	this.height=height;
	this.cssClass=cssClass;
	this.cssStyle=cssStyle;
	this.text=text;
	this.order=order;
	this.size=size;
	this.html=html;
	this.source=source;
	this.url=url;
	this.shareable=shareable;
	this.expandable=expandable;
	this.dtype=dtype;
}


public Widget() {
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
public int getWidth() {
	return width;
}
public void setWidth(int width) {
	this.width = width;
}
public int getHeight() {
	return height;
}
public void setHeight(int height) {
	this.height = height;
}
public String getCssClass() {
	return cssClass;
}
public void setCssClass(String cssClass) {
	this.cssClass = cssClass;
}
public String getCssStyle() {
	return cssStyle;
}
public void setCssStyle(String cssStyle) {
	this.cssStyle = cssStyle;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public int getOrder() {
	return order;
}
public void setOrder(int order) {
	this.order = order;
}
public String getDtype() {
	return dtype;
}
public void setDtype(String dtype) {
	this.dtype = dtype;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public boolean isShareble() {
	return shareable;
}
public void setShareble(boolean shareble) {
	this.shareable = shareble;
}
public boolean isExpandable() {
	return expandable;
}
public void setExpandable(boolean expandable) {
	this.expandable = expandable;
}
public String getSource() {
	return source;
}
public void setService(String source) {
	this.source= source;
}
public int getSize() {
	return size;
}
public void setSize(int size) {
	this.size = size;
}
public String getHtml() {
	return html;
}
public void setHtml(String html) {
	this.html = html;
}
public Page getPage() {
	return page;
}
public void setPage(Page page) {
	this.page = page;
}

}
