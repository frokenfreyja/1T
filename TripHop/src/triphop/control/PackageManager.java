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
    private FlightSearcher flightSearcher;
    private HotelSearcher hotelSearcher;
    private DayTourSearcher dayTourSearcher;
    
    // Object sem mun innihalda leitarupplýsingar
    private Customer customer;
    
    // Object sem verður listi af pökkunum
    private ArrayList<Package> packages;
	
    /* Smiðurinn fyrir PackageManager */
    public PackageManager(
            Customer customerInfo
            ,FlightSearcher inFlightSearcher
            ,HotelSearcher inHotelSearcher
            ,DayTourSearcher inDayTourSearcher
    ) {
        customer = customerInfo;
        flightSearcher = inFlightSearcher;
        hotelSearcher = inHotelSearcher;
        dayTourSearcher = inDayTourSearcher;
        packages = searchPackages();
    }
	
    /* Leitar af pökkunum og skilar þeim */
    private ArrayList<Package> searchPackages() {
        // Upplýsingum sem notaðar eru gefnar sér breytur til að minnka clutter.
        String orig = customer.getOrigin();
        String dest = customer.getDestination();
        Calendar depDate = customer.getDepartureDate();
        Calendar retDate = customer.getReturnDate();
        int paxCount = customer.getNumOfTravelers();
       
        
        // Kallað á leitir fyrir flug fram og til baka.
        ArrayList<Flight> outboundFlights = flightSearcher.searchFlights( orig, dest, depDate, depDate, paxCount );
        ArrayList<Flight> returnFlights = flightSearcher.searchFlights( dest, orig, depDate, depDate, paxCount );
        
        
        // Kallað á leitir fyrir hótel.
        ArrayList<Hotel> hotels = hotelSearcher.searchHotels( dest, depDate, retDate );
       
        
        // Calendar notað til að bæta einum degi við til að finna ferð
        // daginn eftir að farþegi er kominn.
        Calendar c = (Calendar) depDate.clone();
        c.add( Calendar.DATE, 1 );
        Date tourDate = c.getTime();
        
        // Kallað á leitir fyrir dagsferðir.  
        ArrayList<DayTour> dayTours = dayTourSearcher.searchDayTours( dest, tourDate, paxCount );

        // Kom í veg fyrir að eitthvað sé null
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
    
    /* Nota sort fall í Collections og Comparator frá CompPackage til að raða pökkunum */
    public void sortPackages(String orderBy) {
        Collections.sort(packages, CompPackage.compPackages(orderBy));
    }
    
    // Þrengir niðurstöður eftir verði
    public void filterByPrice(int min, int max) {
        if(max < min) return;
        for(int i = 0; i < packages.size(); i++) {
            if(min > 0 && packages.get(i).getPrice() < min) {
                packages.remove(i);
                i--;
            }
            else if(max > 0 && packages.get(i).getPrice() > max) {
                packages.remove(i);
                i--;
            }
        }
    }
	
   /* Fall til að bóka pakka */
    public void bookPackage(Package pack) {
        flightSearcher.bookFlight( pack.getFlight()[0] );
        flightSearcher.bookFlight( pack.getFlight()[1] );
        hotelSearcher.bookHotel( pack.getHotel() );
        dayTourSearcher.bookDayTour( pack.getDayTour() );
    }
    
    public ArrayList<Package> getPackages() {
        return packages;
    }
}
