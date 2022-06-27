package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
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

public class SignUpController {

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
    private TextField tfName;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfUsername;
    

    @FXML
    void initialize() {
    	
    	btnSignUp.setOnAction(event ->{
    		createUser();
    		
    		
    	});
    	
    	btnLogIn.setOnAction(event ->{
    		changeToLogin(event);
    	});
    }
    
    public void createUser() {
    	  DaoImp work =new DaoImp();
    	  
    	  String name = tfName.getText();
    	  String email = tfEmail.getText();
    	  String username = tfUsername.getText();
    	  String password = tfPassword.getText();
    	  
    	  Users user = new Users(name,email,username,password);
    	  
    	  work.signUpUser(user);
    	  

    }
    
    public void changeSignUpToMain(ActionEvent event) {
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/view/Space.fxml"));
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        Scene scene= new Scene(root);
	        stage.setScene(scene);
	        stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void changeToLogin(ActionEvent event){
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        Scene scene= new Scene(root);
	        stage.setScene(scene);
	        stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }

}
