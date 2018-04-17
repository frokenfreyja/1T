package triphop.model;

/**
 *
 * @author Elvar Árni Sturluson
 */
public class Hotel {
    final private String location;
    
    public Hotel(String inLocation) {
        location = inLocation;
    }
          
    public String getLocation() {
        return location;
    }
    
    public Integer getCost() {
        return 0;
    }
}