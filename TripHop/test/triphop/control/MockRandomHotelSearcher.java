/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triphop.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import triphop.model.Hotel;

/**
 *
 * @author User
 */
public class MockRandomHotelSearcher implements HotelSearcher {
    public ArrayList<Hotel> searchHotels(
            String location
            ,Date checkInDate
            ,Date checkOutDate
    ) {
        String[] locations = new String[]{
            "Reykjavík", "Akureyri", "New York", "Milano", "Alicante", "Tokyo", 
            "París", "Madrid", "Berlin"
        };
        ArrayList<Hotel> arr = new ArrayList<>();
        Random rand = new Random();
        for( int i = 0; i < 50; i++ ) {
            int x = rand.nextInt( locations.length );

            Hotel hotel = new Hotel( locations[x] );
            arr.add( hotel );
        }
        
        return arr;
    };
    
    public static void main(String[] args) {
        HotelSearcher s = new MockRandomHotelSearcher();
        ArrayList<Hotel> hotels = s.searchHotels( "", new Date(), new Date());
        for( Hotel hotel : hotels ) {
            System.out.println( hotel.getLocation() );
        }
    }
}
