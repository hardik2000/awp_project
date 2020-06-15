<%-- 
    Document   : newjsp
    Created on : 15 Jun, 2020, 1:40:34 PM
    Author     : HARDIK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
    String s = (String)request.getSession().getAttribute("sess_name"); 
    try{  
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/awp","root","root");  
        PreparedStatement ps=con.prepareStatement("select * from records where username=?"); 
        ps.setString(1,s);  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            if(rs.getInt("approved")==1){
                out.println("Room has been approved by our staff.Room number alloted:" + rs.getInt("room_no"));
            }else{
                out.println("Status:Pending for room "+ rs.getInt("room_no") +"is pending<br>");
            }
        }
        con.close();  
    }catch(Exception e){out.println("Some error occured with our servers.Please try later.<br>");}  
%>