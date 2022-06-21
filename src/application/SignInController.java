package application;

import java.io.IOException;

import dao.TaskEmpl;
import dao.UserEmpl;
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

public class SignInController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	UserEmpl fct = new UserEmpl();

	 

	    @FXML
	    private TextField tfEmail;

	    @FXML
	    private TextField tfID;

	    @FXML
	    private TextField tfLastName;

	    @FXML
	    private TextField tfName;

	    @FXML
	    private TextField tfPassword;

	    @FXML
	    private TextField tfUserName;

    @FXML
    private Button btnLogIn;

    @FXML
    private Button btnSignInEn;
//String ID,String Name,String Email,String LastName,String UserName,String Password
    @FXML
    void handleButtonnAction(ActionEvent event) {
    	if(event.getSource() == btnSignInEn) {
			fct.Create (tfID.getText(),tfName.getText(),tfLastName.getText(),tfEmail.getText(),tfUserName.getText(),tfPassword.getText());
			}

    }
    @FXML
    public void switchToLognIn(ActionEvent event) throws IOException {
    	Parent root=FXMLLoader.load(getClass().getResource("LogIn.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene= new Scene(root);
    	stage.setScene(scene);
    	stage.show();

    }

}

