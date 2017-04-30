package resources;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

/**
 * Created by vasujain on 4/29/17.
 */

@JsonPropertyOrder({"agony", "price", "provider","arrive_time","flight_num","depart_time"})
public class Flight {

    @JsonProperty("agony")
    private double agony;

    @JsonProperty("price")
    private int price;

    @JsonProperty("provider")
    private String provider;

    @JsonProperty("arrive_time")
    private String arriveTime;

    @JsonProperty("depart_time")
    private String departTime;

    @JsonProperty("flight_num")
    private String flightNum;

    public double getAgony() {
        return agony;
    }

    public void setAgony(double agony) {
        this.agony = agony;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }
}
