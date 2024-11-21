package Bus_Ticket_Resevation_without_jdbc;
import java.util.*;
import java.text.SimpleDateFormat;

public class Booking {
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

   public boolean  isAvailable(ArrayList<Bus> buses,ArrayList<Booking> bookings)
   {
       int capacity=0;
       for(Bus bus:buses) {
           if (bus.getBusNo() == busNo) {
               capacity = bus.getCapacity();
           }
       }
           int booked=0;
           for(Booking b:bookings)
           {
               if(b.busNo == busNo && b.date.equals(date))
               {
                   booked++;
               }
           }
       return booked<capacity?true:false;
   }


}
