package triphop.control;

import java.util.ArrayList;
import java.util.Date;
import triphop.model.DayTour;
import Controller_Layer.*;
import Model_Layer.Basket;
import Model_Layer.Daytrip;
import java.sql.SQLException;

/**
 *
 * @author Elvar Árni Sturluson
 */
public class DayTourSearcherAdapter implements DayTourSearcher {
        
    private TripSearch dayTourSearcher; // Searcher
    private ArrayList<Daytrip> trips = new ArrayList<Daytrip>(); // Möguleikar
    private final Basket basket = new Basket(); // Bókar aðeins
    private Integer passengerCount;
    
    /* Adapter fall til að leita af dagferð */
    public ArrayList<DayTour> searchDayTours(
            String location
            ,Date date
            ,String activity
            ,Integer inPassengerCount
    ) {
        ArrayList<DayTour> dayTours = new ArrayList<DayTour>();
        passengerCount = inPassengerCount;

        dayTourSearcher = new TripSearch( null, location, activity, 0, 100000, -1, -1 );
        
        try {
            dayTourSearcher.updateTrips();
        }
        catch( SQLException e ) {
            System.out.println( e );
        }
        trips = dayTourSearcher.getTrips();
        
        
        for( Daytrip trip : trips ) {
            dayTours.add( new DayTour( trip, passengerCount ) );
        }
        
        return dayTours; 
    }   
    
    /* Adapter fall til að bók dagsferð */
    public void bookDayTour( DayTour dayTour ) {
        basket.emptyBasket();
        basket.addBooking( dayTour.getDaytrip(), passengerCount, "Saturday" );
    }
    
    public static void main( String[] args ) {
        DayTourSearcher dts = new DayTourSearcherAdapter();

        ArrayList<DayTour> dayTours = dts.searchDayTours( "Paris", null, "Games", 3);
        
        for( DayTour dayTour : dayTours ) {
            System.out.println( "--DayTour--" );
            System.out.println( dayTour.getName() );
            System.out.println( "Location: "+dayTour.getLocation() );
            System.out.println( "Activity: "+dayTour.getActivity() );
            System.out.println( "Cost: "+dayTour.getCost() );
            System.out.println( (new Date()).getTime()%250000 );
        }
    }
}
