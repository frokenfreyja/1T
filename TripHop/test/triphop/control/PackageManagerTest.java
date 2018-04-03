/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triphop.control;

import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import triphop.model.Package;
/**
 *
 * @author Henrietta Þóra Magnúsdóttir
 * @author Freyja Sigurgísladóttir
 */
public class PackageManagerTest {
  	
    private PackageManager pManager;
    private MockRandomFlightSearcher mFlight; 
    private MockRandomHotelSearcher mHotel;
    private MockRandomDayTourSearcher mDayTour;
    private Customer customer;
  
    
    @Before
    public void setUp() {
      customer = new Customer(new Date(), new Date(), "Reykjavík", "Milano", 4, 2, "City");
      
    }
    
    @After
    public void tearDown() {
        customer = null;	
    }
  
  	
    /* Test 1 - Athuga hegðun þegar ein leitavélin (f. hótel) gefur null  */
    @Test
    public void testNull() {
        pManager = new PackageManager(
            customer
            ,new MockRandomFlightSearcher()
            ,new MockNullHotelSearcher()
            ,new MockRandomDayTourSearcher()
        );
        ArrayList<Package> packages = pManager.searchPackages();
      
        assertNull(packages);
    };
  
    /* Test 2 - Athuga hegðun þegar ein leitavélin (f. hótel) gefur empty */
    @Test
    public void testEmpty() {
        pManager = new PackageManager(
            customer
            ,new MockRandomFlightSearcher()
            ,new MockEmptyHotelSearcher()
            ,new MockRandomDayTourSearcher()
        );
        ArrayList<Package> packages = pManager.searchPackages(); 
        
        assertNotNull(packages);
        assertTrue( packages.isEmpty() );
    };
  
    /* Test 3 - Athuga hvort að flugið, hótelið og dagsferðin sé ekki með viðeigandi borg */ 
    @Test
    public void testEqualCity() {
        pManager = new PackageManager(
            customer
            ,new MockRandomFlightSearcher()
            ,new MockEmptyHotelSearcher()
            ,new MockRandomDayTourSearcher()
        );
        ArrayList<Package> packages = pManager.searchPackages();
      
        assertNotNull(packages);
        for(Package pack : packages ) {
            assertTrue(pack.getFlight()[0].getDeparture().equals(pack.getHotel().getLocation()));
            assertTrue(pack.getHotel().getLocation().equals(pack.getDayTour().getLocation()));
        }
    };
}