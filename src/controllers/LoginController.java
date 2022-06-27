package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DaoImp;
import model.Users;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnLogIn;

    @FXML
    private Button btnSignUp;

    @FXML
    private PasswordField tfPassword;

    @FXML
    private TextField tfEmail;
    
    

    @FXML
    void initialize() {
    	
    	btnLogIn.setOnAction(event ->{
    		DaoImp work = new DaoImp();
        	
        	String loginUser = tfEmail.getText().trim(); 
        	String loginPwd = tfPassword.getText().trim();
        	
        	Users user= new Users();
        	user.setEmail(loginUser);
        	user.setPassword(loginPwd);
    		
    		ResultSet userRow = work.getUser(user);
    		
    		int counter =0;
    		
    		try {
				while(userRow.next()) {
					counter++;
				}
				if(counter==1) {
					showMain();
				}else {
						Shaker shaker= new Shaker(tfEmail);
						shaker.shake();
						Shaker shaker1= new Shaker(tfPassword);
						shaker1.shake();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	});
    	
    	btnSignUp.setOnAction(event ->{
    		Parent root;
    		try {
    			root = FXMLLoader.load(getClass().getResource("/view/SignUp.fxml"));
    			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	        Scene scene= new Scene(root);
    	        stage.setScene(scene);
    	        stage.show();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	});
    }
    
    private void showMain() {
    	//take users to the addItem screen
    	btnLogIn.getScene().getWindow().hide();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/Space.fxml"));
		try {
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Parent root =  loader.getRoot();
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.setTitle("TODO!");
		stage.showAndWait();
    }
}
