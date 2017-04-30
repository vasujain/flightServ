import Util.Constants;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import resources.FlightResults;

/**
 * Created by vasujain on 4/29/17.
 */

@Path("/flights")
public class FlightResourceHandler {
    private FlightResourceImpl flightResource;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/search")
    public FlightResults getFlight() throws Exception {
        flightResource = new FlightResourceImpl();
        return flightResource.searchFlights();
    }

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServerFactory.create(Constants.SERVICE_URL);
        server.start();
        System.out.println("FlightServ started:");
        System.out.println("Execute the URL to fetch latest results: http://localhost:8000/flights/search");
    }
}
