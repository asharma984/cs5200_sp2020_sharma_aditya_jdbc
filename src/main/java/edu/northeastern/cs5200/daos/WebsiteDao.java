package edu.northeastern.cs5200.daos;

import java.util.List;

import edu.northeastern.cs5200.models.Website;

public interface WebsiteDao {
	public void createWebsiteForDeveloper(int developerId, Website website);
	public List<Website> findAllWebsites();
	public List<Website> findWebsitesForDeveloper(int developerId);
	public Website findWebsiteById(int websiteId);
	public int updateWebsite(int websiteId, Website website);
	public int deleteWebsite(int websiteId);

}
