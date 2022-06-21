package dao;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import connection.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserEmpl implements DaoUser{
	Connection conn = Connect.getconnect();
	Statement st;
	
	/*public ObservableList<User> UserList(){
		 ObservableList<User> CList = FXCollections.observableArrayList();
	        String query = "SELECT * FROM users";
	        ResultSet rs;
	        
	        try{
	            st = conn.createStatement();
	            rs = st.executeQuery(query);
	            User C;
	            while(rs.next()){
	                C = new User(rs.getInt("id"),rs.getString("name"),rs.getString("adress"),rs.getString("email"),rs.getString("city"),rs.getString("country"));
	                CList.add(C);
	            }
	                
	        }catch(Exception ex){
	            ex.printStackTrace();
	        }
	        return CList;
	    }*/

	

	@Override
	 public void Create(String ID,String Name,String Email,String LastName,String UserName,String Password){
        String query = "INSERT INTO users VALUES (" +ID + ",'" + Name + "','" + LastName + "','" + Email + "','" +UserName + "','" + Password + "')";
       
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
	public ObservableList<User> UserList() {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public void Update(String ID,String Name,String Adress,String Email,String City,String Country){
        String query = "UPDATE users SET id = '" + ID + "', name = '" + Name + "', adress = '" + Adress +"', email = '" + Email + "', city = '" +City + "', country = '" + Country + "' WHERE id =  "+ ID;
        
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
	public void Delete(String ID) {
		String query = "DELETE FROM users WHERE id =" + ID ;
        
		try{
			st = conn.createStatement();
			st.executeUpdate(query);
			  System.out.println("Deleting is Done.");
		}catch(Exception ex){
            ex.printStackTrace();
        }
		
       
		
	}*/

	



	



	


	

}
