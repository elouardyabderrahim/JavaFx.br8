package dao;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;

public interface DaoTask {
	public ObservableList<Task> UserList();
	public void Create(String Title, String Statut, String Deadline, String Category,String Description);
	public void Update(String Title, String Statut, String Deadline, String Category,String Description);
	public void Delete(String Title);
	
//	ObservableList<User> UsersList();

}
