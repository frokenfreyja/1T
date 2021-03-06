package triphop.model;

/**
 *
 * @author Elvar Árni Sturluson
 */
public class Package {
    final private Flight[] flight;
    final private Hotel hotel;
    final private DayTour daytour;
    
    public Package(Flight[] inFlight, Hotel inHotel, DayTour inDaytour) {
        flight = inFlight;
        hotel = inHotel;
        daytour = inDaytour;
    };
    
    public Flight[] getFlight() {
        return flight;
    };

    public Hotel getHotel() {
        return hotel;
    };
    
    public DayTour getDayTour() {
        return daytour;
    }; 
    
    public int getCost() {
        int cost = 0;
        // Hér vantar aðferðir þar sem verð eru lögð saman
        int fCost = flight[0].getCost() + flight[1].getCost();
        int hCost = hotel.getCost();
        int dCost = daytour.getCost();
        cost = fCost + hCost + dCost;
        return cost;
    }
}
