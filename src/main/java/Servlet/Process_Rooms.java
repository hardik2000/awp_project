/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import data.Database_Feild;
import domain.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import domain.Record;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author Hardik Pandya
 */
public class Process_Rooms extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String check_in = request.getParameter("check_in");
        String check_out = request.getParameter("check_out");
        String number_adults = request.getParameter("number_adults");
        String number_children = request.getParameter("number_children");
        String room_selected = "";
        if(request.getParameter("room_1")!=null){
            room_selected = "Luxury Double Suite";
        }
        else if(request.getParameter("room_2")!=null){
            room_selected = "Luxury Single Room";
        }
        else if(request.getParameter("room_3")!=null){
            room_selected = "Budget Suite";
        }
        HttpSession session = request.getSession();
        String name = (String)session.getAttribute("sess_name");
        Record r = new Record(name, number_adults, number_children, check_in, check_out,room_selected);
        session.setAttribute("record",r);
        
        
        Database_Feild db=new Database_Feild();
        String driver_string=db.driver_string;
        String db_name=db.db_name;
        String db_username=db.username;
        String db_password=db.password;
        
        PrintWriter out = response.getWriter();
        
        try{
            Class.forName(driver_string);
            Connection conn = null;
            PreparedStatement ps = null;
            conn=DriverManager.getConnection(db_name,db_username,db_password);

            ps = conn.prepareStatement("INSERT INTO records(username_booked,number_adults,number_children,check_in,check_out,room_type) VALUES(?,?,?,?,?,?)");
            ps.setString(1,name);
            ps.setString(2,number_adults);
            ps.setString(3,number_children);
            ps.setString(4,check_in);
            ps.setString(5,check_out);
            ps.setString(6,room_selected);
            ps.executeUpdate();
            RequestDispatcher rd=request.getRequestDispatcher("checkout.jsp");  
            rd.forward(request,response);
        }catch(ClassNotFoundException | SQLException e){
            out.println(e);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
