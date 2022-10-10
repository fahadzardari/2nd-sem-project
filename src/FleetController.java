/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline.reservation;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author iradraZ dahaF
 */
public class FleetController {
     public static ResultSet getFlightNo(){
         Connection conn = DBConnect.Connect();
         try {
             Statement st = conn.createStatement();
             ResultSet r = st.executeQuery("SELECT flight_no FROM fleet");
             return r;
         } catch (SQLException ex) {
               System.out.println(ex);
             return null;
         }
         
     }
     public static int getPlaneId(int flight_no){
         Connection conn = DBConnect.Connect();
         try {
             Statement st = conn.createStatement();
             PreparedStatement ps = conn.prepareStatement("SELECT id FROM fleet WHERE flight_no = ?");
             ps.setInt(1, flight_no);
             ResultSet r = ps.executeQuery();
             if(r.next()){
             return r.getInt("id");
             }
             return 0;
         } catch (SQLException ex) {
               System.out.println(ex);
             return 0;
         }
     }
}
