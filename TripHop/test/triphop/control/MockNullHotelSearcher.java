/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triphop.control;

import java.util.ArrayList;
import java.util.Date;
import triphop.model.Hotel;

/**
 *
 * @author Elvar Árni Sturluson
 */
public class MockNullHotelSearcher implements HotelSearcher {
    public ArrayList<Hotel> searchHotels(
            String location
            ,Date checkInDate
            ,Date checkOutDate
    ) {
      return null;  
    };
}
