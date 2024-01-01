/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.EmployeeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Employee;

/**
 *
 * @author Vivek Uprit
 */
public class searchDeleteData extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try 
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet searchData</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
               int id;
               id=Integer.parseInt(request.getParameter("txtid"));
               EmployeeDAO ed=new EmployeeDAO();
               Employee E=null;
               E=ed.searchById(id);
               if(E==null)
                   out.println("<font color=red size=5>Record not found</font>");
               else
               {    
                  out.println("<table border=1>");
                   out.println("<font color=green size=5>Employee Data</font>");
                  out.println("<tr><th>Emp Id</th><th>Emp Name</th><th>Salary</th><th>Department</th></tr>");
                  out.println("<tr>");
                  out.println("<td>"+ E.getEmpid() +"</td>");
                  out.println("<td>"+ E.getEmpname()+"</td>");
                  out.println("<td>"+ E.getEmpsalary()+"</td>");
                  out.println("<td>"+ E.getEmpdept()+"</td>");
                  HttpSession session=request.getSession(true);
                  session.setAttribute("empid",id);
                  out.println("<form method=post action=DeleteRecord>");
                  out.println("<td><input type=submit value=delete></td>");
                  out.println("</form>");
                  out.println("</tr>");
                  out.println("</table>");
               }    
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e)
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
     //   processRequest(request, response);
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

    
   
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
