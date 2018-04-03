/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triphop.control;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
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
      pManager = new PackageManager(customer);
    }
    
    @After
    public void tearDown() {
        customer = null;
        pManager = null;
      	
    }
  
  	
  	/* Test 1 - Athuga hegðun þegar ein leitavélin (f. hótel) gefur null  */
  	@Test
  	public void testNull() {
      ArrayList<Package> packages = pManager.searchPackages(
      	new MockRandomFlightSearcher()
        ,new MockNullHotelSearcher()
        ,new MockRandomDayTourSearcher()
      );
      
      assertNull(packages);
    };
  
  	/* Test 2 - Athuga hegðun þegar ein leitavélin (f. hótel) gefur empty */
  	@Test
  	public void testEmpty() {
      ArrayList<Package> packages = pManager.searchPackages(
      	new MockRandomFlightSearcher()
        ,new MockEmptyHotelSearcher()
        ,new MockRandomDayTourSearcher()
      );
      
      assertNotNull(packages);
      assertTrue( packages.isEmpty() );
    };
  
  	/* Test 3 - Athuga hvort að flugið, hótelið og dagsferðin sé ekki með viðeigandi borg */ 
  	@Test
  	public void testEqualCity() {
       ArrayList<Package> packages = pManager.searchPackages(
      	new MockRandomFlightSearcher()
        ,new MockEmptyHotelSearcher()
        ,new MockRandomDayTourSearcher()
      );
      
      assertNotNull(packages);
      for(Package pack : packages ) {
        assertEqual( pack.getFlight()[0].getDeparture(), pack.getHotel().getLocation() );
        assertEqual( pack.getHotel().getLocation(), pack.getDayTour.getLocation() );
      }
    };
}