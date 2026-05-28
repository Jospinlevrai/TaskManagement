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
         
         
         
         TextField Name = new TextField();
         Name.setPromptText("Full name");
         Name.setMaxWidth(250);
         
         Label emailLabel = new Label("Role");
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
        
        CheckBox isActive = new CheckBox("Active Account");
        
        

        Label statusLabel = new Label();
        
        
        Button Register = new Button("REGISTER");
        
        Register.setOnAction(new EventHandler<ActionEvent>(){
        
        @Override
        public void handle(ActionEvent event){
        
          DBConnection dbc = new DBConnection();
          
          try{
          DBOperations dbo = new DBOperations();
          
          dbo.insertoperation(
          Name.getText(),
          tfemail.getText(),
          Integer.parseInt(
            tfAge.getText()),
          
          pfPassword.getText(),
          
          Role.getValue(),
          isActive.isSelected()  
                  
          );
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
        root.getChildren().addAll(title,Name,tfemail,tfAge,pfPassword,Role,isActive,Register,statusLabel);
        
        
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
 
