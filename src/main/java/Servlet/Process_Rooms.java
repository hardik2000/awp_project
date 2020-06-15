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
 * @author Hardik
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
    int getdiff(String in,String out)
    {
        int ans=1;//2020-06-13	2020-06-16
        int yearin=0,monthin=0,dayin=0,yearout=0,monthout=0,dayout=0;
        int i=0;
        while(in.charAt(i)!='-')
        {
            yearin=yearin*10+in.charAt(i);
            yearout=yearout*10+out.charAt(i);
            i++;
        }
        i++;
        while(in.charAt(i)!='-')
        {
            monthin=monthin*10+in.charAt(i);
            monthout=monthout*10+out.charAt(i);
            i++;
        }
        i++;
        while(i<10)
        {
            dayin=dayin*10+in.charAt(i);
            dayout=dayout*10+out.charAt(i);
            i++;
        }
        ans=(dayout-dayin)+(monthout-monthin)*31+(yearout-yearin)*365;
        return ans;
    }
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
        int price = roomdb.getPriceOfType(room_selected);        
        
        HttpSession session = request.getSession();
        String name = (String)session.getAttribute("sess_name");
        Record r = new Record(name, number_adults, number_children, check_in, check_out,room_no,0);
        session.setAttribute("record",r);
        
        int day=getdiff(check_in,check_out);
        price=price*day;
        getRecord rdb = new getRecord();
        rdb.insertRecord(r);
        roomdb.markBooked(room_no);
        
        request.setAttribute("room_type", room_selected);
        request.setAttribute("price" , price);
        request.getRequestDispatcher("checkout.jsp").forward(request, response);
        
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
