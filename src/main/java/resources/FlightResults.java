package resources;

import org.codehaus.jackson.annotate.JsonProperty;
import java.util.List;

/**
 * Created by vasujain on 4/29/17.
 */
public class FlightResults {

    @JsonProperty("results")
    List<Flight> results;

    public List<Flight> getResults() {
        return results;
    }

    public void setResults(List<Flight> results) {
        this.results = results;
    }
}
