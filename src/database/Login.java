
package database;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Login extends Application  {

    @Override
    public void start(Stage primaryStage)  {
    
        Label title = new Label();
        title.setText("LOGIN PAGE");
        
        Label userlabel = new Label();
        userlabel.setText("USERNAME");
        TextField Username = new TextField();
        Username.setPromptText("Enter your username");
        Username.setMaxWidth(200);
        
        Label passlabel = new Label();
        passlabel.setText("PASSWORD");
        PasswordField password = new PasswordField();
        password.setPromptText("Enter Password");
        password.setMaxWidth(200);
        
        Label Message = new Label();
        
        Button btn1 = new Button();
        btn1.setText("Login");
        
        VBox root = new VBox();
        
        root.getChildren().addAll(title,userlabel,Username,passlabel,password,Message,btn1);
      
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
