package triphop.model;

/**
 *
 * @author Elvar Árni Sturluson
 */
public class Flight {
    final private String departure; 
    final private String arrival;
    
    public Flight(String inDeparture, String inArrival) {
        departure = inDeparture;
        arrival = inArrival;
    }
    
    public String getDeparture() {
        return departure;
    }
    
    public String getArrival() {
        return arrival;
    }
    
}