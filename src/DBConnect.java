package airline.reservation;


import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author iradraZ dahaF
 */
public class DBConnect {

    
    public static Connection Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //if you have xampp
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1/airline-reservation",
                    "root",
                    ""
            );

            return conn;
        } catch (Exception e) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                //if you have xampp
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1/java",
                        "root",
                        ""
                );

                return conn;
            } catch (Exception ex) {
                e.printStackTrace();
                return null;
            }
        }
    }
    public static ResultSet login(String email , String password) {
        try{
            
        Connection conn = Connect();
        String query = "SELECT * FROM `admins` WHERE email = ? AND password = ?"  ;
          //  System.out.print(query);
            System.out.println(email);
            System.out.println(password);
        
        Statement st = conn.createStatement();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet r = ps.executeQuery() ;
        return r;
        } catch(Exception e){
            System.out.print(e);
        }
        return null;
    }
    
}
