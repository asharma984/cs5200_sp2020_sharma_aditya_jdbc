package edu.northeastern.cs5200.daos;

import java.util.List;

import edu.northeastern.cs5200.models.Developer;

public interface DeveloperDao {
	public void createDeveloper(Developer developer);
	public List<Developer> findAllDevelopers();
	public Developer findDeveloperById(int developerId);
	public Developer findDeveloperByUsername(String username);
	public Developer findDeveloperByCredentials(String username, String password);
	public int updateDeveloper(int developerId, Developer developer);
	public int deleteDeveloper(int developerId);
}
