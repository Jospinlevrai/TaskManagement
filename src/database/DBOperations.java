
package database;

import java.time.LocalDateTime;


public class DBOperations {
    public void insertoperation(Employee employee) {
    DBinsert dbo = new DBOperationImpl();
    dbo.insertoperation(employee);
    }

    public void updateOperation(int ID, Employee employee) {
    DBUpdate dbo = new DBOperationImpl();
    dbo.updateOperation(ID, employee);
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

