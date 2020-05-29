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
import domain.Record;
/**
 *
 * @author aditya
 */
public class getRecord {

    Database_Feild db=new Database_Feild();
    
    public boolean insertRecord(Record record){ 
        try{
            Class.forName(db.driver_string);
            Connection conn=DriverManager.getConnection(db.db_name,db.username,db.password);

            PreparedStatement ps = conn.prepareStatement("INSERT INTO records(username_booked,number_adults,number_children,check_in,check_out,room_no) VALUES(?,?,?,?,?,?)");
            ps.setString(1,record.getUsername_booked());
            ps.setString(2,record.getNumber_adults());
            ps.setString(3,record.getNumber_children());
            ps.setString(4,record.getDate_booking());
            ps.setString(5,record.getDate_checkout());
            ps.setInt(6,record.getRoom_no());
            ps.executeUpdate();
        }catch(ClassNotFoundException | SQLException ex)
        {
            return false;
        }
        return true;
    }    
}
