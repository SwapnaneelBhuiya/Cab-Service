import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
        Ride[] rides={new Ride("Pass1",2.0,5,'N'),new Ride("Pass2",0.1,1,'N')};
        double fare=invoiceGeneratorService.calculateFare(Arrays.asList(rides));
        double average=invoiceGeneratorService.averageFare(fare,rides);
        int numOfRides=invoiceGeneratorService.totalRides(rides);
        Assert.assertEquals(30,fare,0.0);
        Assert.assertEquals(15,average,0.0);
        Assert.assertEquals(2,numOfRides);
    }
    @Test
    public void givenCustIDReturnsListOfRides()
    {
        InvoiceGeneratorService invoiceGeneratorService=new InvoiceGeneratorService();
        Ride[] rides={new Ride("Pass1",2.0,5,'N'),new Ride("Pass2",0.1,1,'P')
                , new Ride("Pass1",3.4,8,'P')};
        List<Ride> numOfRides=invoiceGeneratorService.numOfRides(rides,"Pass1");
        Assert.assertEquals(2,numOfRides.size());
        double fare=invoiceGeneratorService.calculateFare(numOfRides);
    }
}
