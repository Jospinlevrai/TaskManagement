
package database;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Login extends Application  {

    @Override
    public void start(Stage primaryStage)  {
    
        Label title = new Label();
        title.setText("LOGIN PAGE");
        
        Label userlabel = new Label();
        userlabel.setText("Email");
        TextField Email = new TextField();
        Email.setPromptText("Enter your username");
        Email.setMaxWidth(200);
        
        Label passlabel = new Label();
        passlabel.setText("PASSWORD");
        PasswordField password = new PasswordField();
        password.setPromptText("Enter Password");
        password.setMaxWidth(200);
        
        Label Message = new Label();
        
        Button btn1 = new Button();
        btn1.setText("Login");
        
        Label Regi = new Label();
        Regi.setText("Create Account");
        
        Regi.setOnMouseClicked(new EventHandler<MouseEvent>(){
           
            @Override
            public void handle(MouseEvent event) {
            Registration loginPage = new Registration();
            Stage RegistrationStage = new Stage();
            loginPage.start(RegistrationStage);
            primaryStage.close();
            
            
            }
            
        
        });
        
        btn1.setOnAction( new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
            
            String inputemail = Email.getText();
            String inpassword = password.getText();
            
            if(inputemail.isEmpty() || inpassword.isEmpty()){
            Message.setText("Please fill all the fields");
            
            return;
            }
            
            Logincheck lc = new Logincheck();
            
            Employee employee = lc.checklogin(inputemail,inpassword);
            
            if(employee == null){
            Message.setText("Invalid Credentials");
            
            }else if(!employee.isActive()){
            Message.setText("Inactive Account.Contact your Manager");
            
            }else if(employee.getRole().equals("MANAGER")){
            
                ManagerDashboard Managerpage = new ManagerDashboard();
                Stage Manstage = new Stage();
                Managerpage.start(Manstage);
                primaryStage.close();
              
            }
                
            
            
            }
        
        
        
        
        });
        
        VBox root = new VBox();
        
        root.getChildren().addAll(title,userlabel,Email,passlabel,password,Message,btn1,Regi);
      
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        
        Scene Login = new Scene(root,600,400);
        
        primaryStage.setTitle("LOGIN SYSTEM");
        primaryStage.setScene(Login);
        primaryStage.show();
      
    }
     public static void main(String[] args) {
        launch(args);
    }
   
}
