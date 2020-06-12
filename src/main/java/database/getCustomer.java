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
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;        

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
    
    public ArrayList<Customer> getAllCustomers(){ 
        
        ArrayList<Customer> clist = new ArrayList<Customer>();
        
        try {
            
            Class.forName(db.driver_string);
            Connection conn=DriverManager.getConnection(db.db_name,db.username,db.password);
            Statement stmt = conn.createStatement();
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM customer");
            while(rs1.next())
            {
                clist.add(new Customer(rs1.getString(1),rs1.getString(2),rs1.getString(3),rs1.getString(4),rs1.getString(5),rs1.getString(6),rs1.getString(7)));
            }
            
        }catch(ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
        return clist;
    }
}
