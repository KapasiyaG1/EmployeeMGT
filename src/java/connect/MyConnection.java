package connect;


import java.sql.*;


public class MyConnection 
{
    static Connection con=null;
    static
    {
        try
        {    
          Class.forName("com.mysql.cj.jdbc.Driver");
        // System.out.println("Driver load....");
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e);
        }    
    }
   public static Connection getConnection() throws SQLException
   {
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");

        return(con);     
   }
}
