package triphop.control;

import java.util.ArrayList;
import java.util.Date;
import triphop.model.*;

/**
 *
 * @author Elvar Árni Sturluson
 */
public interface DayTourSearcher {
    public ArrayList<DayTour> searchDayTours(
            String location
            ,Date date
    );
    public void bookDayTour( DayTour daytour );
}
