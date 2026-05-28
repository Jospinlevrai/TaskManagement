
package database;

import java.time.LocalDateTime;


public class DBOperations {
    public void insertoperation(String Name, String email, int age, String password, String role, boolean isActive){
        
        DBinsert dbo= new DBOperationImpl();
        dbo.insertoperation( Name, email, age, password, role,isActive);
    }
    public void updateOperation(int ID,String Name,String email,int age,LocalDateTime createdat,String password,String role,boolean Status){
    DBUpdate dbo = new DBOperationImpl();
    
    dbo.updateOperation(ID, Name, email, age, createdat, password, role, Status);
    
}
    public void deleteoperation(int ID){
        DBDelete dbo = new DBOperationImpl();
    
    dbo.deleteoperation(ID);
    }
    public void selectOperation(int ID){
         DBSelect dbo = new DBOperationImpl();
         
         dbo.selectOperation(ID);
        
        
    }

 
    
}

