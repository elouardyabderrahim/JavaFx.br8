package dao;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;

public interface DaoUser {
	public ObservableList<User> UserList();
	public void Create(String ID,String Name,String Email,String LastName,String UserName,String Password);
//	public void Update(String ID,String Name,String Email,String LastName,String UserName,String Password);
//	public void Delete(String ID);
	
//	ObservableList<User> UsersList();

}
//Un utlisateur est caractirisé par:un nom,prénom, nom d'utilisateur et mot de pass.





