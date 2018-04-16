package triphop.control;

import java.util.ArrayList;
import java.util.Calendar;
import triphop.model.Hotel;

/**
 *
 * @author Elvar Árni Sturluson
 */
public class MockNullHotelSearcher implements HotelSearcher {
    public ArrayList<Hotel> searchHotels(
            String location
            ,Calendar checkInDate
            ,Calendar checkOutDate
    ) {
      return null;  
    };
    public void bookHotel( Hotel hotel ) {
        
    };
}
