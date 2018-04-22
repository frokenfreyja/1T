package triphop.control;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
import triphop.model.Hotel;

import search.generator.Factory;
import triphop.control.HotelSearcher;
import triphop.control.HotelSearcher;

/**
 *
 * @author Elvar Árni Sturluson
 */
public class FakeHotelSearcherAdapter implements HotelSearcher {
    /* Mock object fyrir hotelsercher ef database er niðri */
    public ArrayList<Hotel> searchHotels(
            String location
            ,Calendar inCheckInDate
            ,Calendar inCheckOutDate
    ) {
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        int n = 1000;
        
        for( int i = 0; i < n; i++ ) {
            search.generator.hotel.Hotel hotel = new search.generator.hotel.Hotel( 
                    1 
                    ,Factory.getRandom(Factory.hotelName) 
                    ," " 
                    ,0.1 
                    ,0.2 
                    ," "
                    ,new HashMap<Integer, String>());
            int randomCost = ThreadLocalRandom.current().nextInt(100000, 500000 + 1);
            hotels.add( new Hotel( hotel, location, randomCost ) );
        }
        
        return hotels;
    }
    
    public void bookHotel( Hotel hotel ) {
        System.out.println( "Correct" );
    }
    
    public static void main( String[] args ) {
        HotelSearcher hs = new FakeHotelSearcherAdapter();
        
        Calendar checkInDate = Calendar.getInstance();
        checkInDate.set( 2018, 4, 20 );
        Calendar checkOutDate = Calendar.getInstance();
        checkOutDate.set( 2018, 4, 20 ); 
        

        ArrayList<Hotel> hotels = hs.searchHotels( "Keflavik", checkInDate, checkOutDate );
        
        for( Hotel hotel : hotels ) {
            System.out.println( "--Hotel--" );
            System.out.println( hotel.getName() );
            System.out.println( "Location: "+hotel.getLocation() );
            System.out.println( "Cost: "+hotel.getCost() );
        }
    }
}
