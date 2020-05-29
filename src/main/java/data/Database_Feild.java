/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author HARDIK
 */
public class Database_Feild 
{

    public String driver_string;
    public String db_name; 
    public String username;
    public String password;

    public Database_Feild() {
        driver_string = "com.mysql.cj.jdbc.Driver";
        db_name="jdbc:mysql://localhost:3306/awp";
        username="root";
        password="root";
    }
}
