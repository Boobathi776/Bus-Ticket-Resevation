package Bus_Ticket_reservation_with_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    private static final String url= "jdbc:mysql://localhost:3306/busresv";
    private static final String username="root";
    private static final String pass="Boobathi776##";
    public static Connection getConnection() throws Exception  // this method going to return the connection object
    {                                                          // so return type  Connection class
        return DriverManager.getConnection(url,username,pass);
    }
}


// user ORM     - object relationla mapping