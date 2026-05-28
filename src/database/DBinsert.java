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
public interface DBinsert {
    public void insertoperation(String Name,String email,int age,String password,String role, boolean isActive);
}
