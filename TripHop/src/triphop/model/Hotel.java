package triphop.model;

/**
 *
 * @author Elvar Árni Sturluson
 */
public class Hotel {
    final private search.generator.hotel.Hotel hotel;
    final private String location;
    final private Integer cost;
    
    public Hotel( search.generator.hotel.Hotel inHotel, String inLocation, Integer inCost ) {
        hotel = inHotel;
        location = inLocation;
        cost = inCost;
    }
    
    public String getLocation() {
        return location;
    }
    
    public String getName() {
        return hotel.getName();
    }
          
    public search.generator.hotel.Hotel getHotel() {
        return hotel;
    }
    
    public Integer getCost() {
        return cost;
    }
}