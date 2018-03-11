/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triphop.testAPI;

/**
 * 
 * @author Elvar 
 */
public class TourAPI {
    public Object[][] search() { 
        // name, country, city, price
        Object[][] data = new Object[][] {
             { "Biking Around Reykjavík", "Iceland", "Reykjavík", 2500 }
            ,{ "Biking Around Nairobi", "Kenya", "Nairobi", 103 }
            ,{ "Strolling Around ", "", "", }
            ,{ "Strolling Around ", "", "", }
            ,{ "Skiing On Afriski", "Afriski", "Lesotho", }
            ,{ "Skiing On ", "", "", }
            ,{ "Golf", "", "", }
            ,{ "Golf", "", "", }
        };
        
        return data;
    }     
    public void book() {
        
    }
}
