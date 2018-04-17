package triphop.control;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import triphop.model.Hotel;

/**
 *
 * @author Elvar Árni Sturluson
 */
public class MockRandomHotelSearcher implements HotelSearcher {
    public ArrayList<Hotel> searchHotels(
            String location
            ,Calendar checkInDate
            ,Calendar checkOutDate
    ) {
        String[] locations = new String[]{
            "Reykjavík", "Akureyri", "New York", "Milano", "Alicante", "Tokyo", 
            "París", "Madrid", "Berlin"
        };
        ArrayList<Hotel> arr = new ArrayList<>();
        Random rand = new Random();
        for( int i = 0; i < 5000; i++ ) {
            int x = rand.nextInt( locations.length );

            Hotel hotel = new Hotel( null, null, null );
            arr.add( hotel );
        }
        
        return arr;
    };
    
    public void bookHotel( Hotel hotel ) {
        
    };
}
