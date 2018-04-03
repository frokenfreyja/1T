package triphop.control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import triphop.model.Flight;
import java.util.Random;

/**
 *
 * @author Elvar Árni Sturluson
 */
public class MockRandomFlightSearcher implements FlightSearcher {
    public ArrayList<Flight[]> searchFlights(
            String departure 
            ,String arrival
            ,Date depDate
            ,Date arrDate
            ,Integer passengerCount
    ) {
        String[] locations = new String[]{
            "Reykjavík", "Akureyri", "New York", "Milano", "Alicante", "Tokyo", 
            "París", "Madrid", "Berlin"
        };
        ArrayList<Flight[]> arr = new ArrayList<>();
        Random rand = new Random();
        for( int loc = 0; loc < locations.length; loc++ ) {
            for( int i = 0; i < 10; i++ ) {
                int x = rand.nextInt( locations.length );
                if( x != loc ) {
                    Flight[] flight = new Flight[2];
                    flight[0] = new Flight( locations[loc], locations[x] );
                    flight[1] = new Flight( locations[x], locations[loc] );
                    arr.add( flight );
                }
            }
        }
      
        Collections.shuffle(arr);
        return arr;
    };
    
    public static void main(String[] args) {
        FlightSearcher s = new MockRandomFlightSearcher();
        ArrayList<Flight[]> flights = s.searchFlights( "", "", new Date(), new Date(), 2);
        for( Flight[] flight : flights) {
            System.out.println( flight[0].getDeparture() );
            System.out.println( flight[0].getArrival() );
            System.out.println( flight[1].getDeparture() );
            System.out.println( flight[1].getArrival() );
            System.out.println( "-------------------");
        }
    }
}
