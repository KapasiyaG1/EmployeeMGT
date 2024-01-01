<%-- 
    Document   : index
    Created on : Nov 12, 2022, 6:43:28 PM
    Author     : sahab
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Employee"%>
<%@page import="dao.EmployeeDAO"%>

    
<%! 
  EmployeeDAO ed = new EmployeeDAO();
  Employee E=new Employee();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Employe</title>
</head>
<body>
    <header>
        <h1 id="mianHeading">Employee Data List</h1>
        <a href="InsertEmployee.html"><button type="button">Create New Employee</button></a> 
        <a href="SearchbyId.html"><button type="button">Delete</button></a>
        <a href="updateById.html"><button type="button">Edit</button></a>
    </header>
    <main>
        <section id="table_sec">
            <table>
                <tr>
                    <th>Employee Id</th>
                    <th>Employee Name</th>
                    <th>Employee Salary</th>
                    <th>Employee Department</th>
                    <th>Employee E-Mail</th>
                </tr>
                <%
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
                %>        
            </table>
        </section>
    </main>
</body>
</html>
