# spring-library-application
springmvc-springboot-hibernate-jpa-maven


# KÜTÜPHANE UYGULAMASI

### Uygulama Özellikleri
* n tane kitap tanımlayabilme
* n tane yazar tanımlayabilme
* n tane yayınevi tanımlayabilme
* Var olan tüm kayıtlarda silme ve güncelleme işlemleri yapabilme
* Kitap eklerken , yazar ve yayınevini veritanında var olan kayıtlardan seçebilme
* Tüm cihazlarda kusursuz görünüm için **responsive** tasarım
* Farklı veritabanlarına geçiş kolaylığı
* Kitap adı, seri numarası, yazar veya isbn ile arama yapabilme
* Uygulama ilk çalıştığında veritabanı ve tabloları otomatik oluşturabilme gibi özellikleri uygulamada mevcuttur.


### Uygulamada Kullanılan Yazılım Dili ve Teknolojiler
* Java      
* Spring Framework     
* Thymeleaf     
* Maven     
* JPA       
* Hibernate     
* MySQL     
* JavaScript      
* CSS     
* Bootstrap     

### Uygulamayı Çalıştırabilmek İçin Gereksinimler ve Uygulanılacak Adımlar
* JDK kurulmalıdır. Spring Boot için minimum 1.8 ve sonrası sürümler kurulmalıdır. Bilgisayarınızda kurulum mevcut değilse  [buradan ](https://www.oracle.com/tr/java/technologies/javase-downloads.html) indirebilirsiniz.
* Veritabanı sunucusu kurulmalıdır. (Projede [WampServer](https://www.wampserver.com/en/) kullanılmıştır.)
* Yukarıdaki kurulumlar tamamlandıktan sonra kurulmuş olan IDE (STS, Eclipse vb.) açılarak **spring-library-application** projesi import edilir.
* Veritabanına erişim için **application.properties** dosyasına, veritabanı sunucusu için belirlediğiniz port numarası, kullanıcı adı ve şifre bilgileri girilmelidir.
* Proje çalıştırıldıktan sonra herhangi bir web tarayıcısı açılarak http://localhost:8081 adresine gidilir.(Not: adresin sonundaki 8081 port numarasıdır. Port çakışması durumunda **application.properties** dosyasından **server.port=8081** kısmı değiştirilmelidir.) 
