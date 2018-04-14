package triphop.control;

import java.util.ArrayList;
import java.util.Date;
import is.hi.hbv401g.flightsearch.controller.FlightSearchController;
import java.util.Calendar;
import triphop.model.Flight;


/**
 *
 * @author Elvar Árni Sturluson
 */
public class FlightSearcherAdapter implements FlightSearcher {
    private FlightSearchController flightSearcher = new FlightSearchController();
    
    private Calendar toCalendar(Date date){ 
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
    
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
