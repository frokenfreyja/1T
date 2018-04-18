/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triphop.view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import triphop.control.*;
import triphop.model.*;


/**
 *
 * @author Freyja Sigurgísladóttir, frs24@hi.is
 * @author Henrietta Þóra Magnúsdóttir, hthm6@hi.is
 */
public class MainFrame extends javax.swing.JFrame {
    private Boolean flagLang = false;
    private JPanel[] panelar;
        
    // Controllerar fyrir hinar þrjár leitarvélarnar
    private FlightSearcher flightSearcher;
    private HotelSearcher hotelSearcher;
    private DayTourSearcher dayTourSearcher;
    // Object sem mun innihalda leitarupplýsingar
    private Customer customer;

    private PackageManager pMan;
    private DefaultTableModel model;
    private String[] lond;
    private InformationDialog info;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        String lang = Locale.getDefault().toString();
        String en = new Locale("en_GB").toString();
        if(lang.equals(en)) {
            jLanguage.setSelectedIndex(1);
        }
        JTable jResultTable = new JTable();
        flagLang = true;

        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        
        StretchIcon backImg = createImg("img/back3.png");
        jBackButton.setIcon(backImg);
        StretchIcon sunImg = createImg("img/sun.png");
        jButton2.setIcon(sunImg);
        StretchIcon skiImg = createImg("img/ski.png");
        jButton3.setIcon(skiImg);
        StretchIcon golfImg = createImg("img/golf.png");
        jButton4.setIcon(golfImg);
        StretchIcon cityImg = createImg("img/city.png");
        jButton9.setIcon(cityImg);
        StretchIcon crowdImg = createImg("img/crowd.png");
        jButton10.setIcon(crowdImg);
        StretchIcon hikeImg = createImg("img/hike.png");
        jButton11.setIcon(hikeImg);
        StretchIcon familyImg = createImg("img/family.png");
        jButton12.setIcon(familyImg);
        
        StretchIcon offdenmarkImg = createImg("img/flagdenmark.png");
        jButton73.setIcon(offdenmarkImg);
        StretchIcon offfranceImg = createImg("img/flagfrance.png");
        jButton74.setIcon(offfranceImg);
        StretchIcon offturkeyImg = createImg("img/flagturkey.png");
        jButton75.setIcon(offturkeyImg);
        StretchIcon offgreeceImg = createImg("img/flaggreece.png");
        jButton76.setIcon(offgreeceImg);
        StretchIcon offukImg = createImg("img/flaguk.png");
        jButton137.setIcon(offukImg);
        StretchIcon offaustriaImg = createImg("img/flagaustria.png");
        jButton138.setIcon(offaustriaImg);
        StretchIcon offusaImg = createImg("img/flagusa.png");
        jButton139.setIcon(offusaImg);
        StretchIcon offnorwayImg = createImg("img/flagnorway.png");
        jButton140.setIcon(offnorwayImg);
        
        StretchIcon golfusaImg = createImg("img/golfusa.png");
        jButton41.setIcon(golfusaImg);
        StretchIcon golfukImg = createImg("img/golfuk.png");
        jButton42.setIcon(golfukImg);
        StretchIcon golfscotlandImg = createImg("img/golfscotland.png");
        jButton43.setIcon(golfscotlandImg);
        StretchIcon golfspainImg = createImg("img/golfspain.png");
        jButton44.setIcon(golfspainImg);
        StretchIcon golffranceImg = createImg("img/golffrance.png");
        jButton61.setIcon(golffranceImg);
        StretchIcon golfswedenImg = createImg("img/golfsweden.png");
        jButton62.setIcon(golfswedenImg);
        StretchIcon golfgreeceImg = createImg("img/golfgreece.png");
        jButton63.setIcon(golfgreeceImg);
        StretchIcon golfportugalImg = createImg("img/golfportugal.png");
        jButton64.setIcon(golfportugalImg);
        
        StretchIcon greeceImg = createImg("img/greece.png");
        jButton25.setIcon(greeceImg);
        StretchIcon italysunImg = createImg("img/sunvacitaly.png");
        jButton26.setIcon(italysunImg);
        StretchIcon portugalsunImg = createImg("img/sunvacportugal.png");
        jButton27.setIcon(portugalsunImg);
        StretchIcon spainsunImg = createImg("img/sunvacspain.png");
        jButton28.setIcon(spainsunImg);
        StretchIcon usasunImg = createImg("img/sunvacusa.png");
        jButton40.setIcon(usasunImg);
        StretchIcon mexicosunImg = createImg("img/sunvacmexico.png");
        jButton45.setIcon(mexicosunImg);
        StretchIcon turkeysunImg = createImg("img/sunvacturkey.png");
        jButton46.setIcon(turkeysunImg);
        StretchIcon indonesiasunImg = createImg("img/sunvacindonesia.png");
        jButton47.setIcon(indonesiasunImg);
        
        StretchIcon austriaImg = createImg("img/austria.png");
        jButton17.setIcon(austriaImg);
        StretchIcon franceskiImg = createImg("img/skiingfrance.png");
        jButton18.setIcon(franceskiImg);
        StretchIcon italyskiImg = createImg("img/skiingitaly.png");
        jButton19.setIcon(italyskiImg);
        StretchIcon switchskiImg = createImg("img/skiingswiss.png");
        jButton20.setIcon(switchskiImg);
        StretchIcon swedenskiImg = createImg("img/skiingsweden.png");
        jButton29.setIcon(swedenskiImg);
        StretchIcon norwayskiImg = createImg("img/skiingnorway.png");
        jButton30.setIcon(norwayskiImg);
        StretchIcon icelandskiImg = createImg("img/skiingiceland.png");
        jButton31.setIcon(icelandskiImg);
        StretchIcon usaskiImg = createImg("img/skiingusa.png");
        jButton32.setIcon(usaskiImg);
        
        StretchIcon cityusaImg = createImg("img/cityusa.png");
        jButton49.setIcon(cityusaImg);
        StretchIcon citydenmarkImg = createImg("img/citydenmark.png");
        jButton50.setIcon(citydenmarkImg);
        StretchIcon cityitalyImg = createImg("img/cityitaly.png");
        jButton51.setIcon(cityitalyImg);
        StretchIcon cityswedenImg = createImg("img/citysweden.png");
        jButton52.setIcon(cityswedenImg);
        StretchIcon citynorwayImg = createImg("img/citynorway.png");
        jButton69.setIcon(citynorwayImg);
        StretchIcon cityspainImg = createImg("img/cityspain.png");
        jButton70.setIcon(cityspainImg);
        StretchIcon cityukImg = createImg("img/cityuk.png");
        jButton71.setIcon(cityukImg);
        StretchIcon cityfranceImg = createImg("img/cityfrance.png");
        jButton72.setIcon(cityfranceImg);
        
        StretchIcon eventusaImg = createImg("img/eventusa.png");
        jButton57.setIcon(eventusaImg);
        StretchIcon event2ukImg = createImg("img/event2uk.png");
        jButton58.setIcon(event2ukImg);
        StretchIcon eventdenmarkImg = createImg("img/eventdenmark.png");
        jButton59.setIcon(eventdenmarkImg);
        StretchIcon eventfranceImg = createImg("img/eventfrance.png");
        jButton60.setIcon(eventfranceImg);
        StretchIcon eventswedenImg = createImg("img/eventsweden.png");
        jButton77.setIcon(eventswedenImg);
        StretchIcon eventportugalImg = createImg("img/eventportugal.png");
        jButton78.setIcon(eventportugalImg);
        StretchIcon eventspainImg = createImg("img/eventspain.png");
        jButton79.setIcon(eventspainImg);
        StretchIcon eventaustriaImg = createImg("img/eventaustria.png");
        jButton80.setIcon(eventaustriaImg);
        
        StretchIcon outaustriaImg = createImg("img/outaustria.png");
        jButton33.setIcon(outaustriaImg);
        StretchIcon outicelandImg = createImg("img/outiceland.png");
        jButton34.setIcon(outicelandImg);
        StretchIcon outitalyImg = createImg("img/outitaly.png");
        jButton35.setIcon(outitalyImg);
        StretchIcon outswissImg = createImg("img/outswiss.png");
        jButton36.setIcon(outswissImg);
        StretchIcon outmexicoImg = createImg("img/outmexico.png");
        jButton53.setIcon(outmexicoImg);
        StretchIcon outfranceImg = createImg("img/outfrance.png");
        jButton54.setIcon(outfranceImg);
        StretchIcon outturkeyImg = createImg("img/outturkey.png");
        jButton55.setIcon(outturkeyImg);
        StretchIcon outusaImg = createImg("img/outusa.png");
        jButton56.setIcon(outusaImg);
        
        StretchIcon famusaImg = createImg("img/famusa.png");
        jButton65.setIcon(famusaImg);
        StretchIcon famdenmarkImg = createImg("img/famdenmark.png");
        jButton66.setIcon(famdenmarkImg);
        StretchIcon famitalyImg = createImg("img/famitaly.png");
        jButton67.setIcon(famitalyImg);
        StretchIcon famfranceImg = createImg("img/famfrance.png");
        jButton68.setIcon(famfranceImg);
        StretchIcon famukImg = createImg("img/famuk.png");
        jButton129.setIcon(famukImg);
        StretchIcon famturkeyImg = createImg("img/famturkey.png");
        jButton130.setIcon(famturkeyImg);
        StretchIcon famgreeceImg = createImg("img/famgreece.png");
        jButton131.setIcon(famgreeceImg);
        StretchIcon famspainImg = createImg("img/famspain.png");
        jButton132.setIcon(famspainImg);
        

        StretchIcon plane = createImg("img/plane.png");
        jFinalPic.setIcon(plane);
        
