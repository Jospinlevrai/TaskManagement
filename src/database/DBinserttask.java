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
public interface DBinserttask {
    public void inserttask(int task_id,String title,String description,String assigned_to,String status, LocalDate due_date,LocalDateTime created_at,LocalDateTime updated_at);
}
