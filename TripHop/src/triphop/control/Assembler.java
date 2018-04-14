package triphop.control;

import java.util.ArrayList;

import triphop.model.*;
import triphop.model.Package;

/**
 *
 * @author Elvar Árni Sturluson
 */
public class Assembler {
    /* Sameinar 2 flug, eitt út, eitt aftur heim. */
    private static ArrayList<Flight[]> assembleFlights(
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
    
    /* Býr til pakka út frá inntaki, býr til max n pakka */
    public static ArrayList<Package> assemblePackages(
            ArrayList<Flight> outboundFlights
            ,ArrayList<Flight> returnFlights
            ,ArrayList<Hotel> hotels
            ,ArrayList<DayTour> daytours
    ) {
        ArrayList<Package> packages = new ArrayList<Package>();
        ArrayList<Flight[]> flights = assembleFlights( outboundFlights, returnFlights );
        int n = 200;
        out:
        for( Flight[] flight : flights ) {
            for( Hotel hotel : hotels ) {
                for( DayTour daytour : daytours ) {
                    if( 
                        flight[0].getArrival().equals( hotel.getLocation() ) &&
                        hotel.getLocation().equals( daytour.getLocation() )    
                    ) {
                        packages.add( new Package( flight, hotel, daytour ) );
                        if( packages.size() > n ) {
                            break out;
                        }
                    }
                }
            }
        }
        return packages;
    }
    
}
