package triphop.control;

import java.util.ArrayList;
import is.hi.hbv401g.flightsearch.controller.FlightSearchController;
import java.util.Calendar;
import java.util.List;
import triphop.model.Flight;


/**
 *
 * @author Elvar Árni Sturluson
 */
public class FlightSearcherAdapter implements FlightSearcher {
    private FlightSearchController flightSearcher = new FlightSearchController();
    
    /* Adapter fall til að leita af flugi */
    public ArrayList<Flight> searchFlights(
        String departure 
        ,String arrival
        ,Calendar depDate
        ,Calendar arrDate
        ,Integer passengerCount
    ) {
        List<is.hi.hbv401g.flightsearch.model.Flight> fakeFlights = flightSearcher.search( 
            departure
            ,arrival
            ,depDate
            ,arrDate
            ,passengerCount 
        );
        
        ArrayList<Flight> flights = new ArrayList<Flight>();
        
        for( is.hi.hbv401g.flightsearch.model.Flight fakeFlight : fakeFlights ) {
            flights.add( new Flight( fakeFlight, passengerCount ) );
        }
        
        return flights;
    }   
    
    /* Adapter fall til að bók flug */
    public void bookFlight( Flight flight ) {

        System.out.println( flightSearcher.bookFlight( flight.getFlight(), flight.getSeats() ) );
    }
    
    public static void main( String[] args ) {
        FlightSearcher fs = new FlightSearcherAdapter();
        
        Calendar depDate = Calendar.getInstance();
        depDate.set( 2018, 4, 20 );
        Calendar arrDate = Calendar.getInstance();
        arrDate.set( 2018, 4, 20 ); 
        
        ArrayList<Flight> flights = fs.searchFlights( "Keflavik", "Paris", depDate , arrDate, 2 );

        for( Flight flight : flights ) {
            System.out.println( "--FLIGHT--" );
            System.out.println( flight.getArrival() );
            System.out.println( flight.getDeparture() );
            System.out.println( flight.getCost() );
        }
        
    }
}
