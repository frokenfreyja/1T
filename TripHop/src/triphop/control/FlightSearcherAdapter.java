package triphop.control;

import java.util.ArrayList;
import java.util.Date;
import triphop.model.Flight;

/**
 *
 * @author Elvar Árni Sturluson
 */
public class FlightSearcherAdapter implements FlightSearcher {
    
    private String flightSearcher = null; // Vantar að breyta
    
    /* Adapter fall til að leita af flugi */
    public ArrayList<Flight> searchFlights(
        String departure 
        ,String arrival
        ,Date depDate
        ,Date arrDate
        ,Integer passengerCount
    ) {
        ArrayList<Flight> flights = new ArrayList<Flight>();
        // Nota calaender
        // Seats eru í Flight klassanum
        // getLocations()
        return flights; 
    }   
    
    /* Adapter fall til að bók flug */
    public void bookFlight( Flight flight ) {
    }
}
