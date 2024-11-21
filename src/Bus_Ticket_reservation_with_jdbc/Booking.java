package Bus_Ticket_reservation_with_jdbc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.sql.*;

public class Booking {
    public Object booking;
    String passengerName;
    int busNo;
    Date date;

    Booking()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter name of the passenger : ");
        passengerName = in.next();
        System.out.println("Enter bus no : ");
        busNo = in.nextInt();
        System.out.println("Enter the date dd-mm-yyyy : ");
        String dateInput=in.next();
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy"); //capitable M to mention the month for small m indicate the minutes
        try {
            date = dateFormat.parse(dateInput);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }

   public boolean  isAvailable() throws Exception
   {
       BusDataAccessObject busdao = new BusDataAccessObject();
       BookingDataAccessObject bookingdao = new BookingDataAccessObject();

       int capacity=busdao.getCapacity(busNo);
       int booked = bookingdao.getBookedCount(busNo,date);
       return booked<capacity?true:false;
   }


}
