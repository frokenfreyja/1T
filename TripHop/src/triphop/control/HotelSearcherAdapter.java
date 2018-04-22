package triphop.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import triphop.model.Hotel;
import search.API;

/**
 *
 * @author Elvar Árni Sturluson
 */
public class HotelSearcherAdapter implements HotelSearcher {
    private static final API apakottur = new API();
    private Calendar checkInDate;
    private Calendar checkOutDate;
    
     /* Adapter fall til að leita af hótel */
    public ArrayList<Hotel> searchHotels(
            String location
            ,Calendar inCheckInDate
            ,Calendar inCheckOutDate
    ) {
        checkInDate = inCheckInDate;
        checkOutDate = inCheckOutDate;
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        try {
            apakottur.generateHotels( 99 );
            List<search.generator.hotel.Hotel> tmp = apakottur.getAllHotels();
            for( search.generator.hotel.Hotel hotel : tmp ) {
                int randomCost = ThreadLocalRandom.current().nextInt(100000, 5000000 + 1);
                hotels.add( new Hotel( hotel, location, randomCost ) );
            }
        } 
        catch( IOException ex ) {
            System.err.println( ex );
        }

        return hotels; 
    }
    
     /* Adapter fall til að bóka hótel */
    public void bookHotel( Hotel hotel ) {
        Long hotelId = hotel.getHotel().getId();
        Long roomId = hotel.getHotel().getRoomIds().get( 1 );
        Long userId = new Long(11);
        String dateFrom = checkInDate.get( Calendar.YEAR ) + "-" 
                + checkInDate.get( Calendar.MONTH ) + "-" 
                + checkInDate.get( Calendar.DAY_OF_MONTH );
        
        String dateTo = checkInDate.get( Calendar.YEAR ) + "-" 
                + checkInDate.get( Calendar.MONTH ) + "-" 
                + checkInDate.get( Calendar.DAY_OF_MONTH );
        
        Boolean isPaid = true;
        String cc = "";
        for(int i = 0; i < 23; i++) {
                cc += Integer.toString( ThreadLocalRandom.current().nextInt( 0, 9 + 1) );
        }
        try {
            Long bookingId = apakottur.makeBooking(hotelId, roomId, userId, dateFrom, dateTo, isPaid, cc);
            System.out.println( bookingId );
        } 
        catch(IOException ex) {
            System.err.println( ex );
        }
    }
    public static void main( String[] args ) {
        HotelSearcher hs = new HotelSearcherAdapter();

        Calendar checkInDate = Calendar.getInstance();
        checkInDate.set( 2018, 4, 20 );
        Calendar checkOutDate = Calendar.getInstance();
        checkOutDate.set( 2018, 4, 20 );


        ArrayList<Hotel> hotels = hs.searchHotels( "Keflavik", checkInDate, checkOutDate );

        for( Hotel hotel : hotels ) {
            System.out.println( "--DayTour--" );
            System.out.println( hotel.getName() );
            System.out.println( "Location: "+hotel.getLocation() );
            System.out.println( "Cost: "+hotel.getCost() );
        }
    }
}
