package triphop.model;

import Model_Layer.Daytrip;

/**
 *
 * @author Elvar Árni Sturluson
 */
public class DayTour {
    final private Integer cost;
    final private Daytrip daytrip;
    
    
    public DayTour( Daytrip inDaytrip, Integer passengerCount ) {
        daytrip = inDaytrip;
        cost = daytrip.getPrice() * passengerCount;
    }
          
    public Daytrip getDaytrip() {
        return daytrip;
    }
    
    public String getName() {
        return daytrip.getName();
    }
    
    public String getLocation() {
        return daytrip.getLocation();
    }
    
    public Integer getCost() {
        return cost;
    }
}