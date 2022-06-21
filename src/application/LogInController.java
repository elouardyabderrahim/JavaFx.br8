package application;

import java.io.IOException;

import dao.UserEmpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LogInController {
	private Stage stage;
	private Scene scene;
	private Parent root;

    @FXML
    private Button btnEnt;

    @FXML
    private Button btnSignIn;

    @FXML
    private TextField tfEmail;

    @FXML
    private PasswordField tfPassword;
    @FXML
    private Label notNnregLabel;
    
    
   
    @FXML
    void handleButtonnAction(ActionEvent event) {

    }
    
    
   
    @FXML
    public void switchToSignIn(ActionEvent event) throws IOException {
    	Parent root=FXMLLoader.load(getClass().getResource("SignIn.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene= new Scene(root);
    	stage.setScene(scene);
    	stage.show();

    }
    @FXML
    public void switchToTask(ActionEvent event) throws IOException {
    	if(tfEmail.getText().isBlank()||tfPassword.getText().isBlank()) {
    		notNnregLabel.setText("plz SignIn");
    	}
    	else if(tfEmail.getText().equals("abde")&& tfPassword.getText().equals("1234") ){
    	 
    	    	Parent root=FXMLLoader.load(getClass().getResource("Task.fxml"));
    	    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	    	scene= new Scene(root);
    	    	stage.setScene(scene);
    	    	stage.show();

    	    }
    }
   
    

}
