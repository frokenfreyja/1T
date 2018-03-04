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
    public String[][] search() {
        String[][] data = new String[10][3];
        
        String[] loc = new String[10];
        String[] name = new String[10];
        String[] price = new String[10];
        
        
        
        
        int n = 10;
        for(int i = 0; i < n; i++) {
            data[i][0] = loc[i]; 
            data[i][1] = name[i];
            data[i][2] = price[i];
        }
        
        
        return data;
    }     
    public void book() {
        
    }
}
