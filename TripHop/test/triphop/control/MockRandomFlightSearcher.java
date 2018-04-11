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
    public ArrayList<Flight> searchFlights(
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
        ArrayList<Flight> arr = new ArrayList<>();
        Random rand = new Random();
        for( int loc = 0; loc < locations.length; loc++ ) {
            for( int i = 0; i < 1000; i++ ) {
                int x = rand.nextInt( locations.length );
                if( x != loc ) {
                    Flight flight = new Flight( locations[loc], locations[x] );
                    arr.add( flight );
                }
            }
        }
      
        Collections.shuffle(arr);
        return arr;
    };
    
    public void bookFlight( Flight flight ) {
        
    };
}
