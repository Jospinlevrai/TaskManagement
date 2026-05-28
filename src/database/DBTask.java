/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import java.time.*;
/**
 *
 * @author lukog
 */
public class DBTask {
    public void inserttask(int task_id,String title,String description,String assigned_to,String status,LocalDate due_date,LocalDateTime created_at,LocalDateTime updated_at){
        DBinserttask dbo = new TaskImpl();
        
        dbo.inserttask(task_id, title, description,assigned_to, status, due_date, created_at, updated_at);
    }
    public void deletetask(String task_id){
        DBDeletetask dbo = new TaskImpl();
        
       dbo.deletetask(task_id);
    }
    public void updatetask(int task_id,String title,String description,String assigned_to,String status, LocalDate due_date,LocalDateTime created_at,LocalDateTime updated_at){
        DBUpdatetask dbo = new TaskImpl();
        
        dbo.updatetask(task_id, title, description,assigned_to, status, due_date, created_at, updated_at);
    }
    public void selecttask(int task_id){
        DBselecttask dbo = new TaskImpl();
        
        dbo.selecttask(task_id);
        
    }
}
