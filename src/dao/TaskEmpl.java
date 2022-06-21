package dao;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import connection.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TaskEmpl implements DaoTask{
	Connection conn = Connect.getconnect();
	Statement st;
	
	public ObservableList<Task> UserList(){
		 ObservableList<Task> CList = FXCollections.observableArrayList();
	        String query = "SELECT * FROM tasks";
	        ResultSet rs;
	        
	        try{
	            st = conn.createStatement();
	            rs = st.executeQuery(query);
	            Task C;
	            while(rs.next()){
	                C = new Task(rs.getString("title"),rs.getString("statut"),rs.getString("deadline"),rs.getString("category"),rs.getString("Description"));
	                CList.add(C);
	            }
	                
	        }catch(Exception ex){
	            ex.printStackTrace();
	        }
	        return CList;
	    }

	

	@Override
	 public void Create(String Title, String Statut, String Deadline, String Category,String Description){
        String query = "INSERT INTO tasks VALUES ('" +Title + "','" + Statut + "','" + Deadline + "','" +Category+ "','" +Description +  "')";
       
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
	public void Update(String Title, String Statut, String Deadline, String Category,String Description){
        String query = "UPDATE tasks SET Title = '" + Title + "',' Statut = '" + Statut + "', 'Deadline = '" +Deadline +"', Category = '" +Category +"', Description = '" +Description + "' WHERE Title =  '"+ Title+"'";
        
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
	public void Delete(String Title) {
		String query = "DELETE FROM tasks WHERE Title='" +  Title +"'";
        
		try{
			st = conn.createStatement();
			st.executeUpdate(query);
			  System.out.println("Deleting is Done.");
		}catch(Exception ex){
            ex.printStackTrace();
        }
		
       
		
	}



	
	



	


	

}
