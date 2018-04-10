package triphop.control;

import java.util.*;

import triphop.model.*;
import triphop.model.Package;

/**
 *
 * @author Elvar Árni Sturluson
 */
public class PackageManager {
    
    // Controllerar fyrir hinar þrjár leitarvélarnar
    private FlightSearcher flightSearch;
    private HotelSearcher hotelSearch;
    private DayTourSearcher dayTourSearch;
    // Object sem mun innihalda leitarupplýsingar
    private Customer customer;
    // Object sem verður listi af pökkunum
    private ArrayList<Package> packages;
	
    public PackageManager(
            Customer customerInfo
            ,FlightSearcher inFlightSearcher
            ,HotelSearcher inHotelSearcher
            ,DayTourSearcher inDayTourSearcher
    ) {
        this.customer = customerInfo;
        this.flightSearch = inFlightSearcher;
        this.hotelSearch = inHotelSearcher;
        this.dayTourSearch = inDayTourSearcher;
    }
	
    public ArrayList<Package> searchPackages() {
        // Upplýsingum sem notaðar eru gefnar sér breytur til að minnka clutter.
        String orig = this.customer.getOrigin();
        String dest = this.customer.getDestination();
        Date depDate = this.customer.getDepartureDate();
        Date retDate = this.customer.getReturnDate();
        int paxCount = this.customer.getNumOfTravelers();
        // Calendar notað til að bæta einum degi við til að finna ferð
        // daginn eftir að farþegi er kominn.
        Calendar c = Calendar.getInstance();
        c.setTime(depDate);
        c.add(Calendar.DATE, 1);
        Date tourDate = c.getTime();
        // Kallað á leitir fyrir hótel og dagsferðir.
        ArrayList<Hotel> hotels = this.hotelSearch.searchHotels(dest, depDate, retDate);
        ArrayList<DayTour> dayTours = this.dayTourSearch.searchDayTours(dest, tourDate);
        // Kallað á leitir fyrir flug fram og til baka.
        ArrayList<Flight> outboundFlights = this.flightSearch.searchFlights(orig, dest, depDate, depDate, paxCount);
        ArrayList<Flight> returnFlights = this.flightSearch.searchFlights(dest, orig, depDate, depDate, paxCount);
        

        if(
            hotels == null || dayTours == null ||
            outboundFlights == null ||
            returnFlights == null    
        ) {
            return null;
        } 
        
        // Listarnir hér að ofan mataðir í assemblePackages fallið þar sem þeir verða settir saman.
        return Assembler.assemblePackages( outboundFlights, returnFlights, hotels, dayTours );
    }
    
    public void sortPackages(String field, String orderBy) {
        // Ekkert enn.
    }
	
    public void bookPackage(Package pack) {
        // Ekkert enn.
    }
	
    public ArrayList<String[]> showPackages() {
        // Ekkert enn.
        return new ArrayList<String[]>();
    }
    
}
