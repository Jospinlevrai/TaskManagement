/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.time.LocalDateTime;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Registration extends Application {

    @Override
    public void start(Stage primaryStage)  {
        
         Label title = new Label();
         title.setText("REGISTRATION PAGE");
         
         
         Label namelabel = new Label("Enter Full name");
         TextField Name = new TextField();
         Name.setPromptText("Full name");
         Name.setMaxWidth(250);
         
         Label emailLabel = new Label("Enter your email");
         TextField tfemail  = new TextField();
         tfemail.setPromptText("Email");
         tfemail.setMaxWidth(250);
         
         
        Label AgeLabel = new Label("Enter your Age(+18)");
        TextField tfAge = new TextField();
        tfAge.setPromptText("Age");
        tfAge.setMaxWidth(250);
        
        Label passwordLabel = new Label("Enter  your password");
        PasswordField pfPassword = new PasswordField();
        pfPassword.setPromptText("Ënter your Password");
        pfPassword.setMaxWidth(250);
        
        Label roleLabel = new Label("Role");
        ComboBox<String> Role = new ComboBox<>();
        
        
        
        Role.getItems().addAll("MANAGER","EMPLOYEE");
        Role.setPromptText("Select Role");
        
        
        TextField managercode = new TextField();
        managercode.setPromptText("MANAGER CODE");
        managercode.setMaxWidth(250);
        managercode.setVisible(false);
        
        
        Role.setOnAction(new EventHandler<ActionEvent>(){
             @Override
             public void handle(ActionEvent event) {
              if (Role.getValue() != null && Role.getValue().equals("MANAGER")){
                managercode.setVisible(true);
        }else {
        managercode.setVisible(false);
        }
             }
        
           
        });
        
        CheckBox isActive = new CheckBox("Active Account");
        
        

        Label statusLabel = new Label();
        
        
        Button Register = new Button("REGISTER");
        
        Register.setOnAction(new EventHandler<ActionEvent>(){
        
        @Override
        public void handle(ActionEvent event){
         
            //Condition for Register
            if (Name.getText().isEmpty() || tfemail.getText().isEmpty() ||
            tfAge.getText().isEmpty() || pfPassword.getText().isEmpty() ||
            Role.getValue() == null) {
            statusLabel.setText(" Please fill in all fields.");
            return;
            }
            else if (!tfemail.getText().contains("@")){
              statusLabel.setText("Invalid email address");
                 return;
              }
            else if(Role.getValue().equals("MANAGER") && !managercode.getText().equals("AD-243")){
            statusLabel.setText("Invalid manager code");    
            return;
            }
            
            
        
          DBConnection dbc = new DBConnection();
          
          try{
              
              
          DBOperations dbo = new DBOperations();
          
          Employee employee = new Employee(
            0,Name.getText(),tfemail.getText(),Integer.parseInt(tfAge.getText()),
            pfPassword.getText(),Role.getValue(),isActive.isSelected(),LocalDateTime.now());
          
            dbo.insertoperation(employee);
            Name.clear();

            tfemail.clear();

            tfAge.clear();

            pfPassword.clear();

            Role.setValue(null);
          
            isActive.setSelected(true);
          
            Login loginPage = new Login();
            Stage loginStage = new Stage();
            loginPage.start(loginStage);
            primaryStage.close();
                
          
          }catch(Exception ex) {

            System.out.println(
            ex.getMessage()
            );}
        }
        
        });
        
        VBox root = new VBox(10);
        root.getChildren().addAll(title,namelabel,Name,emailLabel,tfemail,AgeLabel,tfAge,
                                  passwordLabel,pfPassword,roleLabel,Role,managercode,isActive,Register
                                  ,statusLabel);
        
        
        root.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(root,400,450);
        
        primaryStage.setTitle("REGISTRATION PAGE");
        
        primaryStage.setScene(scene);
        
        primaryStage.show();
        
   
        
        
            
        
        
        
        
        
                
  }
  public static void main(String[] args) {

        launch(args);
    }  
}
 