        panelar = new JPanel[]{jFrontPanel,jRegistrationPanel,
            jResultPanel,jSkiPanel,jOfferPanel,jGolfPanel,jSunPanel,
            jEventPanel,jFamilyPanel,jOutdoorPanel,jCityPanel,jOpenPackagePanel,
            jRegResultsPanel,jFinalPanel};
        
        lond = new String[]{"London","Paris"};
        
        info = new InformationDialog(this,false);

      
    }
    
     /**
     * Aðferð sem sækir mynd og býr hana til með StretchIcon
     * @param path
     * @return 
     */
    private static StretchIcon createImg(String path) {
        java.net.URL imgURL = MainFrame.class.getResource(path);
        if (imgURL != null) {
            return new StretchIcon(imgURL);
        } else {
            System.err.println("Fann ekki skrána " + path);
            return null;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jMainPanel = new javax.swing.JPanel();
        jBottom = new javax.swing.JPanel();
        jFrontPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton145 = new javax.swing.JButton();
        jButton146 = new javax.swing.JButton();
        jButton147 = new javax.swing.JButton();
        jButton148 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jFrom = new javax.swing.JTextField();
        jTo = new javax.swing.JTextField();
        departureDate = new com.github.lgooddatepicker.components.DatePicker();
        arrivalDate = new com.github.lgooddatepicker.components.DatePicker();
        jPassengers = new javax.swing.JComboBox<>();
        jSearch = new javax.swing.JButton();
        jRegistrationPanel = new javax.swing.JPanel();
        JLabel7 = new javax.swing.JLabel();
        jFirstName = new javax.swing.JTextField();
        jLastName = new javax.swing.JTextField();
        jAddress = new javax.swing.JTextField();
        jCity = new javax.swing.JTextField();
        JLabel1 = new javax.swing.JLabel();
        jZip = new javax.swing.JTextField();
        JLabel2 = new javax.swing.JLabel();
        jCountry = new javax.swing.JTextField();
        JLabel3 = new javax.swing.JLabel();
        jPhone = new javax.swing.JTextField();
        JLabel4 = new javax.swing.JLabel();
        jReset = new javax.swing.JButton();
        JLabel5 = new javax.swing.JLabel();
        jOk = new javax.swing.JButton();
        JLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JLabel8 = new javax.swing.JLabel();
        jEmail = new javax.swing.JTextField();
        jResultPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jResultTable = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        jSkiPanel = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jButton81 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jButton109 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jSunPanel = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jButton24 = new javax.swing.JButton();
        jButton82 = new javax.swing.JButton();
        jButton83 = new javax.swing.JButton();
        jButton84 = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        jButton40 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        jButton48 = new javax.swing.JButton();
        jButton110 = new javax.swing.JButton();
        jButton111 = new javax.swing.JButton();
        jButton112 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jOutdoorPanel = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jButton85 = new javax.swing.JButton();
        jButton86 = new javax.swing.JButton();
        jButton87 = new javax.swing.JButton();
        jButton88 = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        jButton53 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        jButton55 = new javax.swing.JButton();
        jButton56 = new javax.swing.JButton();
        jPanel28 = new javax.swing.JPanel();
        jButton113 = new javax.swing.JButton();
        jButton114 = new javax.swing.JButton();
        jButton115 = new javax.swing.JButton();
        jButton116 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jGolfPanel = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jButton89 = new javax.swing.JButton();
        jButton90 = new javax.swing.JButton();
        jButton91 = new javax.swing.JButton();
        jButton92 = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        jButton61 = new javax.swing.JButton();
        jButton62 = new javax.swing.JButton();
        jButton63 = new javax.swing.JButton();
        jButton64 = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        jButton117 = new javax.swing.JButton();
        jButton118 = new javax.swing.JButton();
        jButton119 = new javax.swing.JButton();
        jButton120 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jCityPanel = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jButton49 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jButton52 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jButton93 = new javax.swing.JButton();
        jButton94 = new javax.swing.JButton();
        jButton95 = new javax.swing.JButton();
        jButton96 = new javax.swing.JButton();
        jPanel31 = new javax.swing.JPanel();
        jButton69 = new javax.swing.JButton();
        jButton70 = new javax.swing.JButton();
        jButton71 = new javax.swing.JButton();
        jButton72 = new javax.swing.JButton();
        jPanel32 = new javax.swing.JPanel();
        jButton121 = new javax.swing.JButton();
        jButton122 = new javax.swing.JButton();
        jButton123 = new javax.swing.JButton();
        jButton124 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jEventPanel = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jButton57 = new javax.swing.JButton();
        jButton58 = new javax.swing.JButton();
        jButton59 = new javax.swing.JButton();
        jButton60 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jButton97 = new javax.swing.JButton();
        jButton98 = new javax.swing.JButton();
        jButton99 = new javax.swing.JButton();
        jButton100 = new javax.swing.JButton();
        jPanel33 = new javax.swing.JPanel();
        jButton77 = new javax.swing.JButton();
        jButton78 = new javax.swing.JButton();
        jButton79 = new javax.swing.JButton();
        jButton80 = new javax.swing.JButton();
        jPanel34 = new javax.swing.JPanel();
        jButton125 = new javax.swing.JButton();
        jButton126 = new javax.swing.JButton();
        jButton127 = new javax.swing.JButton();
        jButton128 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jFamilyPanel = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jButton65 = new javax.swing.JButton();
        jButton66 = new javax.swing.JButton();
        jButton67 = new javax.swing.JButton();
        jButton68 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jButton101 = new javax.swing.JButton();
        jButton102 = new javax.swing.JButton();
        jButton103 = new javax.swing.JButton();
        jButton104 = new javax.swing.JButton();
        jPanel35 = new javax.swing.JPanel();
        jButton129 = new javax.swing.JButton();
        jButton130 = new javax.swing.JButton();
        jButton131 = new javax.swing.JButton();
        jButton132 = new javax.swing.JButton();
        jPanel36 = new javax.swing.JPanel();
        jButton133 = new javax.swing.JButton();
        jButton134 = new javax.swing.JButton();
        jButton135 = new javax.swing.JButton();
        jButton136 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jOfferPanel = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jButton73 = new javax.swing.JButton();
        jButton74 = new javax.swing.JButton();
        jButton75 = new javax.swing.JButton();
        jButton76 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jButton105 = new javax.swing.JButton();
        jButton106 = new javax.swing.JButton();
        jButton107 = new javax.swing.JButton();
        jButton108 = new javax.swing.JButton();
        jPanel37 = new javax.swing.JPanel();
        jButton137 = new javax.swing.JButton();
        jButton138 = new javax.swing.JButton();
        jButton139 = new javax.swing.JButton();
        jButton140 = new javax.swing.JButton();
        jPanel38 = new javax.swing.JPanel();
        jButton141 = new javax.swing.JButton();
        jButton142 = new javax.swing.JButton();
        jButton143 = new javax.swing.JButton();
        jButton144 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jOpenPackagePanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPackDesc = new javax.swing.JTextArea();
        jBackToListButton = new javax.swing.JButton();
        jBookButton = new javax.swing.JButton();
        jBannerImg = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jRegResultsPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jFirstLastNameX = new javax.swing.JTextField();
        jAddressX = new javax.swing.JTextField();
        jZipCityX = new javax.swing.JTextField();
        jCountryX = new javax.swing.JTextField();
        jPhoneX = new javax.swing.JTextField();
        jEmailX = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jKvittAfanga = new javax.swing.JTextField();
        jKvittHotel = new javax.swing.JTextField();
        jKvittDaytour = new javax.swing.JTextField();
        jKvittDepart = new javax.swing.JTextField();
        jKvittArrive = new javax.swing.JTextField();
        jKvittPrice = new javax.swing.JTextField();
        jKvittBrottfor = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton149 = new javax.swing.JButton();
        jFinalPanel = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jButton150 = new javax.swing.JButton();
        jFinalPic = new javax.swing.JLabel();
        jTop = new javax.swing.JPanel();
        jName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLanguage = new javax.swing.JComboBox<>();
        jBackButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 225, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jScrollPane1.setBackground(new java.awt.Color(255, 225, 255));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1450, 1000));

        jMainPanel.setBackground(new java.awt.Color(255, 225, 255));
        jMainPanel.setPreferredSize(new java.awt.Dimension(1450, 1000));

        jBottom.setBackground(new java.awt.Color(255, 225, 255));
        jBottom.setLayout(new java.awt.CardLayout());

        jFrontPanel.setBackground(new java.awt.Color(255, 225, 255));

        jPanel1.setBackground(new java.awt.Color(255, 225, 255));
        jPanel1.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Rosewood Std", 0, 48)); // NOI18N
        jButton1.setText("TILBOÐ");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOfferActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSunActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSkiActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGolfActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);

        jPanel2.setBackground(new java.awt.Color(255, 225, 255));
        jPanel2.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("triphop/view/resources/lang"); // NOI18N
        jButton145.setText(bundle.getString("Tilboð")); // NOI18N
        jButton145.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOfferActionPerformed(evt);
            }
        });
        jPanel2.add(jButton145);

        jButton146.setText(bundle.getString("Sól")); // NOI18N
        jButton146.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSunActionPerformed(evt);
            }
        });
        jPanel2.add(jButton146);

        jButton147.setText(bundle.getString("Skíði")); // NOI18N
        jButton147.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSkiActionPerformed(evt);
            }
        });
        jPanel2.add(jButton147);

        jButton148.setText(bundle.getString("Golf")); // NOI18N
        jButton148.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGolfActionPerformed(evt);
            }
        });
        jPanel2.add(jButton148);

        jPanel3.setBackground(new java.awt.Color(255, 225, 255));
        jPanel3.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCityActionPerformed(evt);
            }
        });
        jPanel3.add(jButton9);

        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEventActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10);

        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOutdoorActionPerformed(evt);
            }
        });
        jPanel3.add(jButton11);

        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFamilyActionPerformed(evt);
            }
        });
        jPanel3.add(jButton12);

        jPanel4.setBackground(new java.awt.Color(255, 225, 255));
        jPanel4.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton13.setText(bundle.getString("Borg")); // NOI18N
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCityActionPerformed(evt);
            }
        });
        jPanel4.add(jButton13);

        jButton14.setText(bundle.getString("Viðburðir")); // NOI18N
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEventActionPerformed(evt);
            }
        });
        jPanel4.add(jButton14);

        jButton15.setText(bundle.getString("Útivist")); // NOI18N
        jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOutdoorActionPerformed(evt);
            }
        });
        jPanel4.add(jButton15);

        jButton16.setText(bundle.getString("Fjölskylda")); // NOI18N
        jButton16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFamilyActionPerformed(evt);
            }
        });
        jPanel4.add(jButton16);

        jPanel6.setBackground(new java.awt.Color(255, 225, 255));
        jPanel6.setLayout(new java.awt.GridLayout(2, 5));

        jLabel2.setText(bundle.getString("Brottfararstaður")); // NOI18N
        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jPanel6.add(jLabel2);

        jLabel3.setText(bundle.getString("Áfangastaður")); // NOI18N
        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jPanel6.add(jLabel3);

        jLabel4.setText(bundle.getString("Brottfarardagur")); // NOI18N
        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jPanel6.add(jLabel4);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel5.setText(bundle.getString("Heimkomudagur")); // NOI18N
        jPanel6.add(jLabel5);

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel6.setText(bundle.getString("Farþegar")); // NOI18N
        jPanel6.add(jLabel6);

        jFrom.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jFrom.setText(bundle.getString("Reykjavík")); // NOI18N
        jFrom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFromFocusGained(evt);
            }
        });
        jPanel6.add(jFrom);

        jTo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTo.setText(bundle.getString("Allir áfangastaðir")); // NOI18N
        jTo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jToFocusGained(evt);
            }
        });
        jPanel6.add(jTo);

        departureDate.setBackground(new java.awt.Color(255, 225, 255));
        departureDate.setPreferredSize(new java.awt.Dimension(200, 29));
        jPanel6.add(departureDate);

        arrivalDate.setBackground(new java.awt.Color(255, 225, 255));
        jPanel6.add(arrivalDate);

        jPassengers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));
        jPanel6.add(jPassengers);

        jSearch.setText(bundle.getString("Leita")); // NOI18N
        jSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jFrontPanelLayout = new javax.swing.GroupLayout(jFrontPanel);
        jFrontPanel.setLayout(jFrontPanelLayout);
        jFrontPanelLayout.setHorizontalGroup(
            jFrontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrontPanelLayout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(jFrontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 963, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(104, Short.MAX_VALUE))
            .addGroup(jFrontPanelLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(jFrontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jFrontPanelLayout.setVerticalGroup(
            jFrontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrontPanelLayout.createSequentialGroup()
                .addGap(0, 30, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 257, Short.MAX_VALUE))
        );

        jBottom.add(jFrontPanel, "card2");

        jRegistrationPanel.setBackground(new java.awt.Color(255, 225, 255));

        JLabel7.setText(bundle.getString("Símanúmer:")); // NOI18N
        JLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        JLabel1.setText(bundle.getString("Fornafn:")); // NOI18N
        JLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        JLabel2.setText(bundle.getString("Eftirnafn:")); // NOI18N
        JLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        JLabel3.setText(bundle.getString("Heimilisfang:")); // NOI18N
        JLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        JLabel4.setText(bundle.getString("Borg:")); // NOI18N
        JLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jReset.setText(bundle.getString("Hreinsa")); // NOI18N
        jReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jResetActionPerformed(evt);
            }
        });

        JLabel5.setText(bundle.getString("Póstnúmer:")); // NOI18N
        JLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jOk.setText(bundle.getString("Staðfesta")); // NOI18N
        jOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOkActionPerformed(evt);
            }
        });

        JLabel6.setText(bundle.getString("Land:")); // NOI18N
        JLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText(bundle.getString("Skráningarform")); // NOI18N
        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N

        JLabel8.setText(bundle.getString("Netfang:")); // NOI18N
        JLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        javax.swing.GroupLayout jRegistrationPanelLayout = new javax.swing.GroupLayout(jRegistrationPanel);
        jRegistrationPanel.setLayout(jRegistrationPanelLayout);
        jRegistrationPanelLayout.setHorizontalGroup(
            jRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jRegistrationPanelLayout.createSequentialGroup()
                .addGroup(jRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jRegistrationPanelLayout.createSequentialGroup()
                        .addGap(600, 600, 600)
                        .addComponent(jReset, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jOk, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jRegistrationPanelLayout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jRegistrationPanelLayout.createSequentialGroup()
                        .addGroup(jRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jRegistrationPanelLayout.createSequentialGroup()
                                .addGap(324, 324, 324)
                                .addGroup(jRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jRegistrationPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jRegistrationPanelLayout.createSequentialGroup()
                                        .addComponent(JLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jRegistrationPanelLayout.createSequentialGroup()
                                        .addComponent(JLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(53, 53, 53)))))
                        .addGroup(jRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jFirstName)
                            .addComponent(jLastName)
                            .addComponent(jAddress)
                            .addComponent(jCity)
                            .addComponent(jZip)
                            .addComponent(jCountry)
                            .addComponent(jPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(377, Short.MAX_VALUE))
        );
        jRegistrationPanelLayout.setVerticalGroup(
            jRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jRegistrationPanelLayout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jLabel7)
                .addGap(52, 52, 52)
                .addGroup(jRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(JLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(JLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCity, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(JLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jZip, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(JLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCountry, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(JLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(JLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(JLabel8))
                .addGap(18, 18, 18)
                .addGroup(jRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jOk)
                    .addComponent(jReset))
                .addGap(429, 429, 429))
        );

        jBottom.add(jRegistrationPanel, "card3");

        jResultPanel.setBackground(new java.awt.Color(255, 225, 255));

        jResultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jResultTable.setRowHeight(30);
        jScrollPane2.setViewportView(jResultTable);

        jButton5.setText(bundle.getString("Tilbaka")); // NOI18N
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackButtonMouseClicked(evt);
            }
        });

        jButton6.setText(bundle.getString("Skoða")); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOpenPackageActionPerformed(evt);
            }
        });

        jCheckBox1.setText(bundle.getString("Verði")); // NOI18N
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPriceFilterActionPerformed(evt);
            }
        });

        jLabel10.setText(bundle.getString("Raða eftir")); // NOI18N
        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N

        javax.swing.GroupLayout jResultPanelLayout = new javax.swing.GroupLayout(jResultPanel);
        jResultPanel.setLayout(jResultPanelLayout);
        jResultPanelLayout.setHorizontalGroup(
            jResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jResultPanelLayout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(jResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jResultPanelLayout.createSequentialGroup()
                        .addGroup(jResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 855, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jResultPanelLayout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(121, 121, 121))
        );
        jResultPanelLayout.setVerticalGroup(
            jResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jResultPanelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jResultPanelLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap(487, Short.MAX_VALUE))
        );

        jBottom.add(jResultPanel, "card4");

        jSkiPanel.setBackground(new java.awt.Color(255, 225, 255));

        jPanel8.setBackground(new java.awt.Color(255, 225, 255));
        jPanel8.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton17.setBackground(new java.awt.Color(255, 255, 255));
        jButton17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton17.setFont(new java.awt.Font("Rosewood Std", 0, 48)); // NOI18N
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel8.add(jButton17);

        jButton18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel8.add(jButton18);

        jButton19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel8.add(jButton19);

        jButton20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel8.add(jButton20);

        jPanel7.setBackground(new java.awt.Color(255, 225, 255));
        jPanel7.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton81.setText(bundle.getString("Austurríki")); // NOI18N
        jButton81.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel7.add(jButton81);

        jButton21.setText(bundle.getString("Frakkland")); // NOI18N
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel7.add(jButton21);

        jButton22.setText(bundle.getString("Ítalía")); // NOI18N
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel7.add(jButton22);

        jButton23.setText(bundle.getString("Sviss")); // NOI18N
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel7.add(jButton23);

        jPanel23.setBackground(new java.awt.Color(255, 225, 255));
        jPanel23.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton29.setBackground(new java.awt.Color(255, 255, 255));
        jButton29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton29.setFont(new java.awt.Font("Rosewood Std", 0, 48)); // NOI18N
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel23.add(jButton29);

        jButton30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel23.add(jButton30);

        jButton31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel23.add(jButton31);

        jButton32.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel23.add(jButton32);

        jPanel24.setBackground(new java.awt.Color(255, 225, 255));
        jPanel24.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton109.setText(bundle.getString("Svíþjóð")); // NOI18N
        jButton109.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel24.add(jButton109);

        jButton37.setText(bundle.getString("Noregur")); // NOI18N
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel24.add(jButton37);

        jButton38.setText(bundle.getString("Ísland")); // NOI18N
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel24.add(jButton38);

        jButton39.setText(bundle.getString("Bandaríkin")); // NOI18N
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel24.add(jButton39);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText(bundle.getString("Skíði")); // NOI18N
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout jSkiPanelLayout = new javax.swing.GroupLayout(jSkiPanel);
        jSkiPanel.setLayout(jSkiPanelLayout);
        jSkiPanelLayout.setHorizontalGroup(
            jSkiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jSkiPanelLayout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addGroup(jSkiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        jSkiPanelLayout.setVerticalGroup(
            jSkiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jSkiPanelLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(279, Short.MAX_VALUE))
        );

        jBottom.add(jSkiPanel, "card5");

        jSunPanel.setBackground(new java.awt.Color(255, 225, 255));

        jPanel9.setBackground(new java.awt.Color(255, 225, 255));
        jPanel9.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton25.setBackground(new java.awt.Color(255, 255, 255));
        jButton25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton25.setFont(new java.awt.Font("Rosewood Std", 0, 48)); // NOI18N
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel9.add(jButton25);

        jButton26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel9.add(jButton26);

        jButton27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel9.add(jButton27);

        jButton28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel9.add(jButton28);

        jPanel10.setBackground(new java.awt.Color(255, 225, 255));
        jPanel10.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton24.setText(bundle.getString("Grikkland")); // NOI18N
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel10.add(jButton24);

        jButton82.setText(bundle.getString("Ítalía")); // NOI18N
        jButton82.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel10.add(jButton82);

        jButton83.setText(bundle.getString("Portúgal")); // NOI18N
        jButton83.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel10.add(jButton83);

        jButton84.setText(bundle.getString("Spánn")); // NOI18N
        jButton84.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel10.add(jButton84);

        jPanel25.setBackground(new java.awt.Color(255, 225, 255));
        jPanel25.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton40.setBackground(new java.awt.Color(255, 255, 255));
        jButton40.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton40.setFont(new java.awt.Font("Rosewood Std", 0, 48)); // NOI18N
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel25.add(jButton40);

        jButton45.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel25.add(jButton45);

        jButton46.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel25.add(jButton46);

        jButton47.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel25.add(jButton47);

        jPanel26.setBackground(new java.awt.Color(255, 225, 255));
        jPanel26.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton48.setText(bundle.getString("Bandaríkin")); // NOI18N
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel26.add(jButton48);

        jButton110.setText(bundle.getString("Mexico")); // NOI18N
        jButton110.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel26.add(jButton110);

        jButton111.setText(bundle.getString("Tyrkland")); // NOI18N
        jButton111.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel26.add(jButton111);

        jButton112.setText(bundle.getString("Indonesía")); // NOI18N
        jButton112.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel26.add(jButton112);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText(bundle.getString("Sól")); // NOI18N
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout jSunPanelLayout = new javax.swing.GroupLayout(jSunPanel);
        jSunPanel.setLayout(jSunPanelLayout);
        jSunPanelLayout.setHorizontalGroup(
            jSunPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jSunPanelLayout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addGroup(jSunPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        jSunPanelLayout.setVerticalGroup(
            jSunPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jSunPanelLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(279, Short.MAX_VALUE))
        );

        jBottom.add(jSunPanel, "card6");

        jOutdoorPanel.setBackground(new java.awt.Color(255, 225, 255));

        jPanel11.setBackground(new java.awt.Color(255, 225, 255));
        jPanel11.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton33.setBackground(new java.awt.Color(255, 255, 255));
        jButton33.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton33.setFont(new java.awt.Font("Rosewood Std", 0, 48)); // NOI18N
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel11.add(jButton33);

        jButton34.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel11.add(jButton34);

        jButton35.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel11.add(jButton35);

        jButton36.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel11.add(jButton36);

        jPanel12.setBackground(new java.awt.Color(255, 225, 255));
        jPanel12.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton85.setText(bundle.getString("Austurríki")); // NOI18N
        jButton85.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel12.add(jButton85);

        jButton86.setText(bundle.getString("Frakkland")); // NOI18N
        jButton86.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel12.add(jButton86);

        jButton87.setText(bundle.getString("Ítalía")); // NOI18N
        jButton87.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel12.add(jButton87);

        jButton88.setText(bundle.getString("Sviss")); // NOI18N
        jButton88.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel12.add(jButton88);

        jPanel27.setBackground(new java.awt.Color(255, 225, 255));
        jPanel27.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton53.setBackground(new java.awt.Color(255, 255, 255));
        jButton53.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton53.setFont(new java.awt.Font("Rosewood Std", 0, 48)); // NOI18N
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel27.add(jButton53);

        jButton54.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel27.add(jButton54);

        jButton55.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel27.add(jButton55);

        jButton56.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel27.add(jButton56);

        jPanel28.setBackground(new java.awt.Color(255, 225, 255));
        jPanel28.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton113.setText(bundle.getString("Mexico")); // NOI18N
        jButton113.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel28.add(jButton113);

        jButton114.setText(bundle.getString("Frakkland")); // NOI18N
        jButton114.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel28.add(jButton114);

        jButton115.setText(bundle.getString("Tyrkland")); // NOI18N
        jButton115.setToolTipText("");
        jButton115.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel28.add(jButton115);

        jButton116.setText(bundle.getString("Bandaríkin")); // NOI18N
        jButton116.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel28.add(jButton116);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText(bundle.getString("Útivist")); // NOI18N
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout jOutdoorPanelLayout = new javax.swing.GroupLayout(jOutdoorPanel);
        jOutdoorPanel.setLayout(jOutdoorPanelLayout);
        jOutdoorPanelLayout.setHorizontalGroup(
            jOutdoorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jOutdoorPanelLayout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addGroup(jOutdoorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        jOutdoorPanelLayout.setVerticalGroup(
            jOutdoorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jOutdoorPanelLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(255, Short.MAX_VALUE))
        );

        jBottom.add(jOutdoorPanel, "card7");

        jGolfPanel.setBackground(new java.awt.Color(255, 225, 255));

        jPanel13.setBackground(new java.awt.Color(255, 225, 255));
        jPanel13.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton41.setBackground(new java.awt.Color(255, 255, 255));
        jButton41.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton41.setFont(new java.awt.Font("Rosewood Std", 0, 48)); // NOI18N
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel13.add(jButton41);

        jButton42.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel13.add(jButton42);

        jButton43.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel13.add(jButton43);

        jButton44.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel13.add(jButton44);

        jPanel14.setBackground(new java.awt.Color(255, 225, 255));
        jPanel14.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton89.setText(bundle.getString("Bandaríkin")); // NOI18N
        jButton89.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel14.add(jButton89);

        jButton90.setText(bundle.getString("England")); // NOI18N
        jButton90.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel14.add(jButton90);

        jButton91.setText(bundle.getString("Skotland")); // NOI18N
        jButton91.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel14.add(jButton91);

        jButton92.setText(bundle.getString("Spánn")); // NOI18N
        jButton92.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel14.add(jButton92);

        jPanel29.setBackground(new java.awt.Color(255, 225, 255));
        jPanel29.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton61.setBackground(new java.awt.Color(255, 255, 255));
        jButton61.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton61.setFont(new java.awt.Font("Rosewood Std", 0, 48)); // NOI18N
        jButton61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel29.add(jButton61);

        jButton62.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel29.add(jButton62);

        jButton63.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel29.add(jButton63);

        jButton64.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel29.add(jButton64);

        jPanel30.setBackground(new java.awt.Color(255, 225, 255));
        jPanel30.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton117.setText(bundle.getString("Frakkland")); // NOI18N
        jButton117.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel30.add(jButton117);

        jButton118.setText(bundle.getString("Svíþjóð")); // NOI18N
        jButton118.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel30.add(jButton118);

        jButton119.setText(bundle.getString("Grikkland")); // NOI18N
        jButton119.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel30.add(jButton119);

        jButton120.setText(bundle.getString("Portúgal")); // NOI18N
        jButton120.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel30.add(jButton120);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText(bundle.getString("Golf")); // NOI18N
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout jGolfPanelLayout = new javax.swing.GroupLayout(jGolfPanel);
        jGolfPanel.setLayout(jGolfPanelLayout);
        jGolfPanelLayout.setHorizontalGroup(
            jGolfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jGolfPanelLayout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addGroup(jGolfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        jGolfPanelLayout.setVerticalGroup(
            jGolfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jGolfPanelLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(269, Short.MAX_VALUE))
        );

        jBottom.add(jGolfPanel, "card8");

        jCityPanel.setBackground(new java.awt.Color(255, 225, 255));

        jPanel15.setBackground(new java.awt.Color(255, 225, 255));
        jPanel15.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton49.setBackground(new java.awt.Color(255, 255, 255));
        jButton49.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton49.setFont(new java.awt.Font("Rosewood Std", 0, 48)); // NOI18N
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel15.add(jButton49);

        jButton50.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel15.add(jButton50);

        jButton51.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel15.add(jButton51);

        jButton52.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel15.add(jButton52);

        jPanel16.setBackground(new java.awt.Color(255, 225, 255));
        jPanel16.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton93.setText(bundle.getString("Bandaríkin")); // NOI18N
        jButton93.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel16.add(jButton93);

        jButton94.setText(bundle.getString("Danmörk")); // NOI18N
        jButton94.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel16.add(jButton94);

        jButton95.setText(bundle.getString("Skotland")); // NOI18N
        jButton95.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel16.add(jButton95);

        jButton96.setText(bundle.getString("Svíþjóð")); // NOI18N
        jButton96.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel16.add(jButton96);

        jPanel31.setBackground(new java.awt.Color(255, 225, 255));
        jPanel31.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton69.setBackground(new java.awt.Color(255, 255, 255));
        jButton69.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton69.setFont(new java.awt.Font("Rosewood Std", 0, 48)); // NOI18N
        jButton69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel31.add(jButton69);

        jButton70.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel31.add(jButton70);

        jButton71.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel31.add(jButton71);

        jButton72.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel31.add(jButton72);

        jPanel32.setBackground(new java.awt.Color(255, 225, 255));
        jPanel32.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton121.setText(bundle.getString("Noregur")); // NOI18N
        jButton121.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel32.add(jButton121);

        jButton122.setText(bundle.getString("Spánn")); // NOI18N
        jButton122.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel32.add(jButton122);

        jButton123.setText(bundle.getString("England")); // NOI18N
        jButton123.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel32.add(jButton123);

        jButton124.setText(bundle.getString("Frakkland")); // NOI18N
        jButton124.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel32.add(jButton124);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText(bundle.getString("Borg")); // NOI18N
        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout jCityPanelLayout = new javax.swing.GroupLayout(jCityPanel);
        jCityPanel.setLayout(jCityPanelLayout);
        jCityPanelLayout.setHorizontalGroup(
            jCityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jCityPanelLayout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addGroup(jCityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        jCityPanelLayout.setVerticalGroup(
            jCityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jCityPanelLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(262, Short.MAX_VALUE))
        );

        jBottom.add(jCityPanel, "card9");

        jEventPanel.setBackground(new java.awt.Color(255, 225, 255));

        jPanel17.setBackground(new java.awt.Color(255, 225, 255));
        jPanel17.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton57.setBackground(new java.awt.Color(255, 255, 255));
        jButton57.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton57.setFont(new java.awt.Font("Rosewood Std", 0, 48)); // NOI18N
        jButton57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel17.add(jButton57);

        jButton58.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel17.add(jButton58);

        jButton59.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel17.add(jButton59);

        jButton60.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel17.add(jButton60);

        jPanel18.setBackground(new java.awt.Color(255, 225, 255));
        jPanel18.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton97.setText(bundle.getString("Bandaríkin")); // NOI18N
        jButton97.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel18.add(jButton97);

        jButton98.setText(bundle.getString("England")); // NOI18N
        jButton98.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel18.add(jButton98);

        jButton99.setText(bundle.getString("Danmörk")); // NOI18N
        jButton99.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel18.add(jButton99);

        jButton100.setText(bundle.getString("Frakkland")); // NOI18N
        jButton100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel18.add(jButton100);

        jPanel33.setBackground(new java.awt.Color(255, 225, 255));
        jPanel33.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton77.setBackground(new java.awt.Color(255, 255, 255));
        jButton77.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton77.setFont(new java.awt.Font("Rosewood Std", 0, 48)); // NOI18N
        jButton77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel33.add(jButton77);

        jButton78.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton78.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel33.add(jButton78);

        jButton79.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton79.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel33.add(jButton79);

        jButton80.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton80.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel33.add(jButton80);

        jPanel34.setBackground(new java.awt.Color(255, 225, 255));
        jPanel34.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton125.setText(bundle.getString("Svíþjóð")); // NOI18N
        jButton125.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel34.add(jButton125);

        jButton126.setText(bundle.getString("Portúgal")); // NOI18N
        jButton126.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel34.add(jButton126);

        jButton127.setText(bundle.getString("Spánn")); // NOI18N
        jButton127.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel34.add(jButton127);

        jButton128.setText(bundle.getString("Austurríki")); // NOI18N
        jButton128.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel34.add(jButton128);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText(bundle.getString("Viðburðir")); // NOI18N
        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout jEventPanelLayout = new javax.swing.GroupLayout(jEventPanel);
        jEventPanel.setLayout(jEventPanelLayout);
        jEventPanelLayout.setHorizontalGroup(
            jEventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jEventPanelLayout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addGroup(jEventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        jEventPanelLayout.setVerticalGroup(
            jEventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jEventPanelLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(272, Short.MAX_VALUE))
        );

        jBottom.add(jEventPanel, "card10");

        jFamilyPanel.setBackground(new java.awt.Color(255, 225, 255));

        jPanel19.setBackground(new java.awt.Color(255, 225, 255));
        jPanel19.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton65.setBackground(new java.awt.Color(255, 255, 255));
        jButton65.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton65.setFont(new java.awt.Font("Rosewood Std", 0, 48)); // NOI18N
        jButton65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel19.add(jButton65);

        jButton66.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel19.add(jButton66);

        jButton67.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel19.add(jButton67);

        jButton68.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel19.add(jButton68);

        jPanel20.setBackground(new java.awt.Color(255, 225, 255));
        jPanel20.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton101.setText(bundle.getString("Bandaríkin")); // NOI18N
        jButton101.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel20.add(jButton101);

        jButton102.setText(bundle.getString("Danmörk")); // NOI18N
        jButton102.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel20.add(jButton102);

        jButton103.setText(bundle.getString("Ítalía")); // NOI18N
        jButton103.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel20.add(jButton103);

        jButton104.setText(bundle.getString("Frakkland")); // NOI18N
        jButton104.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel20.add(jButton104);

        jPanel35.setBackground(new java.awt.Color(255, 225, 255));
        jPanel35.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton129.setBackground(new java.awt.Color(255, 255, 255));
        jButton129.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton129.setFont(new java.awt.Font("Rosewood Std", 0, 48)); // NOI18N
        jButton129.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel35.add(jButton129);

        jButton130.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton130.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel35.add(jButton130);

        jButton131.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton131.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel35.add(jButton131);

        jButton132.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton132.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel35.add(jButton132);

        jPanel36.setBackground(new java.awt.Color(255, 225, 255));
        jPanel36.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton133.setText(bundle.getString("England")); // NOI18N
        jButton133.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel36.add(jButton133);

        jButton134.setText(bundle.getString("Tyrkland")); // NOI18N
        jButton134.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel36.add(jButton134);

        jButton135.setText(bundle.getString("Grikkland")); // NOI18N
        jButton135.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel36.add(jButton135);

        jButton136.setText(bundle.getString("Spánn")); // NOI18N
        jButton136.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel36.add(jButton136);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText(bundle.getString("Fjölskylda")); // NOI18N
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout jFamilyPanelLayout = new javax.swing.GroupLayout(jFamilyPanel);
        jFamilyPanel.setLayout(jFamilyPanelLayout);
        jFamilyPanelLayout.setHorizontalGroup(
            jFamilyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFamilyPanelLayout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addGroup(jFamilyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        jFamilyPanelLayout.setVerticalGroup(
            jFamilyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFamilyPanelLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(256, Short.MAX_VALUE))
        );

        jBottom.add(jFamilyPanel, "card11");

        jOfferPanel.setBackground(new java.awt.Color(255, 225, 255));

        jPanel21.setBackground(new java.awt.Color(255, 225, 255));
        jPanel21.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton73.setBackground(new java.awt.Color(255, 255, 255));
        jButton73.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton73.setFont(new java.awt.Font("Rosewood Std", 0, 48)); // NOI18N
        jButton73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel21.add(jButton73);

        jButton74.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel21.add(jButton74);

        jButton75.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel21.add(jButton75);

        jButton76.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton76.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel21.add(jButton76);

        jPanel22.setBackground(new java.awt.Color(255, 225, 255));
        jPanel22.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton105.setText("Danmörk");
        jButton105.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel22.add(jButton105);

        jButton106.setText("Frakkland");
        jButton106.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel22.add(jButton106);

        jButton107.setText("Tyrkland");
        jButton107.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel22.add(jButton107);

        jButton108.setText("Grikkland");
        jButton108.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel22.add(jButton108);

        jPanel37.setBackground(new java.awt.Color(255, 225, 255));
        jPanel37.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton137.setBackground(new java.awt.Color(255, 255, 255));
        jButton137.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton137.setFont(new java.awt.Font("Rosewood Std", 0, 48)); // NOI18N
        jButton137.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel37.add(jButton137);

        jButton138.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton138.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel37.add(jButton138);

        jButton139.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton139.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel37.add(jButton139);

        jButton140.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton140.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel37.add(jButton140);

        jPanel38.setBackground(new java.awt.Color(255, 225, 255));
        jPanel38.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton141.setText("England");
        jButton141.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel38.add(jButton141);

        jButton142.setText("Austurríki");
        jButton142.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel38.add(jButton142);

        jButton143.setText("Bandaríkin");
        jButton143.setToolTipText("");
        jButton143.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel38.add(jButton143);

        jButton144.setText("Noregur");
        jButton144.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemePackagesActionPerformed(evt);
            }
        });
        jPanel38.add(jButton144);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText(bundle.getString("Tilboð")); // NOI18N
        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout jOfferPanelLayout = new javax.swing.GroupLayout(jOfferPanel);
        jOfferPanel.setLayout(jOfferPanelLayout);
        jOfferPanelLayout.setHorizontalGroup(
            jOfferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jOfferPanelLayout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addGroup(jOfferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        jOfferPanelLayout.setVerticalGroup(
            jOfferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jOfferPanelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(263, Short.MAX_VALUE))
        );

        jBottom.add(jOfferPanel, "card12");

        jOpenPackagePanel.setBackground(new java.awt.Color(255, 225, 255));

        jPackDesc.setColumns(20);
        jPackDesc.setRows(5);
        jPackDesc.setText("\n");
        jScrollPane3.setViewportView(jPackDesc);

        jBackToListButton.setText(bundle.getString("Tilbaka")); // NOI18N
        jBackToListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBackToListButtonActionPerformed(evt);
            }
        });

        jBookButton.setText(bundle.getString("Bóka")); // NOI18N
        jBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPackageChosenActionPerformed(evt);
            }
        });

        jButton7.setText(bundle.getString("Skoða nánar")); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMoreInformationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jOpenPackagePanelLayout = new javax.swing.GroupLayout(jOpenPackagePanel);
        jOpenPackagePanel.setLayout(jOpenPackagePanelLayout);
        jOpenPackagePanelLayout.setHorizontalGroup(
            jOpenPackagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jOpenPackagePanelLayout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addGroup(jOpenPackagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jOpenPackagePanelLayout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBackToListButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBannerImg, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(260, Short.MAX_VALUE))
        );
        jOpenPackagePanelLayout.setVerticalGroup(
            jOpenPackagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jOpenPackagePanelLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jBannerImg, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jOpenPackagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jBookButton)
                    .addComponent(jBackToListButton))
                .addContainerGap(404, Short.MAX_VALUE))
        );

        jBottom.add(jOpenPackagePanel, "card13");

        jRegResultsPanel.setBackground(new java.awt.Color(255, 225, 255));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText(bundle.getString("Upplýsingar um viðskiptavin:")); // NOI18N
        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jFirstLastNameX.setEditable(false);
        jFirstLastNameX.setBorder(null);
        jFirstLastNameX.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jAddressX.setEditable(false);
        jAddressX.setBorder(null);
        jAddressX.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jZipCityX.setEditable(false);
        jZipCityX.setBorder(null);
        jZipCityX.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jCountryX.setEditable(false);
        jCountryX.setBorder(null);
        jCountryX.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPhoneX.setEditable(false);
        jPhoneX.setBorder(null);
        jPhoneX.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jEmailX.setEditable(false);
        jEmailX.setBorder(null);
        jEmailX.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFirstLastNameX)
            .addComponent(jAddressX, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jZipCityX, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jCountryX, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPhoneX)
            .addComponent(jEmailX, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jFirstLastNameX, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jAddressX, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jZipCityX, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCountryX, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPhoneX, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jEmailX, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText(bundle.getString("Upplýsingar um pakka:")); // NOI18N
        jLabel18.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jKvittAfanga.setBorder(null);
        jKvittAfanga.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jKvittHotel.setBorder(null);
        jKvittHotel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jKvittHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jKvittHotelActionPerformed(evt);
            }
        });

        jKvittDaytour.setBorder(null);
        jKvittDaytour.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jKvittDepart.setBorder(null);
        jKvittDepart.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jKvittArrive.setBorder(null);
        jKvittArrive.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jKvittPrice.setBorder(null);
        jKvittPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jKvittBrottfor.setBorder(null);
        jKvittBrottfor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jKvittBrottfor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jKvittBrottforActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jKvittArrive)
            .addComponent(jKvittPrice)
            .addComponent(jKvittAfanga)
            .addComponent(jKvittBrottfor)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jKvittHotel, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                    .addComponent(jKvittDaytour)
                    .addComponent(jKvittDepart))
                .addGap(272, 272, 272))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jKvittBrottfor, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jKvittAfanga, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jKvittHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jKvittDaytour, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jKvittDepart, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jKvittArrive, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jKvittPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton8.setText(bundle.getString("Staðfesta")); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConfirmBookActionPerformed(evt);
            }
        });

        jButton149.setText(bundle.getString("Tilbaka")); // NOI18N
        jButton149.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBackToReg(evt);
            }
        });

        javax.swing.GroupLayout jRegResultsPanelLayout = new javax.swing.GroupLayout(jRegResultsPanel);
        jRegResultsPanel.setLayout(jRegResultsPanelLayout);
        jRegResultsPanelLayout.setHorizontalGroup(
            jRegResultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jRegResultsPanelLayout.createSequentialGroup()
                .addGroup(jRegResultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jRegResultsPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton149)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jRegResultsPanelLayout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addGroup(jRegResultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
                        .addGap(65, 65, 65)
                        .addGroup(jRegResultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))))
                .addContainerGap(280, Short.MAX_VALUE))
        );
        jRegResultsPanelLayout.setVerticalGroup(
            jRegResultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jRegResultsPanelLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jRegResultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jRegResultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jRegResultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton149)
                    .addComponent(jButton8))
                .addGap(496, 496, 496))
        );

        jBottom.add(jRegResultsPanel, "card14");

        jFinalPanel.setBackground(new java.awt.Color(255, 225, 255));

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText(bundle.getString("Takk fyrir viðskiptin og góða ferð!")); // NOI18N
        jLabel19.setFont(new java.awt.Font("SignPainter", 0, 48)); // NOI18N

        jButton150.setText(bundle.getString("Aftur á forsíðu")); // NOI18N
        jButton150.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jFinalPanelLayout = new javax.swing.GroupLayout(jFinalPanel);
        jFinalPanel.setLayout(jFinalPanelLayout);
        jFinalPanelLayout.setHorizontalGroup(
            jFinalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFinalPanelLayout.createSequentialGroup()
                .addGap(423, 423, 423)
                .addComponent(jFinalPic, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jFinalPanelLayout.createSequentialGroup()
                .addGroup(jFinalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFinalPanelLayout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jFinalPanelLayout.createSequentialGroup()
                        .addGap(496, 496, 496)
                        .addComponent(jButton150)))
                .addContainerGap(266, Short.MAX_VALUE))
        );
        jFinalPanelLayout.setVerticalGroup(
            jFinalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFinalPanelLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jFinalPic, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton150)
                .addContainerGap(525, Short.MAX_VALUE))
        );

        jBottom.add(jFinalPanel, "card15");

        jTop.setBackground(new java.awt.Color(255, 225, 255));
        jTop.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jName.setText("T R I P H O P");
        jName.setFont(new java.awt.Font("Rosewood Std", 1, 58)); // NOI18N
        jTop.add(jName, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 335, 74));

        jLabel1.setText(bundle.getString("F i n n d u   p a k k a   f y r i r   þ i g")); // NOI18N
        jLabel1.setFont(new java.awt.Font("SignPainter", 1, 34)); // NOI18N
        jTop.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, -1, 44));

        jLanguage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Íslenska", "English" }));
        jLanguage.setBackground(new java.awt.Color(255, 225, 255));
        jLanguage.setToolTipText("");
        jLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLanguageActionPerformed(evt);
            }
        });
        jTop.add(jLanguage, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 50, 128, 43));

        jBackButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackButtonMouseClicked(evt);
            }
        });
        jTop.add(jBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 40, 40));

        javax.swing.GroupLayout jMainPanelLayout = new javax.swing.GroupLayout(jMainPanel);
        jMainPanel.setLayout(jMainPanelLayout);
        jMainPanelLayout.setHorizontalGroup(
            jMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jMainPanelLayout.createSequentialGroup()
                .addGroup(jMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jMainPanelLayout.setVerticalGroup(
            jMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jMainPanelLayout.createSequentialGroup()
                .addComponent(jTop, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jMainPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1130, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1220, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSearchActionPerformed
        String from = jFrom.getText();
        String to = jTo.getText();
        
        LocalDate d1 = departureDate.getDate();
        Calendar cal1 = Calendar.getInstance(); 
        cal1.set( d1.getYear(), d1.getMonthValue(), d1.getDayOfMonth() );
        
        LocalDate d2 = arrivalDate.getDate();
        Calendar cal2 = Calendar.getInstance();
        cal2.set( d2.getYear(), d2.getMonthValue(), d2.getDayOfMonth() );
        String cal2Str = cal2.toString();
        
        int day1 = cal1.get(Calendar.DAY_OF_MONTH);
        int month1=cal1.get(Calendar.MONTH);
        int year1=cal1.get(Calendar.YEAR);
        String date1= (day1+". "+"0"+month1+", "+year1);
        int day2 = cal2.get(Calendar.DAY_OF_MONTH);
        int month2=cal2.get(Calendar.MONTH);
        int year2=cal2.get(Calendar.YEAR);
        String date2 = (day2+". "+"0"+month2+", "+year2);
        
        int passCount = jPassengers.getSelectedIndex();
        
        customer = new Customer(cal1,cal2,from,to,passCount,2,null);
        pMan = new PackageManager(customer);
        

        model = new DefaultTableModel();
        model.addColumn("Destination");
        model.addColumn("Departure date");
        model.addColumn("Return date");
        model.addColumn("Hotel");
        model.addColumn("Day Tour");
        model.addColumn("Total amount");
        
        for(triphop.model.Package pack : pMan.getPackages()) {
            model.addRow(new Object[]{pack.getFlight()[0].getArrival(),date1,date2,pack.getHotel().getName(),pack.getDayTour().getName(),pack.getCost()});
            
        }
        
        jResultTable.setModel(model);
        
        jFrontPanel.setVisible(false); 
        jResultPanel.setVisible(true);
    }//GEN-LAST:event_jSearchActionPerformed

    private void jLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLanguageActionPerformed
        if(flagLang) {    
            JComboBox cb = (JComboBox)evt.getSource();
            String lang = (String)cb.getSelectedItem();

            if("English".equals(lang)) {
                dispose();
                Locale l = new Locale("en_GB");
                Locale.setDefault(l); 
                MainFrame h;
                h = new MainFrame();
                h.setVisible(true);
            }
            else {
                dispose();
                Locale l = new Locale("is_IS");
                Locale.setDefault(l);
                MainFrame h;
                h = new MainFrame();
                h.setVisible(true);
            }
        }
    }//GEN-LAST:event_jLanguageActionPerformed

    private void jOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOkActionPerformed
        String firstname = jFirstName.getText();
        String lastname = jLastName.getText();
        String address = jAddress.getText();
        String city = jCity.getText();
        String zip = jZip.getText();
        String country = jCountry.getText();
        String phone = jPhone.getText();
        String email = jEmail.getText();
        
        System.out.println(jFirstName.getText());
        jRegistrationPanel.setVisible(false);
        jRegResultsPanel.setVisible(true);
        jFirstLastNameX.setText("  Nafn: " + firstname +" " + lastname);
        jAddressX.setText("  Heimilisfang: " + address);
        jZipCityX.setText("  Borg: " + zip + " " + city);
        jCountryX.setText("  Land: " + country);
        jPhoneX.setText("  Símanúmer: " + phone);
        jEmailX.setText("  Netfang: " + email);
        
        int columncity = 0;
        int columndepart = 1;
        int columnarrive = 2;
        int columnhotel = 3;
        int columndaytour = 4;
        int columnprice = 5;
        int row = jResultTable.getSelectedRow();
        String borg = jResultTable.getModel().getValueAt(row, columncity).toString();
        String depart = jResultTable.getModel().getValueAt(row, columndepart).toString();
        String arrive = jResultTable.getModel().getValueAt(row, columnarrive).toString();
        String hotel = jResultTable.getModel().getValueAt(row, columnhotel).toString();
        String daytour = jResultTable.getModel().getValueAt(row, columndaytour).toString();
        String price = jResultTable.getModel().getValueAt(row, columnprice).toString();
        
        jKvittBrottfor.setText("  Brottfararstaður: " + jFrom.getText());
        jKvittAfanga.setText("  Áfangastaður: " + borg);
        jKvittHotel.setText("  Brottfararstaður: " + borg);
        jKvittDaytour.setText("  Dagsferð: " + daytour);
        jKvittDepart.setText("  Brottför: " + depart);
        jKvittArrive.setText("  Heimkoma: " + arrive);
        jKvittPrice.setText("  Verð samtals: " + price);
    }//GEN-LAST:event_jOkActionPerformed

    private void jBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackButtonMouseClicked
        
        for(int i=0; i<panelar.length;i++) {
            if(panelar[i].isVisible()==true) {
                panelar[i].setVisible(false);
                jFrontPanel.setVisible(true);
            }
        }    
    }//GEN-LAST:event_jBackButtonMouseClicked

    private void jOfferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOfferActionPerformed
        jFrontPanel.setVisible(false); 
        jOfferPanel.setVisible(true);
    }//GEN-LAST:event_jOfferActionPerformed

    private void jSunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSunActionPerformed
        jFrontPanel.setVisible(false); 
        jSunPanel.setVisible(true);
    }//GEN-LAST:event_jSunActionPerformed

    private void jSkiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSkiActionPerformed
        jFrontPanel.setVisible(false); 
        jSkiPanel.setVisible(true);
    }//GEN-LAST:event_jSkiActionPerformed

    private void jGolfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGolfActionPerformed
        jFrontPanel.setVisible(false); 
        jGolfPanel.setVisible(true);
    }//GEN-LAST:event_jGolfActionPerformed

    private void jCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCityActionPerformed
        jFrontPanel.setVisible(false); 
        jCityPanel.setVisible(true);
    }//GEN-LAST:event_jCityActionPerformed

    private void jEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEventActionPerformed
        jFrontPanel.setVisible(false); 
        jEventPanel.setVisible(true);
    }//GEN-LAST:event_jEventActionPerformed

    private void jOutdoorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOutdoorActionPerformed
        jFrontPanel.setVisible(false); 
        jOutdoorPanel.setVisible(true);
    }//GEN-LAST:event_jOutdoorActionPerformed

    private void jFamilyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFamilyActionPerformed
        jFrontPanel.setVisible(false); 
        jFamilyPanel.setVisible(true);
    }//GEN-LAST:event_jFamilyActionPerformed

    private void jBackToListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackToListButtonActionPerformed
        jOpenPackagePanel.setVisible(false);
        jResultPanel.setVisible(true);
    }//GEN-LAST:event_jBackToListButtonActionPerformed

    private void jPackageChosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPackageChosenActionPerformed
        jOpenPackagePanel.setVisible(false);
        jRegistrationPanel.setVisible(true);
    }//GEN-LAST:event_jPackageChosenActionPerformed

    private void jResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jResetActionPerformed
        jFirstName.setText("");
        jLastName.setText("");
        jAddress.setText("");
        jCity.setText("");
        jZip.setText("");
        jCountry.setText("");
        jPhone.setText("");
        jEmail.setText("");
    }//GEN-LAST:event_jResetActionPerformed

    private void jOpenPackageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOpenPackageActionPerformed
        jResultPanel.setVisible(false);
        jOpenPackagePanel.setVisible(true);
        
        int columncity = 0;
        int columndepart = 1;
        int columnarrive = 2;
        int columnhotel = 3;
        int columndaytour = 4;
        int columnprice = 5;
        int row = jResultTable.getSelectedRow();
        String borg = jResultTable.getModel().getValueAt(row, columncity).toString();
        String depart = jResultTable.getModel().getValueAt(row, columndepart).toString();
        String arrive = jResultTable.getModel().getValueAt(row, columnarrive).toString();
        String hotel = jResultTable.getModel().getValueAt(row, columnhotel).toString();
        String daytour = jResultTable.getModel().getValueAt(row, columndaytour).toString();
        String price = jResultTable.getModel().getValueAt(row, columnprice).toString();
      
        StretchIcon londonbanner = createImg("img/london.png");
        StretchIcon parisbanner = createImg("img/paris.png");
        String London = "London";
        String Paris = "Paris";
        
        if(borg.equals(London)) 
        {
            System.out.println("London virkar");
            jBannerImg.setIcon(londonbanner);
        }
        else if(borg.equals(Paris))
        {
            System.out.println("Paris virkar");
            jBannerImg.setIcon(parisbanner);
        }
   
        
        jPackDesc.setText("Pakkinn inniheldur ferð til " + borg + '\n' + '\n' +
                "þar sem gist er á " + hotel + '\n' + '\n'+ 
                "og farið í dagsferðina " + daytour + '\n' + '\n' +
                "Brottför er " + depart + '\n' + '\n' +
                "Heimkoma er " + arrive);

        
    }//GEN-LAST:event_jOpenPackageActionPerformed

    private void jMoreInformationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMoreInformationActionPerformed
        String depInfo=new String();
        String arrInfo=new String();
        String flightCost = new String();
        String dtInfo=new String();
        String dtAct = new String();
        String dtCost = new String();
        String dtLoc = new String();
        String dtName = new String();
        String hLoc = new String();
        String hName = new String();
        String hCost = new String();
        int totalCost=new Integer(0);
        
        for(triphop.model.Package pakk : pMan.getPackages()) {
            depInfo=pakk.getFlight()[0].getDeparture();
            arrInfo=pakk.getFlight()[0].getArrival();
            flightCost = pakk.getFlight()[0].getCost().toString();
            
            dtInfo = pakk.getDayTour().getDescription();
            dtAct = pakk.getDayTour().getActivity();
            dtCost = pakk.getDayTour().getCost().toString();
            dtLoc = pakk.getDayTour().getLocation();
            dtName = pakk.getDayTour().getName();
            
            hLoc = pakk.getHotel().getLocation();
            hName = pakk.getHotel().getName();
            hCost = pakk.getHotel().getCost().toString();
            
            totalCost=pakk.getCost();
        }      
        int row = jResultTable.getSelectedRow();
        
        System.out.println(totalCost);
        
        String price = jResultTable.getModel().getValueAt(row, 5).toString();

           
        info.getjTextArea1().setLineWrap(true);
        info.getjTextArea1().setWrapStyleWord(true);
        info.getjTextArea1().setText("Flugupplýsingar:"+'\n'+"Brottfararstaður: "
                +depInfo+'\n'+"Áfangastaður: "+arrInfo+'\n'+"Flugkostnaður: "+flightCost+
                '\n'+'\n'+  
                "Dagsferðarupplýsingar: "+'\n'+"Heiti: "+dtName+'\n'+"Staðsetning: "
                +dtLoc+'\n'+"Þema: "+dtAct+'\n'+"Innihaldslýsing dagsferðar: "+dtInfo+'\n'
                +"Dagsferðarkostnaður: "+dtCost+'\n'+'\n'+ 
                "Hótelupplýsingar: "+'\n'+"Heiti: "+hName+'\n'+"Staðsetning: "+hLoc+'\n'+
                "Hótelkostnaður: "+hCost+'\n'+'\n'+'\n'+"Heildarkostnaður pakka: "+price
                
        );
 
        info.setVisible(true);
    }//GEN-LAST:event_jMoreInformationActionPerformed

    private void jBackToReg(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackToReg
        jRegResultsPanel.setVisible(false);
        jRegistrationPanel.setVisible(true);
    }//GEN-LAST:event_jBackToReg

    private void jConfirmBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConfirmBookActionPerformed
 
        int input = JOptionPane.showConfirmDialog(null,"Viltu halda áfram?",
                "Staðfesta",JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE);
        
        if(input == JOptionPane.YES_OPTION) {
            jRegResultsPanel.setVisible(false);
            jFinalPanel.setVisible(true);
        } 
    }//GEN-LAST:event_jConfirmBookActionPerformed

    private void jToFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jToFocusGained
        jTo.setText("");// TODO add your handling code here:
    }//GEN-LAST:event_jToFocusGained

    private void jPriceFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPriceFilterActionPerformed
        String from = jFrom.getText();
        String to = jTo.getText();
        
        LocalDate d1 = departureDate.getDate();
        Calendar cal1 = Calendar.getInstance(); 
        cal1.set( d1.getYear(), d1.getMonthValue(), d1.getDayOfMonth() );
        
        LocalDate d2 = arrivalDate.getDate();
        Calendar cal2 = Calendar.getInstance();
        cal2.set( d2.getYear(), d2.getMonthValue(), d2.getDayOfMonth() );
        String cal2Str = cal2.toString();
        
        int passCount = jPassengers.getSelectedIndex();
        
        customer = new Customer(cal1,cal2,from,to,passCount,2,null);
        ArrayList<triphop.model.Package> packages = pMan.sortPackages("cost");

        model = new DefaultTableModel();
        model.addColumn("Destination");
        model.addColumn("Departure date");
        model.addColumn("Return date");
        model.addColumn("Hotel");
        model.addColumn("Day Tour");
        model.addColumn("Total amount");
     
        
        int day1 = cal1.get(Calendar.DAY_OF_MONTH);
        int month1=cal1.get(Calendar.MONTH);
        int year1=cal1.get(Calendar.YEAR);
        String date1= (day1+". "+"0"+month1+", "+year1);
        int day2 = cal2.get(Calendar.DAY_OF_MONTH);
        int month2=cal2.get(Calendar.MONTH);
        int year2=cal2.get(Calendar.YEAR);
        String date2 = (day2+". "+"0"+month2+", "+year2);    
        
        
        for(triphop.model.Package pack : packages) {
            model.addRow(new Object[]{pack.getFlight()[0].getArrival(),date1,
                date2,pack.getHotel().getName(),pack.getDayTour().getName(),pack.getCost()});
        }
        
        jResultTable.setModel(model);
    }//GEN-LAST:event_jPriceFilterActionPerformed

    private void jFromFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFromFocusGained
        jFrom.setText("");
    }//GEN-LAST:event_jFromFocusGained

    private void jKvittHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jKvittHotelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jKvittHotelActionPerformed

    private void jKvittBrottforActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jKvittBrottforActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jKvittBrottforActionPerformed

    private void jThemePackagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jThemePackagesActionPerformed
        for(int i=0; i<panelar.length;i++) {
            if(panelar[i].isVisible()==true) {
                panelar[i].setVisible(false);
                jResultPanel.setVisible(true);
            }
        }  
        String from = "Keflavik";
        Random ran = new Random();
        String to = lond[ran.nextInt(2)];
           
        Calendar cal1 = new GregorianCalendar();	
        Calendar cal2 = new GregorianCalendar();
        
        cal1.set(2018, 4, 20);
        cal2.set(2018,4,21);
        
        int day1 = cal1.get(Calendar.DAY_OF_MONTH);
        int month1=cal1.get(Calendar.MONTH);
        int year1=cal1.get(Calendar.YEAR);
        String date1= (day1+". "+"0"+month1+", "+year1);
        int day2 = cal2.get(Calendar.DAY_OF_MONTH);
        int month2=cal2.get(Calendar.MONTH);
        int year2=cal2.get(Calendar.YEAR);
        String date2 = (day2+". "+"0"+month2+", "+year2);
        
        
        customer = new Customer(cal1,cal2,from,to,2,2,null);
        pMan = new PackageManager(customer);
        

        model = new DefaultTableModel();
        model.addColumn("Destination");
        model.addColumn("Departure date");
        model.addColumn("Return date");
        model.addColumn("Hotel");
        model.addColumn("Day Tour");
        model.addColumn("Total amount");
        
        for(triphop.model.Package pack : pMan.getPackages()) {         
            model.addRow(new Object[]{pack.getFlight()[0].getArrival(),date1,date2,pack.getHotel().getName(),pack.getDayTour().getName(),pack.getCost()});
        }
        
        jResultTable.setModel(model);
    }//GEN-LAST:event_jThemePackagesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel1;
    private javax.swing.JLabel JLabel2;
    private javax.swing.JLabel JLabel3;
    private javax.swing.JLabel JLabel4;
    private javax.swing.JLabel JLabel5;
    private javax.swing.JLabel JLabel6;
    private javax.swing.JLabel JLabel7;
    private javax.swing.JLabel JLabel8;
    private com.github.lgooddatepicker.components.DatePicker arrivalDate;
    private com.github.lgooddatepicker.components.DatePicker departureDate;
    private javax.swing.JTextField jAddress;
    private javax.swing.JTextField jAddressX;
    private javax.swing.JLabel jBackButton;
    private javax.swing.JButton jBackToListButton;
    private javax.swing.JLabel jBannerImg;
    private javax.swing.JButton jBookButton;
    private javax.swing.JPanel jBottom;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton100;
    private javax.swing.JButton jButton101;
    private javax.swing.JButton jButton102;
    private javax.swing.JButton jButton103;
    private javax.swing.JButton jButton104;
    private javax.swing.JButton jButton105;
    private javax.swing.JButton jButton106;
    private javax.swing.JButton jButton107;
    private javax.swing.JButton jButton108;
    private javax.swing.JButton jButton109;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton110;
    private javax.swing.JButton jButton111;
    private javax.swing.JButton jButton112;
    private javax.swing.JButton jButton113;
    private javax.swing.JButton jButton114;
    private javax.swing.JButton jButton115;
    private javax.swing.JButton jButton116;
    private javax.swing.JButton jButton117;
    private javax.swing.JButton jButton118;
    private javax.swing.JButton jButton119;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton120;
    private javax.swing.JButton jButton121;
    private javax.swing.JButton jButton122;
    private javax.swing.JButton jButton123;
    private javax.swing.JButton jButton124;
    private javax.swing.JButton jButton125;
    private javax.swing.JButton jButton126;
    private javax.swing.JButton jButton127;
    private javax.swing.JButton jButton128;
    private javax.swing.JButton jButton129;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton130;
    private javax.swing.JButton jButton131;
    private javax.swing.JButton jButton132;
    private javax.swing.JButton jButton133;
    private javax.swing.JButton jButton134;
    private javax.swing.JButton jButton135;
    private javax.swing.JButton jButton136;
    private javax.swing.JButton jButton137;
    private javax.swing.JButton jButton138;
    private javax.swing.JButton jButton139;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton140;
    private javax.swing.JButton jButton141;
    private javax.swing.JButton jButton142;
    private javax.swing.JButton jButton143;
    private javax.swing.JButton jButton144;
    private javax.swing.JButton jButton145;
    private javax.swing.JButton jButton146;
    private javax.swing.JButton jButton147;
    private javax.swing.JButton jButton148;
    private javax.swing.JButton jButton149;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton150;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton62;
    private javax.swing.JButton jButton63;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton65;
    private javax.swing.JButton jButton66;
    private javax.swing.JButton jButton67;
    private javax.swing.JButton jButton68;
    private javax.swing.JButton jButton69;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton70;
    private javax.swing.JButton jButton71;
    private javax.swing.JButton jButton72;
    private javax.swing.JButton jButton73;
    private javax.swing.JButton jButton74;
    private javax.swing.JButton jButton75;
    private javax.swing.JButton jButton76;
    private javax.swing.JButton jButton77;
    private javax.swing.JButton jButton78;
    private javax.swing.JButton jButton79;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton80;
    private javax.swing.JButton jButton81;
    private javax.swing.JButton jButton82;
    private javax.swing.JButton jButton83;
    private javax.swing.JButton jButton84;
    private javax.swing.JButton jButton85;
    private javax.swing.JButton jButton86;
    private javax.swing.JButton jButton87;
    private javax.swing.JButton jButton88;
    private javax.swing.JButton jButton89;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButton90;
    private javax.swing.JButton jButton91;
    private javax.swing.JButton jButton92;
    private javax.swing.JButton jButton93;
    private javax.swing.JButton jButton94;
    private javax.swing.JButton jButton95;
    private javax.swing.JButton jButton96;
    private javax.swing.JButton jButton97;
    private javax.swing.JButton jButton98;
    private javax.swing.JButton jButton99;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JTextField jCity;
    private javax.swing.JPanel jCityPanel;
    private javax.swing.JTextField jCountry;
    private javax.swing.JTextField jCountryX;
    private javax.swing.JTextField jEmail;
    private javax.swing.JTextField jEmailX;
    private javax.swing.JPanel jEventPanel;
    private javax.swing.JPanel jFamilyPanel;
    private javax.swing.JPanel jFinalPanel;
    private javax.swing.JLabel jFinalPic;
    private javax.swing.JTextField jFirstLastNameX;
    private javax.swing.JTextField jFirstName;
    private javax.swing.JTextField jFrom;
    private javax.swing.JPanel jFrontPanel;
    private javax.swing.JPanel jGolfPanel;
    private javax.swing.JTextField jKvittAfanga;
    private javax.swing.JTextField jKvittArrive;
    private javax.swing.JTextField jKvittBrottfor;
    private javax.swing.JTextField jKvittDaytour;
    private javax.swing.JTextField jKvittDepart;
    private javax.swing.JTextField jKvittHotel;
    private javax.swing.JTextField jKvittPrice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> jLanguage;
    private javax.swing.JTextField jLastName;
    private javax.swing.JPanel jMainPanel;
    private javax.swing.JLabel jName;
    private javax.swing.JPanel jOfferPanel;
    private javax.swing.JButton jOk;
    private javax.swing.JPanel jOpenPackagePanel;
    private javax.swing.JPanel jOutdoorPanel;
    private javax.swing.JTextArea jPackDesc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JComboBox<String> jPassengers;
    private javax.swing.JTextField jPhone;
    private javax.swing.JTextField jPhoneX;
    private javax.swing.JPanel jRegResultsPanel;
    private javax.swing.JPanel jRegistrationPanel;
    private javax.swing.JButton jReset;
    private javax.swing.JPanel jResultPanel;
    private javax.swing.JTable jResultTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jSearch;
    private javax.swing.JPanel jSkiPanel;
    private javax.swing.JPanel jSunPanel;
    private javax.swing.JTextField jTo;
    private javax.swing.JPanel jTop;
    private javax.swing.JTextField jZip;
    private javax.swing.JTextField jZipCityX;
    // End of variables declaration//GEN-END:variables
}
