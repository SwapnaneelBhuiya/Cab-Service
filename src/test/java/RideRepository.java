import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideRepository {
    HashMap<String, ArrayList<Ride>> userRides=null;
    public RideRepository()
    {
        this.userRides= new HashMap<String, ArrayList<Ride>>();
    }
    //Method to Add rides
    public void addRide(String userID, ArrayList<Ride> rides) {
        try {
            if (userID == null || rides == null) {
                throw new NullPointerException("Null value not allowed");
            }
            if (userRides.containsKey(userID)) {
                for (Ride rides1 : rides) {
                    userRides.get(userID).add(rides1);

                }

            } else
                userRides.put(userID, rides);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
