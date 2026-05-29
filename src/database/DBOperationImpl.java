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
   public void insertoperation(Employee employee) {
    DBConnection dbc = new DBConnection();
    try {
        String query = "INSERT INTO employee(full_name, email, age, created_at, password, role, is_active) "
                     + "VALUES(?,?,?,?,?,?,?)";

        PreparedStatement pst = dbc.con.prepareStatement(query);

        pst.setString(1, employee.getFullName());
        pst.setString(2, employee.getEmail());
        pst.setInt(3, employee.getAge());
        pst.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
        pst.setString(5, employee.getPassword());
        pst.setString(6, employee.getRole());
        pst.setBoolean(7, employee.isActive());
        
        pst.execute();  
           
           
           
           
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
    public void updateOperation(int ID,Employee employee){
    DBConnection dbc = new DBConnection();
       try{
           String query = "Update employee SET full_name=?, email=?, age=?, created_at=?,password=?,role=?,is_active=? WHERE employee_id=?";
           PreparedStatement pst= dbc.con.prepareStatement(query);
           
        
        pst.setString(1, employee.getFullName());
        pst.setString(2, employee.getEmail());
        pst.setInt(3, employee.getAge());
        pst.setTimestamp(4, Timestamp.valueOf(employee.getCreatedAt()));
        pst.setString(5, employee.getPassword());
        pst.setString(6, employee.getRole());
        pst.setBoolean(7, employee.isActive());
        pst.setInt(8, ID);
        
          
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

