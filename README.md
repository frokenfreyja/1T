# 1T - Netbeans, JavaSwing
### Elvar �rni Sturluson
### Henrietta ��ra Magn�sd�ttir
### Freyja Sigurg�slad�ttir
### Ragnar P�lsson 
�a� �arf a� setja upp MySql server til a� forriti� virki vegna klasanum API fr� HotelSearcher.jar fr� 1H h�pnum. 
API �r HotelSearcher.jar notar request � sl��ann localhost:8080/database.
Til a� koma framhj� �essu er h�gt a� nota klasann triphop/control/FakeHotelSearcherAdapter � sta�inn fyrir triphop/control/HotelSearcherAdapter � triphop/control/PackageManager klasanum.
Semsagt, breyta �arf l�nu 16 � PackageManager.java fr�: 
#####	private HotelSearcher hotelSearcher = new HotelSearcherAdapter();
�
#####	private HotelSearcher hotelSearcher = new FakeHotelSearcherAdapter(); 