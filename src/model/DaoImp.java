package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.DBconnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public class DaoImp implements Dao {
	
	Connection conn = DBconnection.getconnect();
	PreparedStatement ps;
	Statement st;

	@Override
	public void signUpUser(Users user) {
//		SignUpController change = new SignUpController();
		
		PreparedStatement psInsert = null;
		PreparedStatement psExists = null;
		ResultSet resultset = null;
		String name = user.getName();
		String email= user.getEmail();
		String username = user.getUsername();
		String password = user.getPassword();
		//String insert ="INSERT INTO users(firstname,lastname,username,password) VALUES(?,?,?,?)";
		
		try {
			if(!name.equals("") && !email.equals("") && !username.equals("") && !password.equals("")) {
				String query = "SELECT * FROM users WHERE email = ?";
				psExists = conn.prepareStatement(query);
				psExists.setString(1,user.getEmail());
				resultset = psExists.executeQuery();
				
				if(resultset.isBeforeFirst()) {
					System.out.println("User already exists!!");
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setContentText("Email Not valid!!");
					alert.show();
				}else {
					String query1 = "INSERT INTO users(name , email , username , password) VALUES (?,?,?,?)";
					psInsert=conn.prepareStatement(query1);
					psInsert.setString(1,name);
					psInsert.setString(2,email);
					psInsert.setString(3,username);
					psInsert.setString(4,password);
					psInsert.executeUpdate();
					
				}
			}else {
				System.out.println("Fill in information!!");
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setContentText("Fill in information!!");
				alert.show();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet getUser(Users user) {
		ResultSet rs = null;
		
		if(!user.getEmail().equals("") || !user.getPassword().equals("")) {
			String query = "SELECT * FROM users WHERE email = ? AND password = ?";
			
			try {
				ps = conn.prepareStatement(query);
				ps.setString(1,user.getEmail());
				ps.setString(2,user.getPassword());
				
				rs = ps.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Please Enter your credentials!");
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Please Enter your credentials!");
			alert.show();
		}
		return rs;
	}

	@Override
	public ObservableList<Tasks> TasksList() {
		ObservableList<Tasks> List = FXCollections.observableArrayList();
        String query = "SELECT * FROM tasks" ;
        ResultSet rs;
        
        try{
			st = conn.createStatement();
            rs = st.executeQuery(query);
            Tasks task;
            while(rs.next()){
                task = new Tasks(rs.getString("title"),rs.getString("description"),rs.getString("status"),rs.getString("deadline"),rs.getString("categorie"));
                List.add(task);
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return List;
        
	}
	@Override
	public void create(Tasks task) {
		String title = task.getTitle();
		String description = task.getDescription();
		String status = task.getStatus();
		String deadline = task.getDeadline();
		String categorie = task.getCategorie();
		
		String query = "INSERT INTO tasks(title,description,status,deadline,categorie) VALUES ('" +title + "','" + description + "','" + status + "','" + deadline + "','" + categorie + "')";
	       
		try{
			st = conn.createStatement();
			st.executeUpdate(query);
			System.out.println("Creating is Done.");
		}catch(Exception ex){
            ex.printStackTrace();
			System.out.println("Creating Did not go will.");
        }
	}

	@Override
	public void update(Tasks task) {
		String title = task.getTitle();
		String description = task.getDescription();
		String status = task.getStatus();
		String deadline = task.getDeadline();
		String categorie = task.getCategorie();
		
		String query = "UPDATE  tasks SET title = '" +title + "',description='" + description + "',status='" + status + "',deadline='" + deadline + "',categorie='" + categorie + "' WHERE title =" + title;
	       
		try{
			st = conn.createStatement();
			st.executeUpdate(query);
			System.out.println("Updating is Done.");
		}catch(Exception ex){
            ex.printStackTrace();
			System.out.println("Updating Did not go will.");
        }
	}
	
	@Override
	public void delete(String title) {
        String query = "DELETE FROM tasks WHERE id =" + title ;
        
		try{
			st = conn.createStatement();
			st.executeUpdate(query);
			  System.out.println("Deleting is Done.");
		}catch(Exception ex){
            ex.printStackTrace();
        }
		
	}


	
	
	
	

}
