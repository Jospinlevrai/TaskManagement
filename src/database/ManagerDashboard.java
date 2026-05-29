/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author lukog
 */
public class ManagerDashboard extends Application {

    @Override
    public void start(Stage Manstage) {
    
    VBox root = new VBox();
    
    root.getChildren().addAll();
    
    root.setAlignment(Pos.CENTER);
    root.setSpacing(20);
        
        Scene Man = new Scene(root,600,400);
        
        Manstage.setTitle("Manager Dashboard");
        Manstage.setScene(Man);
        Manstage.show();
        }
    
    public static void main (String[ ] args){
    launch(args);
    }
}
