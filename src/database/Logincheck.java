/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;


import java.sql.*;
/**
 *
 * @author lukog
 */
public class Logincheck {
    public Employee checklogin(String email,String password){
    DBConnection dbc = new DBConnection();
    Employee employee = null;
       try{
           String query = "SELECT * FROM employee WHERE email=? AND password=?";

           PreparedStatement pst = dbc.con.prepareStatement(query);
           pst.setString(1, email);
           pst.setString(2, password);
           ResultSet rs = pst.executeQuery();
           
           if(rs.next()){
           employee = new Employee(
           rs.getInt("employee_id"),
           rs.getString("full_name"),
           rs.getString("email"),
           rs.getInt("age"),
           rs.getString("password"),
           rs.getString("role"),
           rs.getBoolean("is_active"),
           rs.getTimestamp("created_at").toLocalDateTime()
           );
           
           }
        
          
          dbc.con.close();
          
          
       }catch(SQLException sqlee) {

        System.out.println("Select failed: " + sqlee.getMessage());   
        
    }
        return employee;
       
    }
}
