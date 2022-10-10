/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline.reservation;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * s
 *
 * @author iradraZ dahaF
 */
public class FlightsController {

    public static ResultSet getFlights() throws SQLException {
        Connection conn = DBConnect.Connect();
        Statement stmt = conn.createStatement();
        ResultSet r = stmt.executeQuery("SELECT * FROM `flights`");
        return r;

    }

    public static boolean addFlight(Flight f) {
        try {
            Connection conn = DBConnect.Connect();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO `flights` (`id`, `origin`, `destination`, `departure_date`, `departure_time`, `arrival`, `flight_no`, `plane_id`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?);");
            stmt.setString(1, f.origin);
            stmt.setString(2, f.destination);
            stmt.setString(3, f.departure_date);
            stmt.setString(4, f.departure_time);
            stmt.setString(5, f.arrival_time);
            stmt.setInt(6, Integer.valueOf(f.flight_no));
            if (FleetController.getPlaneId(Integer.valueOf(f.flight_no)) != 0) {
                stmt.setInt(7, FleetController.getPlaneId(Integer.valueOf(f.flight_no)));

            }
            int x = stmt.executeUpdate();
            System.out.print(x);

            return true;
        } catch (SQLException ex) {
            System.out.print(ex);
            return false;
        }

    }

    public static boolean removeFlight(int id) {
        try {
            Connection conn = DBConnect.Connect();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM flights WHERE `flights`.`id` = ?");
            ps.setInt(1, id);
            int i = ps.executeUpdate();
            System.out.print(i + " " + id);

            return true;

        } catch (SQLException ex) {
            System.out.print(ex);
            return false;
        }
    }

    public static boolean updateFlight(Flight f) {
        try {
            Connection conn = DBConnect.Connect();
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE flights SET origin = ? , destination = ? , departure_date = ? , departure_time = ? , arrival = ?  , flight_no = ? , plane_id = ?    WHERE  id = ?");
            ps.setString(1, f.origin);
            ps.setString(2, f.destination);
            ps.setString(3, f.departure_date);
            ps.setString(4, f.departure_time);
            ps.setString(5, f.arrival_time);
            ps.setInt(6, f.flight_no);
            ps.setInt(7, FleetController.getPlaneId(f.flight_no));
            ps.setInt(8, f.id);
            int i = ps.executeUpdate();
            System.out.print(i + " " + f.id);
            return true;
        } catch (SQLException ex) {
            System.out.print(ex);
            return false;
        }
    }

    public static String bookFlight(Flight f, BookingInfo p) {
        try {
            Connection conn = DBConnect.Connect();
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO `bookings` (`id`, `name`, `email`, `passport_no`, `age`, `flight_id`, `ticket_no`) VALUES (NULL, ?, ?, ?, ?, ?, ?);"
            );
            String ticket_no = getAlphaNumericString(12);
            ps.setString(1, p.name);
            ps.setString(2, p.email);
            ps.setString(3, p.passport_no);
            ps.setInt(4, p.age);
            ps.setInt(5, f.id);
            ps.setString(6, ticket_no);
            int result = ps.executeUpdate();
            return ticket_no ;
        } catch (SQLException ex) {
            System.out.print(ex);
            return null;
        }
    }

    public static String getAlphaNumericString(int n) {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
}
