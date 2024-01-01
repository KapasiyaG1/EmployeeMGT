/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect;

import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author soyam
 */
public class TestMain 
{
    public static void main(String[] args) throws Exception 
    {
        int user_id;
        String firstname,lastname,phone_number,email,password,gender,date,time;
        Scanner scan = new Scanner(System.in);
        
       Connection con = MyConnection.getConnection();
        System.out.println("connection: "+con);
    }
}
