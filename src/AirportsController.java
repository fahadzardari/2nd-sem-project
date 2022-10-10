package airline.reservation;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author iradraZ dahaF
 */
public class AirportsController {
    public static ResultSet getAirports(){
            try{
                Connection conn = DBConnect.Connect();
                Statement st = conn.createStatement();
                ResultSet r = st.executeQuery("SELECT * FROM `airports`;");
                System.out.println();
                return r;
            }catch(Exception e){
                return null;
            }
                  
    }
    
        public static ResultSet getAirportNames(){
            try{
                Connection conn = DBConnect.Connect();
                Statement st = conn.createStatement();
                ResultSet r = st.executeQuery("SELECT name FROM `airports`;");
                return r;
            }catch(Exception e){
                return null;
            }
                  
    }
}
