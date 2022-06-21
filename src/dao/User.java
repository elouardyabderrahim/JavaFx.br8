package dao;
//String ID,String Name,String Email,String LastName,String UserName,String Password
public class User {
	private int ID;
	private String Name;
	private String Email;
	private String LastName;
	private String UserName;
	private String Password;
	
	public User(int iD, String name, String lastName,String email,  String userName, String password) {
		super();
		ID = iD;
		Name = name;
		Email = email;
		LastName = lastName;
		UserName = userName;
		Password = password;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	
	

}
