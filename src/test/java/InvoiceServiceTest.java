import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {
    @Test
    public void give_distance_time_should_return_fare()
    {
        InvoiceGeneratorService invoiceGeneratorService=new InvoiceGeneratorService();
        double distance =2.0;
        int time =5;
        double fare=invoiceGeneratorService.calculateFare(distance, time);
        Assert.assertEquals(25,fare, 0.0);
    }
    @Test
    public void given_less_distanceOrTime_ShouldReturnMinFare()
    {
        InvoiceGeneratorService invoiceGeneratorService=new InvoiceGeneratorService();
        double distance =0.1;
        int time =1;
        double fare=invoiceGeneratorService.calculateFare(distance, time);
        Assert.assertEquals(5,fare, 0.0);
    }
    @Test
    public void givenMultipleRides_ShouldReturnTotFare()
    {
        InvoiceGeneratorService invoiceGeneratorService=new InvoiceGeneratorService();
        double distance =0.1;
        int time =1;
        Ride[] rides={new Ride(2.0,5),new Ride(0.1,1)};
        double fare=invoiceGeneratorService.calculateFare(rides);
        Assert.assertEquals(30,fare,0.0);
    }
}
