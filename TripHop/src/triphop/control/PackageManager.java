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
        ArrayList<Flight[]> flights = this.flightSearch.searchFlights(orig, dest, depDate, depDate, paxCount);
        
        if(hotels == null || dayTours == null ||
                flights == null)
        {
            return null;
        } 
        
        // Listarnir hér að ofan mataðir í assemblePackages fallið þar sem þeir verða settir saman.
        return assemblePackages(flights, hotels, dayTours);
    }
	
    public ArrayList<Package> assemblePackages(ArrayList<Flight[]> flights, 
                                                ArrayList<Hotel> hotels,
                                                ArrayList<DayTour> dayTours) {
        // Fjöldi dagsferða, á ekki að vera 0 (ekki hægt að velja 0 dagsferðir sem notandi).
        int numOfDayTours = this.customer.getNumOfDayTours();
        // Fjöldi samsetninga af pökkum sem búinn verður til.
        int numOfPackages = flights.size() * hotels.size() * dayTours.size();
        // Númer pakka, notað til að setja inn í packages arraylista.
        int packageNumber;
        // Listinn af pökkunum, sem verið er að búa til.
        ArrayList<Package> packages = new ArrayList<Package>();

        for(int i = 0; i < flights.size(); i++) {
            // Breyta notuð til að staðfesta að um sama stað sé að ræða þegar 
            // pakka er púslað saman.
            String flightLoc = flights.get(i)[0].getArrival();
           
            for(int j = 0; j < hotels.size(); j++) {
                // Eins og flightLoc
                String hotelLoc = hotels.get(j).getLocation();
                for(int k = 0; k < dayTours.size(); k++) {
                    // Eins og flightLoc
                    String dayTourLoc = dayTours.get(k).getLocation();
                    // Gáð hvort flug fer á sama stað og hótel er bókað
                    // Ef ekki er næsta hótel skoðað
                    if(!flightLoc.equals(hotelLoc)) break;
                    // Gáð hvort dagsferð sé frá sama stað og hótelið.
                    // Ef ekki er kíkt á næstu dagsferð.
                    while(!hotelLoc.equals(dayTourLoc)) {
                        k++;
                        dayTourLoc = dayTours.get(k).getLocation();
                    }
                    
                    // Ath. hvort komið sé út á enda á einhverjum listanum, ef svo er þá hætt.
                    if(flights.get(i) == null || hotels.get(j) == null || dayTours.get(k) == null) break;
                    packageNumber = (i * j) + k;
                    // Nýr pakki búinn til og honum bætt í listann.
                    Package pack = new Package(flights.get(i), hotels.get(j), dayTours.get(k));
                    packages.add(packageNumber, pack);
                }
            }
        }
		
        return packages;
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
