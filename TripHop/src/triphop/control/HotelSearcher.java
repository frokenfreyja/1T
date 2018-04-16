package triphop.control;

import java.util.ArrayList;
import java.util.Calendar;
import triphop.model.*;

/**
 *
 * @author Elvar Árni Sturluson
 */
public interface HotelSearcher {
    public ArrayList<Hotel> searchHotels(
            String location
            ,Calendar checkInDate
            ,Calendar checkOutDate
    );
    public void bookHotel( Hotel hotel );
}
