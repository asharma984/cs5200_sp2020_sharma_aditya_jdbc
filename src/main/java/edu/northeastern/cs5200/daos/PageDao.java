package edu.northeastern.cs5200.daos;

import java.util.List;

import edu.northeastern.cs5200.models.Page;

public interface PageDao {
	public void createPageForWebsite(int websiteId, Page page);
	public List<Page> findAllPages();
	public Page findPageById(int pageId);
	public List<Page> findPagesForWebsite(int websiteId);
	public int updatePage(int pageId, Page page);
	public int deletePage(int pageId);
}
