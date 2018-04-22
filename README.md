# 1T - Netbeans, JavaSwing
### Elvar Árni Sturluson
### Henrietta Þóra Magnúsdóttir
### Freyja Sigurgísladóttir
### Ragnar Pálsson 
Það þarf að setja upp MySql server til að forritið virki vegna klasanum API frá HotelSearcher.jar frá 1H hópnum. 
API úr HotelSearcher.jar notar request á slóðann localhost:8080/database.
Til að koma framhjá þessu er hægt að nota klasann triphop/control/FakeHotelSearcherAdapter í staðinn fyrir triphop/control/HotelSearcherAdapter í triphop/control/PackageManager klasanum.
Semsagt, breyta þarf línu 16 í PackageManager.java frá: 
#####	private HotelSearcher hotelSearcher = new HotelSearcherAdapter();
í
#####	private HotelSearcher hotelSearcher = new FakeHotelSearcherAdapter(); 