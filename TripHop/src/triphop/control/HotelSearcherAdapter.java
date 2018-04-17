package triphop.control;

import java.util.ArrayList;
import java.util.Calendar;
import triphop.model.Hotel;
import search.API;

/**
 *
 * @author Elvar Árni Sturluson
 */
public class HotelSearcherAdapter implements HotelSearcher {
    private API apakottur = new API();
    
     /* Adapter fall til að leita af hótel */
    public ArrayList<Hotel> searchHotels(
            String location
            ,Calendar checkInDate
            ,Calendar checkOutDate
    ) {
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        return hotels; 
    }
    
     /* Adapter fall til að bóka hótel */
    public void bookHotel( Hotel hotel ) {
    }
}
