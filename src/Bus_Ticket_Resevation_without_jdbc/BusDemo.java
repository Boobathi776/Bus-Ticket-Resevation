package Bus_Ticket_Resevation_without_jdbc;
import java.util.Scanner;
import java.util.ArrayList;
public class BusDemo {
    public static void main(String args[])
    {
//        //Bus[] bus=new Bus[50];   // we can create array of buses its not efficient so we use arraylist
        ArrayList<Bus> buses=new ArrayList<Bus>(); // we create array list with the datatype of Bus(it's a class)
        ArrayList<Booking> bookings=new ArrayList<Booking>();

        buses.add(new Bus(1,true,2)); // object is created and added to the array list
        buses.add(new Bus(2,false,45));
        buses.add(new Bus(3,true,45));


        int userOption=1;
        Scanner in=new Scanner(System.in);

        for(Bus b:buses)
        {
            b.displayBusInfo();
        }
        while(userOption==1) {
            System.out.println("Enter 1 to Book and 2 to Exit ");
            userOption=in.nextInt();
            if(userOption==1)
            {
                Booking booking = new Booking();
                if(booking.isAvailable(buses,bookings))
                {
                    bookings.add(booking);
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
