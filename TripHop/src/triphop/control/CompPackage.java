package triphop.control;

import java.util.Comparator;

import triphop.model.*;
import triphop.model.Package;
import triphop.model.Package;

/**
 *
 * @author Ragnar
 */
public class CompPackage {
    public static Comparator<Package> compPackages(String orderBy) {
        if(orderBy.equalsIgnoreCase("location")) {
            return getCompByLoc();
        }
        else if(orderBy.equalsIgnoreCase("cost")) {
            return getCompByCost();
        }
        return getCompByCost();                
    }
    
    private static Comparator<Package> getCompByLoc() {
        Comparator comp = new Comparator<Package>() {
            @Override
            public int compare(Package p1, Package p2) {
                String loc1 = p1.getHotel().getLocation();
                String loc2 = p2.getHotel().getLocation();
                return loc1.compareTo(loc2);
            }
        };
        return comp;
    }
    
    private static Comparator<Package> getCompByCost() {
        Comparator comp = new Comparator<Package>() {
            @Override
            public int compare(Package p1, Package p2) {
                if(p1.getCost() < p2.getCost()) {
                    return -1;
                }
                else if(p1.getCost() > p2.getCost()) {
                    return 1;
                }
                else {
                    return 0;
                }
            }
        };
        return comp;
    }    
}
