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
public class TaskImpl implements DBinserttask,DBselecttask,DBUpdatetask,DBDeletetask,DBOpro {
    
    
    
    
    @Override
 public void inserttask(Task task){ 
       DBConnection dbc = new DBConnection();
       try{
           String query= "INSERT INTO task(task_id,title,description,assigned_to,status,due_date,created_at,updated_at) VALUES(?,?,?,?,?,?,?,?)";
           
           PreparedStatement pst = dbc.con.prepareStatement(query);
           
            pst.setInt(1, task.getTaskId());
            pst.setString(2, task.getTitle());
            pst.setString(3, task.getDescription());
            pst.setString(4, task.getAssignedTo());
            pst.setString(5, task.getStatus());
            pst.setDate(6, Date.valueOf(task.getDueDate()));
            pst.setTimestamp(7, Timestamp.valueOf(task.getCreatedAt()));
            pst.setTimestamp(8, Timestamp.valueOf(task.getUpdatedAt()));
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
    public void updatetask(int task_id, Task task){
    DBConnection dbc = new DBConnection();
       try{
           String query = "Update task SET title=?,description=?,status=?,due_date=?,created_at=?,update_at=? WHERE task_id=?";
           PreparedStatement pst= dbc.con.prepareStatement(query);
           
           pst.setString(1, task.getTitle());
           pst.setString(2, task.getDescription());
           pst.setString(3, task.getAssignedTo());
           pst.setString(4, task.getStatus());
           pst.setDate(5, Date.valueOf(task.getDueDate()));
           pst.setTimestamp(6, Timestamp.valueOf(task.getCreatedAt()));
           pst.setTimestamp(7, Timestamp.valueOf(task.getUpdatedAt()));
           pst.setInt(8, task_id);
           
           
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
    @Override
     public void updatepro(int task_id,String status){
    DBConnection dbc = new DBConnection();
       try{
           String query = "Update task SET status=?,update_at=? WHERE task_id=?";
           PreparedStatement pst= dbc.con.prepareStatement(query);
           
           
           
           pst.setString(1,status);
          
           pst.setTimestamp(2,Timestamp.valueOf(LocalDateTime.now()));
           pst.setInt(3,task_id);
           
           pst.executeUpdate();
         
          
          dbc.con.close();
          
          
       }catch(SQLException sqlee) {

        System.out.println("Select failed: " + sqlee.getMessage());   
        
    }
        
       
    }
    
    
}
