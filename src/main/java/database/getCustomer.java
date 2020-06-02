/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
        
import data.Database_Feild;
import domain.Customer;
/**
 *
 * @author aditya
 */
public class getCustomer {
    
    Database_Feild db=new Database_Feild();
    
    public boolean insertCustomer(Customer customer){ 
        try {
            Class.forName(db.driver_string);
            Connection conn=DriverManager.getConnection(db.db_name,db.username,db.password);
            String query="Insert into customer(fullname,email,password,dob,country,gender,meal) values(?,?,?,?,?,?,?);";
            PreparedStatement pstmt=conn.prepareStatement(query);
            pstmt.setString(1, customer.getFullname());
            pstmt.setString(2, customer.getEmail());
            pstmt.setString(3, customer.getPassword());
            pstmt.setString(4, customer.getDob());
            pstmt.setString(5, customer.getCountry());
            pstmt.setString(6, customer.getGender());
            pstmt.setString(7, customer.getMeal());
            pstmt.executeUpdate();
            return true;
        }catch(ClassNotFoundException | SQLException ex)
        {
            return false;
        }  
    }
    
    
}
