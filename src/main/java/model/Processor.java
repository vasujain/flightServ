package model;

import Util.Constants;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import resources.DataProvider;
import resources.Flight;
import resources.FlightResults;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vasujain on 4/29/17.
 */
public class Processor {
    static ObjectMapper objectMapper = new ObjectMapper();

    /*
       Processor Main method. Returns Merged and Sorted ResultSet
       @Param : void
       @Return: Merged and Sorted FlightResults List
    */

    public static FlightResults fetchFlightResultsFromProvider() throws Exception {
        List<FlightResults> flightResultsList = new ArrayList<FlightResults>();
        for(DataProvider dataProvider : DataProvider.values()) {
            FlightResults flightResults = fetchProviderAPIResults(dataProvider.name());
            flightResultsList.add(flightResults); // adding for sorting
        }
        return mergeResultsUpdt(flightResultsList);
    }

    /*
       Makes a Rest call to a provider name from list of providers. Map response Json to FlightResults object
       @Param : List<FlightResults> flightResultsList
       @Return: Merged and Sorted FlightResults List
    */
    private static FlightResults fetchProviderAPIResults(String providerName) throws IOException {
        FlightResults flightResults = new FlightResults();
        try {
            String url = Constants.DATA_PROVIDER_SERVICE_URL + providerName;
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            int responseStatusCode = httpResponse.getStatusLine().getStatusCode();
            String responseJson = EntityUtils.toString(httpResponse.getEntity());
            objectMapper.readValue(responseJson, FlightResults.class);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return flightResults;
    }

    /*
       Iterate over List of FlightLists and use Merge Sort t
       @Param : List<FlightResults> flightResultsList
       @Return: Merged and Sorted FlightResults List
    */
    public static FlightResults mergeResultsUpdt(List<FlightResults> flightResultsList) {
        FlightResults flightResultsSorted = new FlightResults();
        List<Flight> flightListSorted = new ArrayList<Flight>();
        while(flightResultsList.size() > 0) {
            FlightResults flightResultWithLowestAgony = getLowestAgony(flightResultsList);
            flightListSorted.add(flightResultWithLowestAgony.getResults().get(0));
            flightResultWithLowestAgony.getResults().remove(0);
            if(flightResultWithLowestAgony.getResults().size() == 0) {
                flightResultsList.remove(flightResultWithLowestAgony);
            }
        }
        flightResultsSorted.setResults(flightListSorted);
        return flightResultsSorted;
    }

    /*
        Find the List with Flight with lowestAgony among the List<List<Flight>>
        @Param : List<FlightResults> flightResultsList
        @Return: FlightResults with lowestAgony Flight
     */
    public static FlightResults getLowestAgony(List<FlightResults> flightResultsList) {
        double minAgony = flightResultsList.get(0).getResults().get(0).getAgony();
        for(FlightResults flightResults: flightResultsList) {
            if(flightResults.getResults().get(0).getAgony() < minAgony) {
                return flightResults;
            }
        }
        return flightResultsList.get(0);
    }
}
