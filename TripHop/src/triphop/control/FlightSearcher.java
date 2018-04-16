package triphop.control;

import java.util.ArrayList;
import java.util.Calendar;
import triphop.model.*;

/**
 *
 * @author Elvar Árni Sturluson
 */
public interface FlightSearcher {
    public ArrayList<Flight> searchFlights(
            String departure 
            ,String arrival
            ,Calendar depDate
            ,Calendar arrDate
            ,Integer passengerCount
    );
    public void bookFlight( Flight flight ); 
}
