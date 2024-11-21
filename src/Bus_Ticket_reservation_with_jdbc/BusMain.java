package Bus_Ticket_reservation_with_jdbc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;
public class BusMain {
    public static void main(String args[]) throws Exception
    {
        BusDataAccessObject busDao = new BusDataAccessObject();
        busDao.displayBusInfo();
        int userOption=1;
        Scanner in=new Scanner(System.in);

        while(userOption==1) {
            System.out.println("Enter 1 to Book and 2 to Exit ");
            userOption=in.nextInt();
            if(userOption==1)
            {
                Booking booking = new Booking();
                if(booking.isAvailable())
                {
                    BookingDataAccessObject bookingdao = new BookingDataAccessObject();
                    bookingdao.addBooking(booking);
                    System.out.println("Your booking is confirmed.........");
                }
                else
                {
                    System.out.println("Sorry. Bus is full. try another bus or date");
                }

            }

        }
    }
}
