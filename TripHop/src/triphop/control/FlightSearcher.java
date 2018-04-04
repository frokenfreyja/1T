package triphop.control;

import java.util.ArrayList;
import java.util.Date;
import triphop.model.*;

/**
 *
 * @author Elvar Árni Sturluson
 */
public interface FlightSearcher {
    public ArrayList<Flight[]> searchFlights(
            String departure 
            ,String arrival
            ,Date depDate
            ,Date arrDate
            ,Integer passengerCount
    );
}
