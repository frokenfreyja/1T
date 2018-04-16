package triphop.model;

import is.hi.hbv401g.flightsearch.model.Seat;
import java.util.ArrayList;


/**
 *
 * @author Elvar Árni Sturluson
 */
public class Flight {
    private final is.hi.hbv401g.flightsearch.model.Flight flight;
    private final ArrayList<Seat> seats = new ArrayList<Seat>();
    private final Integer cost;
    
    public Flight( is.hi.hbv401g.flightsearch.model.Flight inFlight, Integer passengerCount ) {
        flight = inFlight; 
        for( int i = 0; i < passengerCount; i++ ) {
            seats.add( flight.getAvailableSeats().get( i ) );
        }
        cost = calcCost( seats );
    }
    
    private Integer calcCost( ArrayList<Seat> inSeats ) {
        int sum = 0;
        for( Seat seat : inSeats ) {
            sum += seat.getPrice();
        }
        return sum;
    }
    
    public String getDeparture() {
        return flight.getDeparture();
    }
    
    public String getArrival() {
        return flight.getArrival();
    }
    
    public is.hi.hbv401g.flightsearch.model.Flight getFlight() {
        return flight;
    }
    
    public Integer getCost() {
        return cost;
    }
    
    public ArrayList<Seat> getSeats() {
        return seats;
    }
    
}