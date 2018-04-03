/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triphop.control;

import triphop.model.Package;
import java.util.*;

/**
 *
 * @author Elvar Árni
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
	
    public PackageManager(Customer customerInfo, FlightSearcher inFlightSearcher,
                          HotelSearcher inHotelSearcher, DayTourSearcher inDayTourSearcher) {
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
        ArrayList<Flight> returnFlights = this.flightSearch.searchFlights(dest, orig, retDate, retDate, paxCount);
        // Gáð hvort nokkur listi sé tómur áður en lengra er haldið
        // Ef eitthvað vantar er ekki hægt að búa til neina pakka og því tómum
        // lista af pökkum skilað.
        if(hotels.get(0) == null || dayTours.get(0) == null ||
                outboundFlights.get(0) == null || returnFlights.get(0) == null)
        {
            return new ArrayList<Package>(0);
        }
        
        // outbound og return flug sameinuð.
        ArrayList<Flight[]> flights = new ArrayList<Flight[]>(outboundFlights.size()*returnFlights.size());
        // Par af flugum fram og til baka sem verður bætt við listan að ofan.
        Flight[] addFlights = new Flight[2];
        // Fjöldi fluga sem fara á áfangastað.
        int numOutbound = outboundFlights.size();
        // Fjöldi fluga sem fara heim.
        int numReturn = returnFlights.size();
        int flightIndex = 0;
        for(int i = 0; i < numOutbound; i++) {
            if(null == outboundFlights.get(i)) break;
            addFlights[0] = outboundFlights.get(i);
            for(int j = 0; j < numReturn; j++) {
                if(null == returnFlights.get(j)) break;
                addFlights[1] = returnFlights.get(j);
                // Númer þess pars sem er verið að setja inn, talið frá 0.
                flightIndex = numOutbound*i - 1 + j;
                flights.add(flightIndex, addFlights);
            }
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
                    // Þær dagsferðir sem verða settar í pakkann.
                    ArrayList<DayTour> packageTours = new ArrayList<DayTour>(numOfDayTours);
                    if (numOfDayTours != 0) packageTours.add(0, dayTours.get(k));
                     
                    // Ef beðið var um fleiri en eina dagsferð eru fundnar aðrar af handahófi.
                    // Ef beðið er um fleiri dagsferðir en leit hefur fundið er aðeins gefin ein dagsferð.
                    if(numOfDayTours > 1 && numOfDayTours < dayTours.size()) {
                        int[] selectedTours = new int[numOfDayTours];
                        selectedTours[0] = k;
                        // Byrja á að setja stök fylkisins sem -1, svo hægt sé að gá
                        // hvort búið sé að setja inn í það seinna
                        for(int o = 1; o < selectedTours.length; o++) {
                            selectedTours[o] = -1;
                        }
                        for(int p = 1; p < numOfDayTours; p++) {
                            // Dagsferð valin af handahófi til að hafa með hinum dagsferðum þessa pakka.
                            int randomTour; 
                            randomTour = (int) Math.floor(Math.random() * dayTours.size());
                            int x = 0;
                            // Gáð hvort sama dagsferð hafi verið valin áður
                            while(x < numOfDayTours) {
                                // Ef ekkert hefur verið sett inn enn
                                if(selectedTours[x] == -1) break;
                                    // Ef hitt er óvart ferð sem var valin áður er ný valin af handahófi
                                    // og byrjað upp á nýtt að bera saman.
                                if(randomTour == selectedTours[x]) {
                                    randomTour = (int) Math.floor(Math.random() * dayTours.size());
                                    x = 0;
                                }
                                // Ef tölurnar eru ekki eins eru þær næstu bornar saman.
                                else x++;
                            }
                            // Valinn túr merktur inn svo hann verði ekki valinn aftur.
                            selectedTours[p] = randomTour;
                            // Völdum túr bætt inn.
                            packageTours.add(p, dayTours.get(randomTour));
                        }
                    }
                     
                    // Nýr pakki búinn til og honum bætt í listann.
                    Package pack = new Package(flights.get(i), hotels.get(j), packageTours);
                    packages.add(packageNumber, pack);
                }
            }
        }
		
        return packages;
    }
	
    public void sortPackages(String field, String orderBy) {
        // Ekkert enn.
    }
	
    public void bookPackage(int index) {
        // Ekkert enn.
    }
	
    private void showPackages() {
        // Ekkert enn.
    }
}
