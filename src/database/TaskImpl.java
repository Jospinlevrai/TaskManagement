/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import java.sql.*;
import java.time.*;
import java.sql.Timestamp;
import java.sql.Date;
/**
 *
 * @author lukog
 */
public class TaskImpl implements DBinserttask,DBselecttask,DBUpdatetask,DBDeletetask {
    
    
    
    
    @Override
 public void inserttask(int task_id,String title,String description,String assigned_to,String status, LocalDate due_date,LocalDateTime created_at,LocalDateTime updated_at){ 
       DBConnection dbc = new DBConnection();
       try{
           String query= "INSERT INTO task(task_id,title,description,assigned_to,status,due_date,created_at,updated_at) VALUES(?,?,?,?,?,?,?,?)";
           
           PreparedStatement pst = dbc.con.prepareStatement(query);
           
           pst.setInt(1,task_id);
           pst.setString(2,title);
           pst.setString(3,description);
           pst.setString(4, assigned_to);
           pst.setString(5,status);
           pst.setDate(6,Date.valueOf(due_date));
           pst.setTimestamp(7,Timestamp.valueOf(created_at));
           pst.setTimestamp(8,Timestamp.valueOf(updated_at));
           
          
           
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
    public void deletetask(String task_id){
        DBConnection dbc = new DBConnection();
       try{
        String query="DELETE  FROM task where task_id=?";
        PreparedStatement pst = dbc.con.prepareStatement(query);
        pst.setString(1,task_id);
      
          pst.executeUpdate();
         
        dbc.con.close();
       
        
    }catch(SQLException sqlee) {
        
       System.out.println("Delete failed: " + sqlee.getMessage());
    }
}


   @Override
    public void updatetask(int task_id,String title,String description,String assigned_to,String status, LocalDate due_date,LocalDateTime created_at,LocalDateTime updated_at){
    DBConnection dbc = new DBConnection();
       try{
           String query = "Update task SET title=?,description=?,status=?,due_date=?,created_at=?,update_at=? WHERE task_id=?";
           PreparedStatement pst= dbc.con.prepareStatement(query);
           
           
           
           pst.setString(1,title);
           pst.setString(2,description);
           pst.setString(3, assigned_to);
           pst.setString(4,status);
           pst.setDate(5,Date.valueOf(due_date));
           pst.setTimestamp(6,Timestamp.valueOf(created_at));
           pst.setTimestamp(7,Timestamp.valueOf(updated_at));
           pst.setInt(8,task_id);
           
           
           
           pst.executeUpdate();
         
          
          dbc.con.close();
          
          
       }catch(SQLException sqlee) {

        System.out.println("Select failed: " + sqlee.getMessage());   
        
    }
        
       
    }
    
   @Override
     public void selecttask(int task_id){
    DBConnection dbc = new DBConnection();
       try{
           String query = "SELECT * FROM task WHERE task_id=?";
           PreparedStatement pst= dbc.con.prepareStatement(query);
           
           
          pst.setInt(1, task_id);
          
          ResultSet rs = pst.executeQuery();
          
          
          
          while(rs.next()){

                System.out.println("Task ID: "+ rs.getInt("task_id"));

                System.out.println("Title: "+ rs.getString("title"));

                System.out.println("Description: "+ rs.getString("description"));

                System.out.println("Assigned To: "+ rs.getString("assigned_to"));

                System.out.println("Status: "+ rs.getString("status"));

                System.out.println("Due Date: "+ rs.getDate("due_date"));
            }
          dbc.con.close();
          
          
       }catch(SQLException sqlee) {

        System.out.println("Select failed: " + sqlee.getMessage());   
        
    }
        
       
    }
    
}
