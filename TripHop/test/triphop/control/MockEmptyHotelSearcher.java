package triphop.control;

import java.util.ArrayList;
import java.util.Date;
import triphop.model.Hotel;

/**
 *
 * @author Elvar Árni Sturluson
 */
public class MockEmptyHotelSearcher implements HotelSearcher {
    public ArrayList<Hotel> searchHotels(
            String location
            ,Date checkInDate
            ,Date checkOutDate
    ) {
      return new ArrayList<Hotel>();  
    };
}
