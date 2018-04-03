/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triphop.model;

import java.util.Date;
import triphop.control.FlightSearcher;


/**
 *
 * @author Elvar Árni Sturluson
 */
public class Flight {
    final private String departure; 
    final private String arrival;
    
    public Flight(String inDeparture, String inArrival) {
        departure = inDeparture;
        arrival = inArrival;
    }
    
    public String getDeparture() {
        return departure;
    }
    
    public String getArrival() {
        return arrival;
    }
    
}
