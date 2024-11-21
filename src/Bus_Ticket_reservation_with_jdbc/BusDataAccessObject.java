package Bus_Ticket_reservation_with_jdbc;

import java.sql.*;

public class BusDataAccessObject {
   public static void displayBusInfo()throws Exception
    {
        String query = "select * from bus";
        Connection con = DbConnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);
        while(rs.next())
        {
            System.out.println("Bus No : "+rs.getInt(1));
            if(rs.getInt(2)==0)
                System.out.println("Ac : no");
            else
                System.out.println("Ac : yes ");
            System.out.println("capacity: "+rs.getInt(3));
        }
        System.out.println("-----------------------------------------");
    }

    public int getCapacity(int busid) throws Exception
    {
            String query = "select capacity from bus where id=" + busid;
            Connection con = DbConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            return rs.getInt(1);

    }

}
