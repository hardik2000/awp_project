/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;
import domain.Customer;
import data.Database_Feild;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HARDIK
 */
public class Check extends HttpServlet {

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
            String username ;
            username =  request.getParameter("email");
            String password;
            String id,pass;
            password = request.getParameter("password");
             Database_Feild db=new Database_Feild();
            String driver_string=db.driver_string;
            String db_name=db.db_name;
            String db_username=db.username;
            String db_password=db.password;
            try
            {
                Class.forName(driver_string);
                Connection conn=DriverManager.getConnection(db_name,db_username,db_password);
                PreparedStatement ps=conn.prepareStatement("SELECT * FROM Costumer;");
                ResultSet result=ps.executeQuery();
                while (result.next()) 
                {
                    id=result.getString(2);
                    pass=result.getString(3);
                    if(id.equals(username) && pass.equals(password))
                    {
                            try
                            {
                                Customer costumer=new Customer();
                                costumer.setFullname(result.getString(1));
                                costumer.setEmail(id);
                                costumer.setPassword(pass);
                                costumer.setDob(result.getString(4));
                                costumer.setCountry(result.getString(5));
                                costumer.setGender(result.getString(6));
                                costumer.setMeal(result.getString(7));
                                
                                response.sendRedirect("index.jsp");
                            }
                            catch(Exception e)
                            {
                            
                            }
                    }
                    else
                    {
                            try
                            {
                                response.sendRedirect("error_login.html");
                            }
                            catch(Exception e)
                            {
                            
                            }

                    }
                }
            }
            catch(SQLException | ClassNotFoundException err)
            {
                
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
