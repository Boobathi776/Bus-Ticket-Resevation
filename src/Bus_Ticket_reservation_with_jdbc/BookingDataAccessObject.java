package Bus_Ticket_reservation_with_jdbc;

import java.util.Date;
import java.sql.*;

public class BookingDataAccessObject {

   public int  getBookedCount(int busno, Date date) throws Exception
    {
        String query = "select count(passenger_name) from booking where bus_no=? and travel_date=?";
        Connection con = DbConnection.getConnection();
        PreparedStatement ps= con.prepareStatement(query);
        java.sql.Date sqldate= new java.sql.Date(date.getTime()); //converting java date to sql date for database to understand
        ps.setInt(1,busno);
        ps.setDate(2,sqldate);
        ResultSet rs=ps.executeQuery();
       rs.next();

        return rs.getInt(1);
    }

    public void addBooking(Booking booking) throws Exception
    {
        String query="insert into booking values(?,?,?) ";
        Connection con = DbConnection.getConnection();
        java.sql.Date sqldate=new java.sql.Date(booking.date.getTime());
        PreparedStatement pst=con.prepareStatement(query);
        pst.setString(1,booking.passengerName);
        pst.setInt(2,booking.busNo);
        pst.setDate(3,sqldate);
        pst.executeUpdate();
    }
}
