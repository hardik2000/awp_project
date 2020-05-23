/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import data.Database_Feild;
import domain.Customer;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HARDIK
 */
public class Insert_costumer extends HttpServlet {

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
            throws ServletException, IOException
    {
        try
        {
            Customer customer=new Customer();
            customer.setFullname(request.getParameter("firstName"));
            customer.setEmail(request.getParameter("email"));
            customer.setPassword(request.getParameter("password"));
            customer.setDob(request.getParameter("birthDate"));
            customer.setCountry(request.getParameter("country"));
            customer.setGender(request.getParameter("gender"));
            customer.setMeal(request.getParameter("meal"));
            Database_Feild db=new Database_Feild();
            String driver_string=db.driver_string;
            String db_name=db.db_name;
            String db_username=db.username;
            String db_password=db.password;
            Class.forName(driver_string);
            Connection conn=DriverManager.getConnection(db_name,db_username,db_password);
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
            response.sendRedirect("index.jsp");
        }catch(ClassNotFoundException | SQLException ex)
        {
            response.sendRedirect("registration.jsp");
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
