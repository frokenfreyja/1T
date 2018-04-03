/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triphop.model;

/**
 *
 * @author Elvar Árni Sturluson
 */
public class DayTour {
    final private String location;
    
    public DayTour(String inLocation) {
        location = inLocation;
    }
          
    public String getLocation() {
        return location;
    }
}
