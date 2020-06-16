/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.Room;


public class Database 
{
    public static void main(String args[])
    {
        Database_Feild db=new Database_Feild();
        String driver_string=db.driver_string;
        String db_name=db.db_name;
        String db_username=db.username;
        String db_password=db.password;
        
        try
        {
            Class.forName(driver_string);
            Connection conn=DriverManager.getConnection(db_name,db_username,db_password);
            String sql;
            sql = "Create Table customer(fullname VARCHAR(45),email VARCHAR(45),password VARCHAR(45),dob VARCHAR(45),country VARCHAR(45),gender VARCHAR(45),meal VARCHAR(45));";
            try (PreparedStatement prepStm = conn.prepareStatement(sql)) 
            {
		prepStm.execute();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            sql = "Create Table records(username_booked VARCHAR(45),number_adults int,number_children int,check_in VARCHAR(45),check_out VARCHAR(45),room_no int,approved int);";
            try (PreparedStatement prepStm2 = conn.prepareStatement(sql)) 
            {
		prepStm2.execute();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            sql = "Create Table rooms(room_no INT,room_type VARCHAR(45),price INT,capacity INT,description VARCHAR(100),booked BOOLEAN);";
            try (PreparedStatement prepStm3 = conn.prepareStatement(sql)) 
            {
		prepStm3.execute();
                Data_Room robj = new Data_Room();
                for(Room r: robj.rooms){
                    sql="Insert into rooms(room_no,room_type,price,capacity,description,booked) values(?,?,?,?,?,?);";
                    PreparedStatement pstmt4=conn.prepareStatement(sql);
                    pstmt4.setInt(1, r.getRoom_no());
                    pstmt4.setString(2, r.getType());
                    pstmt4.setInt(3, r.getPrice());
                    pstmt4.setInt(4, r.getCapacity());
                    pstmt4.setString(5, r.getDiscription());
                    pstmt4.setBoolean(6, r.isBooked());
                    pstmt4.executeUpdate();
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }catch(ClassNotFoundException | SQLException ex)
        {
            System.out.println(ex);
        }
        
        
        
    }
    
}
