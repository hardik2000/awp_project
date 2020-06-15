<%-- 
    Document   : newjsp
    Created on : 15 Jun, 2020, 1:40:34 PM
    Author     : HARDIK
--%>

<%@page import="data.Database_Feild"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
    String s = (String)request.getSession().getAttribute("sess_name"); 
    try{  
        Database_Feild db=new Database_Feild();
        String driver_string=db.driver_string;
        String db_name=db.db_name;
        String db_username=db.username;
        String db_password=db.password;
        Class.forName(driver_string);
        Connection conn=DriverManager.getConnection(db_name,db_username,db_password);
        PreparedStatement ps=conn.prepareStatement("select * from records where username_booked=?"); 
        ps.setString(1,s);  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            if(rs.getInt("approved")==1){
                out.println("Room has been approved by our staff.Room number alloted:" + rs.getInt("room_no") + "<br>");
            }else{
                out.println("Status:Pending for room "+ rs.getInt("room_no") +"is pending<br>");
            }
        }
        conn.close();  
    }catch(Exception e){out.println("Some error occured with our servers.Please try later.<br>");}  
%>