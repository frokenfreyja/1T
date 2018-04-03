/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triphop.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import triphop.model.DayTour;

/**
 *
 * @author Elvar Árni Sturluson
 */
public class MockRandomDayTourSearcher implements DayTourSearcher {
    public ArrayList<DayTour> searchDayTours(
            String location
            ,Date date
    ) {
        String[] locations = new String[]{
            "Reykjavík", "Akureyri", "New York", "Milano", "Alicante", "Tokyo", 
            "París", "Madrid", "Berlin"
        };
        ArrayList<DayTour> arr = new ArrayList<>();
        Random rand = new Random();
        for( int i = 0; i < 50; i++ ) {
            int x = rand.nextInt( locations.length );

            DayTour daytour = new DayTour( locations[x] );
            arr.add( daytour );
        }
        
        return arr;
    };
    
    public static void main(String[] args) {
        DayTourSearcher s = new MockRandomDayTourSearcher();
        ArrayList<DayTour> daytours = s.searchDayTours( "", new Date());
        for( DayTour daytour : daytours ) {
            System.out.println( daytour.getLocation() );
        }
    }
}
