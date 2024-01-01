
package dao;
import connect.MyConnection;
import java.sql.*;
import java.util.*;
import model.Employee;

public class EmployeeDAO 
{
    public boolean checkLogin(String username,String password) throws Exception
    {
           String sql;
            Connection con=null;
            PreparedStatement ps=null;
            ResultSet rs=null;
            con=MyConnection.getConnection();
           sql="select * from login where username=? and password=?";
           ps=con.prepareStatement(sql);
           ps.setString(1,username);
           ps.setString(2,password);
           rs=ps.executeQuery();
           if(rs.next())
               return true;
        
           return false;
    }
    
    public static int autoIncr() throws Exception
    {
        String sql;
            Connection con=null;
            PreparedStatement ps=null;
            ResultSet rs=null;
            con=MyConnection.getConnection();
            int id=101;
            sql="select max(empid) from employee";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs.next())
            {
                  id=rs.getInt(1);
                  id++;
            }
        
        return(id);
    }
    
    
    public boolean updateStudent(Employee e) throws Exception
    {
    
        String sql;
            Connection con=null;
            PreparedStatement ps=null;
            con=MyConnection.getConnection();
            sql="update employee set empname=?,empsalary=?,empdept=?,empmail=? where empid=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, e.getEmpname());
            ps.setInt(2, e.getEmpsalary());
            ps.setString(3, e.getEmpdept());
            ps.setString(4, e.getEmpmail());
            ps.setInt(5, e.getEmpid());
            if(ps.executeUpdate()>0)
                return true;
            return false;
        
    }
    
    public boolean insertStudent(Employee e) throws Exception    
      {
            String sql;
            Connection con=null;
            PreparedStatement ps=null;
            con=MyConnection.getConnection();
            sql="insert into employee values(?,?,?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setInt(1, e.getEmpid());
            ps.setString(2, e.getEmpname());
            ps.setInt(3, e.getEmpsalary());
            ps.setString(4, e.getEmpdept());
            ps.setString(5, e.getEmpmail());
            if(ps.executeUpdate()>0)
                return true;
            return false;
      }       
      
      public boolean deleteById(int id) throws Exception
      {
            String sql;
            Connection con=null;
            PreparedStatement ps=null;
            con=MyConnection.getConnection(); 
            sql="delete from employee where empid=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            if(ps.executeUpdate()>0)
                return true;
            
        return false;
      }
      
      
      public Employee searchById(int id) throws Exception
      {
            String sql;
            Connection con=null;
            PreparedStatement ps=null;
            ResultSet rs=null;
            con=MyConnection.getConnection(); 
            sql="select * from employee where empid=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            Employee E=new Employee();
           if(rs.next()) 
           {    
             E.setEmpid(rs.getInt(1));
             E.setEmpname(rs.getString(2));
             E.setEmpsalary(rs.getInt(3));
             E.setEmpdept(rs.getString(4));
           }
           else
              E=null;
           
         return E; 
      }
    public List<Employee> searchAll() throws Exception
    {
            String sql;
            Connection con=null;
            PreparedStatement ps=null;
            ResultSet rs=null;
            con=MyConnection.getConnection(); 
            sql="select * from employee";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            List<Employee> mylist=new ArrayList<Employee>();
            while(rs.next())
            {
                Employee E=new Employee();
                E.setEmpid(rs.getInt(1));
                E.setEmpname(rs.getString(2));
                E.setEmpsalary(rs.getInt(3));
                E.setEmpdept(rs.getString(4));
                E.setEmpmail(rs.getString(5));
                mylist.add(E);
                E=null;
            }
            
          return(mylist);
    }
      
}
