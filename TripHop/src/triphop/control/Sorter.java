package triphop.control;

import java.util.ArrayList;
import java.util.Arrays;

import triphop.model.*;
import triphop.model.Package;

/**
 *
 * @author Ragnar
 */
public class Sorter {
    public static ArrayList<Package> sortPackages(ArrayList<Package> packages, String orderBy) {
        ArrayList<Package> sortedPackages = new ArrayList<Package>();
        if(orderBy.equals("location")) {
            sortedPackages = sortByLoc(packages);
        }
        else if(orderBy.equals("price")) {
            sortedPackages = sortByPrice(packages);
        }
        else {
            return packages;
        }
        return sortedPackages;
    }
    
    private static ArrayList<Package> sortByLoc(ArrayList<Package> packages) {
        ArrayList<Package> sortedPackages = new ArrayList<Package>();
        String[] locations = new String[packages.size()];
        for(int i = 0; i < locations.length; i++) {
            locations[i] = packages.get(i).getHotel().getLocation();
        }
        Arrays.sort(locations);
        for(int i = 0; i < locations.length; i++) {
            for(int j = 0; j < packages.size(); j++) {
                if(locations[i].equals(packages.get(j).getHotel().getLocation())) {
                    sortedPackages.add(packages.get(j));
                    packages.remove(j);
                    break;
                }
            }
        }
        return sortedPackages;
    }
    
    private static ArrayList<Package> sortByPrice(ArrayList<Package> packages) {
        ArrayList<Package> sortedPackages = new ArrayList<Package>();
        int[] prices = new int[packages.size()];
        for(int i = 0; i < prices.length; i++) {
            prices[i] = packages.get(i).getPrice();
        }
        Arrays.sort(prices);
        for(int i = 0; i < prices.length; i++) {
            for(int j = 0; j < packages.size(); j++) {
                if(prices[i] == packages.get(j).getPrice()) {
                    sortedPackages.add(packages.get(j));
                    packages.remove(j);
                    break;
                }
            }
        }
        return sortedPackages;
    }    
}
