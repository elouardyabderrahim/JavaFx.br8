package model;

import java.sql.ResultSet;

import javafx.collections.ObservableList;

public interface Dao {
	
	public void signUpUser(Users user);
	
	public ResultSet getUser(Users user);
	
	public ObservableList<Tasks> TasksList();
	
	public void create(Tasks task);

	public void update(Tasks task);
	
	public void delete(String title);
}
