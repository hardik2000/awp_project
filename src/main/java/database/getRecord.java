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
/**/import data.Database_Feild;
import domain.Record;
import java.sql.ResultSet;

public class getRecord {

    Database_Feild db=new Database_Feild();
    
    public boolean insertRecord(Record record){ 
        try{
            Class.forName(db.driver_string);
            Connection conn=DriverManager.getConnection(db.db_name,db.username,db.password);

            PreparedStatement ps = conn.prepareStatement("INSERT INTO records(username_booked,number_adults,number_children,check_in,check_out,room_no,approved) VALUES(?,?,?,?,?,?,?)");
            ps.setString(1,record.getUsername_booked());
            ps.setString(2,record.getNumber_adults());
            ps.setString(3,record.getNumber_children());
            ps.setString(4,record.getDate_booking());
            ps.setString(5,record.getDate_checkout());
            ps.setInt(6,record.getRoom_no());
            ps.setInt(7,record.isApproved());
            ps.executeUpdate();
        }catch(ClassNotFoundException | SQLException ex)
        {
            return false;
        }
        return true;
    }
    
    public String getCutomer(int room_no){ 
        String name= "admin";
        try{
            Class.forName(db.driver_string);
            Connection conn=DriverManager.getConnection(db.db_name,db.username,db.password);

            String query = "SELECT * FROM records WHERE room_no=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, Integer.toString(room_no));
            ResultSet rs1 = pstmt.executeQuery();
            while(rs1.next()){
                name=rs1.getString("username_booked");
                break;
            }
        }catch(ClassNotFoundException | SQLException ex)
        {
            return name;
        }
        return name;
    }

    public  void deleteRecord(String username){ 
        try{
            Class.forName(db.driver_string);
            Connection conn=DriverManager.getConnection(db.db_name,db.username,db.password);

            PreparedStatement ps = conn.prepareStatement("DELETE FROM records WHERE username_booked = ?");
            ps.setString(1,username);
            ps.executeUpdate();
        }catch(ClassNotFoundException | SQLException ex)
        {
            System.out.println("username not deleted");
        }
    }
    
    public  void deleteRecord(int room_no){ 
        try{
            Class.forName(db.driver_string);
            Connection conn=DriverManager.getConnection(db.db_name,db.username,db.password);

            PreparedStatement ps = conn.prepareStatement("DELETE FROM records WHERE room_no = ?");
            ps.setInt(1,room_no);
            ps.executeUpdate();
        }catch(ClassNotFoundException | SQLException ex)
        {
            System.out.println("username not deleted");
        }
    }
    
    public int isApproved(int room_no){ 
        int approved=0;
        try{
            Class.forName(db.driver_string);
            Connection conn=DriverManager.getConnection(db.db_name,db.username,db.password);

            String query = "SELECT * FROM records WHERE room_no=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, Integer.toString(room_no));
            ResultSet rs1 = pstmt.executeQuery();
            while(rs1.next()){
                approved=rs1.getInt("approved");
                break;
            }
        }catch(ClassNotFoundException | SQLException ex)
        {
            return approved;
        }
        return approved;
    }
    
    public void Approve(int room_no){ 
        try{ 
            Class.forName(db.driver_string);
            Connection conn=DriverManager.getConnection(db.db_name,db.username,db.password);
            String query = "UPDATE records SET approved=? WHERE room_no=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 1);
            pstmt.setInt(2, room_no);
            pstmt.execute();

        }catch(ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
    }
}
