package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import connection.Connect;
import dao.Task;
import dao.TaskEmpl;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TaskController {
	private Stage stage;
	private Scene scene;


    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnUpdate;

    @FXML
    private TextField tfCategory;

    @FXML
    private TextField tfDeadline;

    @FXML
    private TextField tfDescription;

    @FXML
    private TextField tfStatut;

    @FXML
    private TextField tfTitle;

    @FXML
    private TableView<Task> tv;
    @FXML
	private TableColumn<Task,String> colTitle;
	@FXML
	private TableColumn<Task,String> colCategory;
	@FXML
	private TableColumn <Task,String>colDeadline;
	@FXML
	private TableColumn <Task,String>colDescription;
	@FXML
	private TableColumn <Task,String>colStatut;
	
	TaskEmpl fct = new TaskEmpl();
	Connection conn = Connect.getconnect();
//	SignInController swt=new SignInController();
	
	//@Override
	public void initialize (URL arg0, ResourceBundle arg1) {
	        showuser();
	    }
	 @FXML
	    public void switchToLogIn(ActionEvent event) throws IOException {
	    	Parent root=FXMLLoader.load(getClass().getResource("LogIn.fxml"));
	    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	    	scene= new Scene(root);
	    	stage.setScene(scene);
	    	stage.show();

	    }
	
	
    @FXML
    void handleButtonnAction(ActionEvent event) {
    	if(event.getSource() == btnAdd) {
			fct.Create (tfTitle.getText(),tfStatut.getText(),tfDeadline.getText(),tfCategory.getText(),tfDescription.getText());
			showuser();}
//        String Title, String Statut, String Deadline, String Category,String Description
	   else if (event.getSource() == btnUpdate) {
		   fct.Update (tfTitle.getText(),tfStatut.getText(),tfDeadline.getText(),tfCategory.getText(),tfDescription.getText());
			showuser();}
        
        else if(event.getSource() == btnDelete) {
        	fct.Delete (tfTitle.getText());
			showuser();
		}

    }
	



	

	
	public void showuser() {
		ObservableList<Task> list =  fct.UserList();
		
		
		colTitle.setCellValueFactory(new PropertyValueFactory<Task,String>("Title"));
		colStatut.setCellValueFactory(new PropertyValueFactory<Task,String>("Statut"));
		colDeadline.setCellValueFactory(new PropertyValueFactory<Task,String>("Deadline"));
		colStatut.setCellValueFactory(new PropertyValueFactory<Task,String>("Statut"));
		colDescription.setCellValueFactory(new PropertyValueFactory<Task,String>("Description"));
		
		
		tv.setItems(list);
	}

    

}