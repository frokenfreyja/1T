package triphop.model;

/**
 *
 * @author Elvar Árni Sturluson
 */
public class DayTour {
    final private String location;
    
    public DayTour(String inLocation) {
        location = inLocation;
    }
          
    public String getLocation() {
        return location;
    }
}