package triphop.control;

import java.util.ArrayList;
import java.util.Date;
import triphop.model.DayTour;

/**
 *
 * @author Elvar Árni Sturluson
 */
public class DayTourSearcherAdapter implements DayTourSearcher {
        
    private String dayTourSearcher = null; // Vantar að breyta
    
    /* Adapter fall til að leita af dagferð */
    public ArrayList<DayTour> searchDayTours(
            String location
            ,Date date
    ) {
        ArrayList<DayTour> dayTours = new ArrayList<DayTour>();
        // new Root( new TripSearch, new Basket )
        // 
        // 
        
        return dayTours; 
    }   
    
    /* Adapter fall til að bók dagsferð */
    public void bookDayTour( DayTour dayTour ) {
    }
}
