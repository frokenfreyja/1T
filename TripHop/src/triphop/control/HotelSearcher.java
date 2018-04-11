package triphop.control;

import java.util.ArrayList;
import java.util.Date;
import triphop.model.*;

/**
 *
 * @author Elvar Árni Sturluson
 */
public interface HotelSearcher {
    public ArrayList<Hotel> searchHotels(
            String location
            ,Date checkInDate
            ,Date checkOutDate
    );
    public void bookHotel( Hotel hotel );
}
