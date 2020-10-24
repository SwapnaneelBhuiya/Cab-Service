import java.util.ArrayList;
import java.util.List;

public class InvoiceGeneratorService {

    public int COST_PER_TIME=1;
    public double MINIMUM_COST_PER_KILOMETER=10.0;
    public double MINIMUM_FARE = 5.0;

    public double calculateFare(double distance, int time) {
        double fare= distance*MINIMUM_COST_PER_KILOMETER + time*COST_PER_TIME;
        if(fare<MINIMUM_FARE){
            fare=MINIMUM_FARE;
        }
            return fare;
    }

    public double calculateFare(Ride[] rides) {
        double fare=0;
        for(Ride ob:rides)
        {
            if(ob.category=='N')
            {
                COST_PER_TIME=1;
                MINIMUM_COST_PER_KILOMETER=10.0;
                MINIMUM_FARE = 5.0;
            }
            else
            {
                COST_PER_TIME=2;
                MINIMUM_COST_PER_KILOMETER=15.0;
                MINIMUM_FARE = 20.0;
            }
            fare+=calculateFare(ob.distance,ob.time);
        }
        return fare;
    }
    public double averageFare(double fare, Ride[] rides)
    {
        return fare/rides.length;
    }
    public int totalRides(Ride[] rides)
    {
        return rides.length;
    }
    public List<Ride> numOfRides(Ride[] rides, String ID)
    {
        List<Ride> li=new ArrayList<>();
        for(Ride ob:rides)
        {
            if(ob.userId.equals(ID))
                li.add(ob);
        }
        return li;
    }
}
