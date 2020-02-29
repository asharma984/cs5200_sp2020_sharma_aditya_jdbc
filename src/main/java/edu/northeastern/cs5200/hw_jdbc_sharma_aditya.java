package edu.northeastern.cs5200;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.northeastern.cs5200.daos.DeveloperDao;
import edu.northeastern.cs5200.daos.DeveloperImpl;
import edu.northeastern.cs5200.daos.PageDao;
import edu.northeastern.cs5200.daos.PageImpl;
import edu.northeastern.cs5200.daos.RoleDao;
import edu.northeastern.cs5200.daos.RoleImpl;
import edu.northeastern.cs5200.daos.UserDao;
import edu.northeastern.cs5200.daos.UserImpl;
import edu.northeastern.cs5200.daos.WebsiteDao;
import edu.northeastern.cs5200.daos.WebsiteImpl;
import edu.northeastern.cs5200.daos.WidgetDao;
import edu.northeastern.cs5200.daos.WidgetImpl;
import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.Page;
import edu.northeastern.cs5200.models.Phone;
import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.models.Website;
import edu.northeastern.cs5200.models.Widget;

public class hw_jdbc_sharma_aditya {
 Developer developer;
 DeveloperDao devDao;
 User user;
 UserDao userDao;
 Website website;
 WebsiteDao websiteDao;
 Page page;
 PageDao pageDao;
 RoleDao websiteRole;
 RoleDao pageRole;
 Widget widget;
 WidgetDao widgetDao;
 Map<String,Integer> roleMap;
public hw_jdbc_sharma_aditya()
{
	roleMap=new HashMap<>();
	roleMap.put("owner",1);
	roleMap.put("admin",2);
	roleMap.put("writer",3);
	roleMap.put("editor",4);
	roleMap.put("reviewer",5);
	insertDeveloper();
	insertUser();
	insertWebsiteForDeveloper();
	insertPageForWebsite();
	insertWidget();
	update();
	delete();
}
  public void insertDeveloper()
  {  java.sql.Date current = new java.sql.Date(Calendar.getInstance().getTime().getTime());
	  developer=new Developer("4321rewq",12,"Alice", "Wonder","alice","alice",
			  "alice@wonder.com", current);
	  devDao=new DeveloperImpl();
	  devDao.createDeveloper(developer);
	  developer=new Developer("5432trew",23,"Bob", "Marley","bob","bob","bob@marley.com",current);
	  devDao.createDeveloper(developer);
	  developer=new Developer("6543ytre",34,"Charles", "Garcia","charlie","charlie","chuch@garcia.com",current);
	  devDao.createDeveloper(developer);
  }
  public void insertUser()
  {  
	  user=new User(45,"Dan", "Martin");
	  userDao=new UserImpl();
	  userDao.createUser(user);
	  user=new User(56,"Ed", "Karaz");
	  userDao.createUser(user);
	  
  }
  public void insertWebsiteForDeveloper()
  { devDao=new DeveloperImpl();
  developer=devDao.findDeveloperByUsername("alice");
  int devId=developer.getId();
  java.sql.Date current = new java.sql.Date(Calendar.getInstance().getTime().getTime());
  //LocalDate current=LocalDate.now();
  website=new Website(123,"Facebook","an online social media and social networking service",
		  current,current,1234234);
  websiteDao=new WebsiteImpl();
  websiteDao.createWebsiteForDeveloper(devId, website);

  website=new Website(234, "Twitter", "an online news and social networking service",current,
		  current, 4321543);
  developer=devDao.findDeveloperByUsername("bob");
  devId=developer.getId();
  websiteDao.createWebsiteForDeveloper(devId, website);
  
  website=new Website(345, "Wikipedia", "a free online encyclopedia",current,
		  current, 3456654);
  developer=devDao.findDeveloperByUsername("charlie");
  devId=developer.getId();
  websiteDao.createWebsiteForDeveloper(devId, website);
  
  website=new Website(456, "CNN", "an American basic cable and satellite television news channel",current,
		  current, 6543345);
  developer=devDao.findDeveloperByUsername("alice");
  devId=developer.getId();
  websiteDao.createWebsiteForDeveloper(devId, website);
  
  website=new Website(567, "CNET", "an American media website that publishes reviews, news, articles, blogs,"
  		+ " podcasts and videos on technology and consumer electronics",current,
		  current, 5433455);
  developer=devDao.findDeveloperByUsername("bob");
  devId=developer.getId();
  websiteDao.createWebsiteForDeveloper(devId, website);
  
  website=new Website(678, "Gizmodo", "a design, technology, science and science fiction website that also "
  		+ "writes articles on politics",current,
			  current, 4322345);
	  developer=devDao.findDeveloperByUsername("charlie");
	  devId=developer.getId();
	  websiteDao.createWebsiteForDeveloper(devId, website);
	  
	  websiteRole=new RoleImpl();

      websiteRole.assignWebsiteRole(12, 123, roleMap.get("owner"));
	  websiteRole.assignWebsiteRole(23, 123, roleMap.get("editor"));
	  websiteRole.assignWebsiteRole(34, 123, roleMap.get("admin"));
	  websiteRole.assignWebsiteRole(23, 234, roleMap.get("owner"));
	  websiteRole.assignWebsiteRole(34, 234, roleMap.get("editor"));
	  websiteRole.assignWebsiteRole(12, 234, roleMap.get("admin"));
	  websiteRole.assignWebsiteRole(34, 345, roleMap.get("owner"));
	  websiteRole.assignWebsiteRole(12, 345, roleMap.get("editor"));
	  websiteRole.assignWebsiteRole(23, 345, roleMap.get("admin"));
	  websiteRole.assignWebsiteRole(12, 456, roleMap.get("owner"));
	  websiteRole.assignWebsiteRole(23, 456, roleMap.get("editor"));
	  websiteRole.assignWebsiteRole(34, 456, roleMap.get("admin"));
	  websiteRole.assignWebsiteRole(23, 567, roleMap.get("owner"));
	  websiteRole.assignWebsiteRole(34, 567, roleMap.get("editor"));
	  websiteRole.assignWebsiteRole(12, 567, roleMap.get("admin"));
	  websiteRole.assignWebsiteRole(34, 678, roleMap.get("owner"));
	  websiteRole.assignWebsiteRole(12, 678, roleMap.get("editor"));
	  websiteRole.assignWebsiteRole(23, 678, roleMap.get("admin"));
	  }
  public void insertPageForWebsite() {
	  
	  Date semStart=Date.valueOf(LocalDate.of(2020, 1, 7));
	  Date due=Date.valueOf(LocalDate.of(2020, 2, 27));
	  
	  page=new Page(123, "Home", "Landing page", semStart, due, 123434);
	  pageDao=new PageImpl();
	  pageDao.createPageForWebsite(567, page);
	  
	  page=new Page(234, "About", "Website description", semStart, due, 234545);
	  pageDao=new PageImpl();
	  pageDao.createPageForWebsite(678, page);
	  
	  page=new Page(345, "Contact", "Addresses, phones, and contact info", semStart, due, 345656);
	  pageDao=new PageImpl();
	  pageDao.createPageForWebsite(678, page);
	  
	  page=new Page(456, "Preferences", "Where users can configure their preferences", semStart, due, 456776);
	  pageDao=new PageImpl();
	  pageDao.createPageForWebsite(456, page);
	  
	  page=new Page(567, "Profile", "Users can configure their personal information", semStart, due, 567878);
	  pageDao=new PageImpl();
	  pageDao.createPageForWebsite(567, page);
	  
	
	  
	  pageRole=new RoleImpl();

      pageRole.assignPageRole(12, 123, roleMap.get("editor"));
      pageRole.assignPageRole(23, 123, roleMap.get("reviewer"));
      pageRole.assignPageRole(34, 123, roleMap.get("writer"));
      
      pageRole.assignPageRole(23, 234, roleMap.get("editor"));
      pageRole.assignPageRole(34, 234, roleMap.get("reviewer"));
      pageRole.assignPageRole(12, 234, roleMap.get("writer"));
      
      pageRole.assignPageRole(34, 345, roleMap.get("editor"));
      pageRole.assignPageRole(12, 345, roleMap.get("reviewer"));
      pageRole.assignPageRole(23, 345, roleMap.get("writer"));
      
      pageRole.assignPageRole(12, 456, roleMap.get("editor"));
      pageRole.assignPageRole(23, 456, roleMap.get("reviewer"));
      pageRole.assignPageRole(34, 456, roleMap.get("writer"));
      
      pageRole.assignPageRole(23, 567, roleMap.get("editor"));
      pageRole.assignPageRole(34, 567, roleMap.get("reviewer"));
      pageRole.assignPageRole(12, 567, roleMap.get("writer"));
  }
  
