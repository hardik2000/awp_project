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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
            try
            {
                String username ;
                String password;
                String id,pass;
                username = request.getParameter("email");
                password = request.getParameter("password");
                if(username.equals("Admin@gmail.com") && password.equals("Admin@123"))
                {
                    HttpSession session = request.getSession();
                    session.setAttribute("sess_name","ADMIN");
                    response.sendRedirect("admin.jsp");
                }
                else
                {
                    Database_Feild db=new Database_Feild();
                    String driver_string=db.driver_string;
                    String db_name=db.db_name;
                    String db_username=db.username;
                    String db_password=db.password;
                    int flg=0;
                    Class.forName(driver_string);
                    try (Connection conn = DriverManager.getConnection(db_name,db_username,db_password)) 
                    {
                        PreparedStatement ps=conn.prepareStatement("SELECT * FROM customer;");
                        ResultSet result=ps.executeQuery();
                        while (result.next())
                        {
                            id=result.getString(2);
                            pass=result.getString(3);
                            if(pass.equals(password) && id.equals(username))
                            {
                                flg=1;
    //                          Customer customer=new Customer();
    //                          customer.setFullname(result.getString(1));
    //                          customer.setEmail(id);
    //                          customer.setPassword(pass);
    //                          customer.setDob(result.getString(4));
    //                          customer.setCountry(result.getString(5));
    //                          customer.setGender(result.getString(6));
    //                          customer.setMeal(result.getString(7));
                                HttpSession session = request.getSession();
                                session.setAttribute("sess_name",result.getString(1));
                                RequestDispatcher rd=request.getRequestDispatcher("rooms.jsp");  
                                rd.forward(request,response);
                            }
                        }
                        if(flg==0)
                        {
                            response.sendRedirect("error_login.jsp");
                        }
                    }
                }
                }catch(IOException | ClassNotFoundException | SQLException e)
                {
                    response.sendRedirect("error_login.jsp");
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
