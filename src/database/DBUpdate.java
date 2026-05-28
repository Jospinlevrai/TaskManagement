/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.time.LocalDateTime;


/**
 *
 * @author lukog
 */
public interface DBUpdate {
    public void updateOperation(int ID,String Name,String email,int age,LocalDateTime createdat,String password,String role,boolean Status);
}
   

