/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import java.sql.*;
import java.time.*;
import java.sql.Timestamp;

/**
 *
 * @author lukog
 */
public class DBOperationImpl implements DBUpdate,DBDelete,DBinsert,DBSelect {
   @Override
   public void insertoperation(String Name, String email, int age, String password, String role,boolean isActive) {
    DBConnection dbc = new DBConnection();
    try {
        String query = "INSERT INTO employee(full_name, email, age, created_at, password, role, is_active) "
                     + "VALUES(?,?,?,?,?,?,?)";

        PreparedStatement pst = dbc.con.prepareStatement(query);

        pst.setString(1, Name);
        pst.setString(2, email);
        pst.setInt(3, age);
        pst.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now())); // ✅ created_at
        pst.setString(5, password);
        pst.setString(6, role);
        pst.setBoolean(7, isActive);  
          
           
           
           
           
           boolean result = pst.execute();
           if(result==false){
               System.out.println("not registerd");
           }
         
           
           
           dbc.con.close();
       }catch(SQLException sqlee){
           System.out.println("Failed Operation:" +sqlee.getMessage());
       }
       
       
   }
   @Override
    public void deleteoperation(int ID){
        DBConnection dbc = new DBConnection();
       try{
        String query="DELETE  FROM employee where employee_id=?";
        PreparedStatement pst = dbc.con.prepareStatement(query);
        pst.setInt(1,ID);
      
          pst.executeUpdate();
         
        dbc.con.close();
       
        
    }catch(SQLException sqlee) {
        
       System.out.println("Delete failed: " + sqlee.getMessage());
    }
}


   @Override
    public void updateOperation(int ID,String Name,String email,int age,LocalDateTime createdat,String password,String role,boolean Status){
    DBConnection dbc = new DBConnection();
       try{
           String query = "Update employee SET full_name=?, email=?, age=?, created_at=?,password=?,role=?,is_active=? WHERE employee_id=?";
           PreparedStatement pst= dbc.con.prepareStatement(query);
           
           
          
           pst.setString(1,Name);
           pst.setString(2,email);
           pst.setInt(3,age);
           pst.setTimestamp(4,Timestamp.valueOf(createdat));
           pst.setString(5,password);
           pst.setString(6,role);
           pst.setBoolean(7,Status);
          
           pst.setInt(8,ID);
          pst.executeUpdate();
         
          
          dbc.con.close();
          
          
       }catch(SQLException sqlee) {

        System.out.println("update failed: " + sqlee.getMessage());   
        
    }
        
       
    }
    
   @Override
     public void selectOperation(int ID){
    DBConnection dbc = new DBConnection();
       try{
           String query = "SELECT * FROM employee WHERE employee_id=?";
           PreparedStatement pst= dbc.con.prepareStatement(query);
           
           
          pst.setInt(1, ID);
          
          
          pst.executeQuery();
          
          dbc.con.close();
          
          
       }catch(SQLException sqlee) {

        System.out.println("Select failed: " + sqlee.getMessage());   
        
    }
        
       
    }
    
}

