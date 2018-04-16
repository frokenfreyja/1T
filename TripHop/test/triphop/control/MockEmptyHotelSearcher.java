package triphop.control;

import java.util.ArrayList;
import java.util.Calendar;
import triphop.model.Hotel;

/**
 *
 * @author Elvar Árni Sturluson
 */
public class MockEmptyHotelSearcher implements HotelSearcher {
    public ArrayList<Hotel> searchHotels(
            String location
            ,Calendar checkInDate
            ,Calendar checkOutDate
    ) {
      return new ArrayList<Hotel>();  
    };
    public void bookHotel( Hotel hotel ) {
        
    };
}
