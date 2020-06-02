package Servlet;

import database.*;

import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import domain.*;
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
        String room_selected = request.getParameter("room_type");
        
        getRoom roomdb = new getRoom();
        int room_no = roomdb.getRoomOfType(room_selected);        
        
        HttpSession session = request.getSession();
        String name = (String)session.getAttribute("sess_name");
        Record r = new Record(name, number_adults, number_children, check_in, check_out,room_no);
        session.setAttribute("record",r);
        
        getRecord rdb = new getRecord();
        rdb.insertRecord(r);
        roomdb.markBooked(room_no);
        
        RequestDispatcher rd=request.getRequestDispatcher("checkout.jsp");  
        rd.forward(request,response);
        
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
