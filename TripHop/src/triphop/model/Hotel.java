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
public class Hotel {
    final private String location;
    
    public Hotel(String inLocation) {
        location = inLocation;
    }
          
    public String getLocation() {
        return location;
    }
}
