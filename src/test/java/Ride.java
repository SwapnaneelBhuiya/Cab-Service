public class Ride {
    double distance;
    int time;
    String userId;
    char category;
    public Ride(String userId,double distance, int time, char category) {
        this.distance=distance;
        this.time=time;
        this.userId=userId;
        this.category=category;
    }
}
