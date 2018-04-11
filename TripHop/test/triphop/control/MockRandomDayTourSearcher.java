package triphop.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import triphop.model.DayTour;

/**
 *
 * @author Elvar Árni Sturluson
 */
public class MockRandomDayTourSearcher implements DayTourSearcher {
    public ArrayList<DayTour> searchDayTours(
            String location
            ,Date date
    ) {
        String[] locations = new String[]{
            "Reykjavík", "Akureyri", "New York", "Milano", "Alicante", "Tokyo", 
            "París", "Madrid", "Berlin"
        };
        ArrayList<DayTour> arr = new ArrayList<>();
        Random rand = new Random();
        for( int i = 0; i < 5000; i++ ) {
            int x = rand.nextInt( locations.length );

            DayTour daytour = new DayTour( locations[x] );
            arr.add( daytour );
        }
        
        return arr;
    };
    
    public void bookDayTour( DayTour daytour ) {
        
    };
}
