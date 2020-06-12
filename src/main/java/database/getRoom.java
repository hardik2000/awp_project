/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
        
import data.Database_Feild;
import domain.Room;
/**
 *
 * @author aditya
 */
public class getRoom {
    Database_Feild db=new Database_Feild();
    
    public ArrayList<Room> getAllRooms(){ 
        
        ArrayList<Room> roomlist = new ArrayList<Room>();
        
        try {
            
            Class.forName(db.driver_string);
            Connection conn=DriverManager.getConnection(db.db_name,db.username,db.password);
            Statement stmt = conn.createStatement();
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM rooms");
            while(rs1.next())
            {
                roomlist.add(new Room(rs1.getInt(1),rs1.getString(2),rs1.getInt(4),rs1.getInt(3),rs1.getString(5),rs1.getBoolean(6)));
            }
            
        }catch(ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
        return roomlist;
    }
    
    public ArrayList<Room> getBookedRooms(){ 
        
        ArrayList<Room> roomlist = new ArrayList<Room>();
        
        try {
            
            Class.forName(db.driver_string);
            Connection conn=DriverManager.getConnection(db.db_name,db.username,db.password);
            Statement stmt = conn.createStatement();
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM rooms WHERE booked = true");
            while(rs1.next())
            {
                roomlist.add(new Room(rs1.getInt(1),rs1.getString(2),rs1.getInt(4),rs1.getInt(3),rs1.getString(5),rs1.getBoolean(6)));
            }
            
        }catch(ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
        return roomlist;
    }
    
    public ArrayList<Room> getUnBookedRooms(){ 
        
        ArrayList<Room> roomlist = new ArrayList<Room>();
        
        try {
            
            Class.forName(db.driver_string);
            Connection conn=DriverManager.getConnection(db.db_name,db.username,db.password);
            Statement stmt = conn.createStatement();
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM rooms WHERE booked = true");
            while(rs1.next())
            {
                roomlist.add(new Room(rs1.getInt(1),rs1.getString(2),rs1.getInt(4),rs1.getInt(3),rs1.getString(5),rs1.getBoolean(6)));
            }
            
        }catch(ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
        return roomlist;
    }
    
    public int getRoomOfType(String type){
        
        int room_no=-1;
        try {
            Class.forName(db.driver_string);
            Connection conn=DriverManager.getConnection(db.db_name,db.username,db.password);
            
            String query = "SELECT * FROM rooms WHERE room_type=? AND booked=0";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, type);
            ResultSet rs1 = pstmt.executeQuery();
            while(rs1.next()){
                room_no=rs1.getInt("room_no");
                break;
            }
        }catch(ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
        return room_no;
    }
    public int getPriceOfType(String type)
    {
        int room_price=0;
        try {
            Class.forName(db.driver_string);
            Connection conn=DriverManager.getConnection(db.db_name,db.username,db.password);
            
            String query = "SELECT * FROM rooms WHERE room_type=? AND booked=0";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, type);
            ResultSet rs1 = pstmt.executeQuery();
            while(rs1.next()){
                room_price=rs1.getInt("price");
                break;
            }
        }catch(ClassNotFoundException | SQLException e)
        {
        }
        return room_price;
    }
    public void markBooked(int room_no){
        try {
            
            Class.forName(db.driver_string);
            Connection conn=DriverManager.getConnection(db.db_name,db.username,db.password);
            String query = "UPDATE rooms SET booked=1 WHERE room_no=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, room_no);
            pstmt.execute();
        }catch(ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    public void updatePrice(String room_type,int price){
        try {
            
            Class.forName(db.driver_string);
            Connection conn=DriverManager.getConnection(db.db_name,db.username,db.password);
            String query = "UPDATE rooms SET price=? WHERE room_type=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, price);
            pstmt.setString(2, room_type);
            pstmt.execute();
        }catch(ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
    }
}
