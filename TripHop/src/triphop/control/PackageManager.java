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
    private FlightSearcher flightSearcher = new FlightSearcherAdapter();
    private HotelSearcher hotelSearcher = new HotelSearcherAdapter();
    private DayTourSearcher dayTourSearcher = new DayTourSearcherAdapter();
    
    // Object sem mun innihalda leitarupplýsingar
    private Customer customer;
    
    // Object sem verður listi af pökkunum
    private ArrayList<Package> packages;
	
    /* Smiðurinn fyrir PackageManager */
    public PackageManager(
            Customer customerInfo
    ) {
        customer = customerInfo;
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
        ArrayList<DayTour> dayTours = dayTourSearcher.searchDayTours( dest, tourDate, customer.getTheme(), paxCount );

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
    public ArrayList<Package> sortPackages(String orderBy) {
        ArrayList<Package> packSorted = (ArrayList<Package>) packages.clone();
        Collections.sort(packSorted, CompPackage.compPackages(orderBy));
        return packSorted;
    }
    
    // Þrengir niðurstöður eftir verði
    public ArrayList<Package> filterByPrice(int min, int max) {
        
        if(max < min) return packages;
        ArrayList<Package> filteredPack = (ArrayList<Package>) packages.clone();
        Iterator<Package> iter = filteredPack.iterator();
        while(iter.hasNext()){
            Package pack = iter.next();
            if(min > 0 && pack.getCost() < min) {
                iter.remove();
            }
            else if(max > 0 && pack.getCost() > max) {
                iter.remove();
            }
        }
        return filteredPack;
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
    
    public static void main( String[] args ) {
        Calendar depDate = Calendar.getInstance();
        depDate.set( 2018, 4, 20 );
        
        Calendar arrDate = Calendar.getInstance();
        arrDate.set( 2018, 4, 20 ); 
        
        Customer customer = new Customer( depDate, arrDate, "Keflavik", "Paris", 2, 0, "Museums" );
        PackageManager packagemanager = new PackageManager( customer );
        for( Package pack : packagemanager.getPackages() ) {
            
            System.out.println( "--Flight 1--" );
            System.out.println( pack.getFlight()[0].getDeparture() );
            System.out.println( pack.getFlight()[0].getArrival() );
            System.out.println( pack.getFlight()[0].getCost() );
            System.out.println( "--Flight 2--" );
            System.out.println( pack.getFlight()[1].getDeparture() );
            System.out.println( pack.getFlight()[1].getArrival() );
            System.out.println( pack.getFlight()[1].getCost() );
            System.out.println( "--Hotel--" );
            System.out.println( pack.getHotel().getName() );
            System.out.println( pack.getHotel().getLocation() );
            System.out.println( pack.getHotel().getCost() );
            System.out.println( "--DayTour--" );
            System.out.println( pack.getDayTour().getName() );
            System.out.println( pack.getDayTour().getLocation() );
            System.out.println( pack.getDayTour().getCost() );
            System.out.println( pack.getDayTour().getActivity() );
        }
    }
}
