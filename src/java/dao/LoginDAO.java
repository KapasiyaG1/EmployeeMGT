/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import connect.MyConnection;
import model.Login;
import java.sql.*;
/**
 *
 * @author Vivek Uprit
 */
public class LoginDAO 
{
    public boolean insertData(Login L) throws Exception
    {
          Connection con=null;
          PreparedStatement ps=null;
          String sql;
          con=MyConnection.getConnection();
          sql="insert into login values(?,?,?,?)";
          ps=con.prepareStatement(sql);
          ps.setString(1, L.getUsername());
          ps.setString(2, L.getPassword());
          ps.setString(3, L.getCpassword());
          ps.setString(4, L.getEmail());
          if(ps.executeUpdate()>0)
              return true;
          
          return false;
    }
}
