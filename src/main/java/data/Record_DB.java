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

/**
 *
 * @author Hadik Pandya
 */
public class Record_DB
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
            sql = "Create Table records(username_booked VARCHAR(45),number_adults VARCHAR(45),number_children VARCHAR(45),check_in VARCHAR(45),check_out VARCHAR(45),room_type VARCHAR(45));";
            try (PreparedStatement prepStm = conn.prepareStatement(sql)) 
            {
		prepStm.execute();
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
