import junit.framework.Assert;
import model.Processor;
import org.junit.Test;
import resources.Flight;
import resources.FlightResults;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vasujain on 4/29/17.
 */

public class TestProcessor {

    @Test
    public void testMergeResultsUpdt() {
        FlightResults flightResults = Processor.mergeResultsUpdt(prepareFlightData());
        Assert.assertEquals(flightResults.getResults().get(0).getAgony(), 1.8009004502251122);
        Assert.assertEquals(flightResults.getResults().get(1).getAgony(), 1.8009004502251125);
        Assert.assertEquals(flightResults.getResults().get(2).getAgony(), 1.8018018018018018);
        Assert.assertEquals(flightResults.getResults().get(3).getAgony(), 1.8018018018018018);
        Assert.assertEquals(flightResults.getResults().size(), 4);
    }

    @Test
    public void testGetLowestAgony() {
        FlightResults flightResults = Processor.getLowestAgony(prepareFlightData());
        Assert.assertEquals(flightResults.getResults().get(0).getAgony(), 1.8009004502251122);
        Assert.assertEquals(flightResults.getResults().get(0).getProvider(), "Expedia");
        Assert.assertEquals(flightResults.getResults().get(0).getFlightNum(), "UA1004");
        Assert.assertEquals(flightResults.getResults().size(), 2);
    }

    public static List<FlightResults> prepareFlightData() {
        List<FlightResults> flightResultsList = new ArrayList<FlightResults>();
        flightResultsList.add(setDummyFlightResult());
        flightResultsList.add(setAnotherDummyFlightResult());
        return flightResultsList;
    }

    private static FlightResults setDummyFlightResult() {
        FlightResults results = new FlightResults();
        List<Flight> flights = new ArrayList<Flight>();

        Flight flight = new Flight();
        flight.setAgony(1.8009004502251125);
        flight.setPrice(1999);
        flight.setProvider("United");
        flight.setArriveTime("2017-04-26T01:45:00");
        flight.setFlightNum("UA1001");
        flight.setDepartTime("2017-04-26T00:45:00");
        flights.add(flight);

        Flight flight2 = new Flight();
        flight2.setAgony(1.8018018018018018);
        flight2.setPrice(1998);
        flight2.setProvider("Expedia");
        flight2.setArriveTime("2017-04-29T14:15:00");
        flight2.setFlightNum("UA1002");
        flight2.setDepartTime("2017-04-29T13:15:00");
        flights.add(flight2);

        results.setResults(flights);
        return results;
    }

    private static FlightResults setAnotherDummyFlightResult() {
        FlightResults results = new FlightResults();
        List<Flight> flights = new ArrayList<Flight>();

        Flight flight = new Flight();
        flight.setAgony(1.8009004502251122);
        flight.setPrice(1999);
        flight.setProvider("Expedia");
        flight.setArriveTime("2017-04-26T01:45:00");
        flight.setFlightNum("UA1004");
        flight.setDepartTime("2017-04-26T00:45:00");
        flights.add(flight);

        Flight flight2 = new Flight();
        flight2.setAgony(1.8018018018018018);
        flight2.setPrice(1998);
        flight2.setProvider("United");
        flight2.setArriveTime("2017-04-29T14:10:00");
        flight2.setFlightNum("UA1009");
        flight2.setDepartTime("2017-04-29T13:10:00");
        flights.add(flight2);

        results.setResults(flights);
        return results;
    }

}
