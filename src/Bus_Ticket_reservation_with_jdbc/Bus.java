package Bus_Ticket_reservation_with_jdbc;

public class Bus {
    private int busNo;
    private Boolean ac;
    private int capacity;
    Bus(int busNo,boolean ac,int capacity) {
        this.busNo = busNo;
        this.ac = ac;
        this.capacity = capacity;
    }
    public int getBusNo()
    {
        return busNo;
    }

    public Boolean getAc() {
        return ac;
    }

    public void setAc(Boolean val) {
        ac = val;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int cap) //mutator - becoz used to modify the data
    {
        capacity = cap;
    }

    public  void displayBusInfo()    //don't use static method becoz the variables are private
    {
        System.out.println("Bus No : "+ busNo + " Ac : "+ ac +"  Total capacity: "+ capacity);
    }
}
