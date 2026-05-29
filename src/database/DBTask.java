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
   public void inserttask(Task task) {
    DBinserttask dbo = new TaskImpl();
    dbo.inserttask(task);
   }
    public void deletetask(String task_id){
        DBDeletetask dbo = new TaskImpl();
        
       dbo.deletetask(task_id);
    }
    public void updatetask(int task_id, Task task) {
    DBUpdatetask dbo = new TaskImpl();
    dbo.updatetask(task_id, task);
}
    public void selecttask(int task_id){
        DBselecttask dbo = new TaskImpl();
        
        dbo.selecttask(task_id);
        
    }
    
}
