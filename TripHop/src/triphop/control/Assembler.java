package triphop.control;

import java.util.ArrayList;

import triphop.model.*;
import triphop.model.Package;

/**
 *
 * @author Elvar Árni Sturluson
 */
public class Assembler {
    public ArrayList<Flight[]> assembleFlights(
            ArrayList<Flight> outboundFlights
            ,ArrayList<Flight> returnFlights
    ) {
        ArrayList<Flight[]> flights = new ArrayList<Flight[]>();
        
        for( Flight outboundFlight : outboundFlights ) {
            for( Flight returnFlight : returnFlights ) {
                if( 
                        outboundFlight.getDeparture().equals( returnFlight.getArrival() ) &&
                        outboundFlight.getArrival().equals( returnFlight.getDeparture() )
                ) {
                    flights.add( new Flight[]{ outboundFlight, returnFlight }  );
                }
            }
        }
        return flights;
    }
    public ArrayList<Package> assemblePackages( 
            ArrayList<Flight[]> flights
            ,ArrayList<Hotel> hotels
            ,ArrayList<DayTour> daytours
    ) {
        ArrayList<Package> packages = new ArrayList<Package>();
        
        
        
        return packages;
    }
    
}
