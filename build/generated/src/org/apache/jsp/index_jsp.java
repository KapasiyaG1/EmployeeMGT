package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.ArrayList;
import model.Employee;
import dao.EmployeeDAO;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 
  EmployeeDAO ed = new EmployeeDAO();
  Employee E=new Employee();

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    \n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("    <title>Employe</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <header>\n");
      out.write("        <h1 id=\"mianHeading\">Employee Data List</h1>\n");
      out.write("        <a href=\"InsertEmployee.html\"><button type=\"button\">Create New Employee</button></a> \n");
      out.write("        <a href=\"SearchbyId.html\"><button type=\"button\">Delete</button></a>\n");
      out.write("        <a href=\"updateById.html\"><button type=\"button\">Edit</button></a>\n");
      out.write("    </header>\n");
      out.write("    <main>\n");
      out.write("        <section id=\"table_sec\">\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Employee Id</th>\n");
      out.write("                    <th>Employee Name</th>\n");
      out.write("                    <th>Employee Salary</th>\n");
      out.write("                    <th>Employee Department</th>\n");
      out.write("                    <th>Employee E-Mail</th>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    List<Employee> mylist = new ArrayList<>();
                    mylist=ed.searchAll();
                    for(Employee E:mylist){
                  out.println("<tr>");    
                  out.println("<td>"+E.getEmpid()+"<input type=\"hidden\" name=\"empid\" value="+E.getEmpid()+"></td>"); 
                  int id=E.getEmpid();
            
                 session.setAttribute("empid", id);
                  out.println("<td>"+E.getEmpname()+"</td>");
                  out.println("<td>"+E.getEmpsalary()+"</td>");
                  out.println("<td>"+E.getEmpdept()+"</td>");
                  out.println("<td>"+E.getEmpmail()+" </td>");
                  
                  //out.println("<a href=\"UpdateDataDisplay\"><button type=\"button\">Edit</button></a>");
                  //out.println("<a href=\"insertdata\"><button type=\"button\">Delete</button></a>");     
                 
                  out.println("</tr>");
                  out.println("<tr>");
                    }
                
      out.write("        \n");
      out.write("            </table>\n");
      out.write("        </section>\n");
      out.write("    </main>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
