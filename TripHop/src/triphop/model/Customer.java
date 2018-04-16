package triphop.model;
import java.util.Calendar;

/**
 *
 * @author Ragnar
 */
public class Customer {
    private Calendar departureDate;
    private Calendar returnDate;
    private String origin;
    private String destination;
    private int numOfTravelers;
    private int numOfDayTours;
    private String theme;
    
    public Customer(Calendar depDate, Calendar retDate, String orig, String dest,
                    int numOfPax, int numOfTours, String theme) {
        this.departureDate = depDate;
        this.returnDate = retDate;
        this.origin = orig;
        this.destination = dest;
        this.numOfTravelers = numOfPax;
        this.numOfDayTours = numOfTours;
        this.theme = theme;        
    }
    
    public Calendar getDepartureDate() {
        return this.departureDate;
    }
    
    public Calendar getReturnDate() {
        return this.returnDate;
    }
    
    public String getOrigin() {
        return this.origin;
    }
    
    public String getDestination() {
        return this.destination;
    }
    
    public int getNumOfTravelers() {
        return this.numOfTravelers;
    }
    
    public int getNumOfDayTours() {
        return this.numOfDayTours;
    }
    
    public String getTheme() {
        return this.theme;
    }
}
