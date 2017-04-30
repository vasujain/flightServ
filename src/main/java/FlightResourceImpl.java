import resources.FlightResults;
import model.Processor;

/**
 * Created by vasujain on 4/29/17.
 */

public class FlightResourceImpl {
    public FlightResults searchFlights() throws Exception{
        return Processor.fetchFlightResultsFromProvider();
    }
}