  public void insertWidget()
  {widgetDao=new WidgetImpl();
   widget=new Widget(123,"head123",0,0,"","","Welcome",0);
   widget.setDtype("heading");
   widgetDao.createWidgetForPage(123, widget);
   widget=new Widget(234,"post234",0,0,"","","<p>Lorem</p>",0);
   widget.setDtype("html");
   widgetDao.createWidgetForPage(234, widget);
   widget=new Widget(345,"head345",0,0,"","","Hi",1);
   widget.setDtype("heading");
   widgetDao.createWidgetForPage(345, widget);
   widget=new Widget(456,"intro456",0,0,"","","<h1>Hi</h1>",2);
   widget.setDtype("html");
   widgetDao.createWidgetForPage(345, widget);
   widget=new Widget(567,"image345",50,100,"","","",3);
   widget.setDtype("image");
   widget.setUrl("/img/567.png");
   widgetDao.createWidgetForPage(345, widget);
   widget=new Widget(678,"video456",400,300,"","","",0);
   widget.setDtype("youtube");
   widget.setUrl("https://youtu.be/h67VX51QXiQ");
   widgetDao.createWidgetForPage(456, widget);
  }
  
  public void update()
  {   //update developer
	  developer=devDao.findDeveloperByUsername("alice");
	  int id=developer.getId();
	  Phone phone=new Phone();
	  phone.setPhone("3334445555");
	  phone.setPrimary(true);
	  developer.setPhone(phone);
	  devDao.updateDeveloper(id, developer);
	  
	 
	
	  //update page
	  pageDao = new PageImpl();
      List<Page> pages = pageDao.findAllPages();
      List<Page> updatePages = new ArrayList<>();
      for (Page p : pages) {
    	  if(p.getWebsite()!=null)
          {if (p.getWebsite().getId() == 567) {
             updatePages.add(p);
          }
          }
      }
      for (Page p : updatePages) {
          p.setTitle("CNET-" + p.getTitle());
          pageDao.updatePage(p.getId(), p);
      }
      
      //update widget
	  widgetDao = new WidgetImpl();
      List<Widget> widgets = widgetDao.findWidgetsForPage(345);
      for (Widget w : widgets) {
          if (w.getName().equals("head345")) {
              w.setOrder(3);
              widgetDao.updateWidget(w.getId(), w);
          } else {
        	  int wid=w.getId();
        	  int newOrder=w.getOrder()-1;
              w.setOrder(newOrder);
              widgetDao.updateWidget(wid, w);
          }
      }
      
      

	}
  public void delete()
  {
	    //delete widget
      widgetDao = new WidgetImpl();
      List<Widget> widgets = widgetDao.findWidgetsForPage(345);
      int max = 0;
      int maxId=0;
      for (Widget w : widgets) {
          if (w.getOrder() > max) {
              max= w.getOrder();
              maxId=w.getId();
          }
      }
      widgetDao.deleteWidget(maxId);
     
      
      //delete page
      pageDao = new PageImpl();
      List<Page> pages = pageDao.findPagesForWebsite(345);
      Page lastPage = new Page();
      lastPage.setUpdated(new Date(0));
      int lastId=0;
      for (Page page : pages) {
          if (page.getUpdated().compareTo(lastPage.getUpdated()) > 0) {
              lastPage = page;
              lastId=page.getId();
          }
      }
      pageDao.deletePage(lastId);
      
      //delete Website
      websiteDao = new WebsiteImpl();
      websiteDao.deleteWebsite(567);
      

  }


  }
  

