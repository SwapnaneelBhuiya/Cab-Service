public class InvoiceGeneratorService {

    public static final int COST_PER_TIME=1;
    public static final double MINIMUM_COST_PER_KILOMETER=10.0;
    private static final double MINIMUM_FARE = 5.0;

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
            fare+=calculateFare(ob.distance,ob.time);
        }
        return fare;
    }
}
