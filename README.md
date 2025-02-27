# Sosyal Yardım Yönetim Sistemi 📌  

Bu proje, **JavaServer Faces (JSF), Bootstrap ve Oracle SQL** kullanılarak geliştirilen **web tabanlı bir sosyal yardım yönetim sistemi**dir.  

## 🚀 Özellikler  
✅ **Müracaat Yönetimi:** Kullanıcıların sosyal yardım taleplerini oluşturmasını sağlar.  
✅ **Veri Tabanı Entegrasyonu:** Oracle SQL kullanılarak güvenli veri yönetimi sağlanır.  
✅ **Modern Arayüz:** Bootstrap ile geliştirilmiş responsive tasarım.  
✅ **Kullanıcı Yetkilendirme:** Admin ve kullanıcı rollerine göre erişim kontrolü.  

## 🛠️ Kullanılan Teknolojiler  
- **Frontend:** JSF, Bootstrap, jQuery  
- **Backend:** Java, JSF Managed Beans  
- **Veritabanı:** Oracle SQL  

📌 **Daha fazla bilgi ve kod detayları için projeyi inceleyebilirsiniz!**  



# Gebze Sosyal Yardım sitesinin yapılışı için kılavuz

<hr>

## 1- Kurulumlar:
- Git  
- Github Desktop  
- JAVA 8 UPDATE 421  
- Eclipse Temurin JDK with hotspot 17.0.11  
- Java(TM) SE Development Kit 17.0.11  
- Apache Netbeans IDE 22  
- Oracle Database 19c Enterprise Edition ([indirme linki](https://edelivery.oracle.com/osdc/faces/SoftwareDelivery))  
(2. Maddedeki BTK akademi kursu ile birlikte kurmanız tavsiye edilir!)

<hr>

## 2- Video Kaynak:
JSF kullanımı ve website yapımı:  
[YouTube](https://www.youtube.com/watch?v=R4glkRS_6rE&list=PL4XQdSx4Y7b7VFll7oLNp9a2Nqp0dMsoI)

Database ile ilgili kısımları geçebilirsiniz çünkü farklı bir database kullanıyor.  
Eğer database kurulumunda ve/veya kullanımında sorun yaşarsanız:  
[BTK Akademi](https://www.btkakademi.gov.tr/portal/course/sifirdan-ileri-seviye-oracle-sql-19567)

SQL Developer kurduğunuzda butonlar çalışmıyorsa, eksikse ve uygulama penceresi bozuksa bu video ile halledebilirsiniz:  
[Oracle Çözüm](https://www.youtube.com/watch?v=xzBZ2eWss6k&t=1s)

<hr>

## 3- Netbeans'den proje oluşturmak:
1. Java Ant içinde Java Web'e gelin, "Web Application" seçeneğini seçin ve ilerleyin.  
2. Server seçme kısmında GlassFish seçin ve orada 6.2.5 sürümünü seçerek indirin.  
3. Firework seçme kısmında Java Faces seçin ve Server Libraries seçeneğinde 3.0 seçin.  
4. Finish diyerek bitirin.

<hr>

## 3.5- Otomatik tamamlamayı açmak:
Tools --> Options --> Editor --> Code Completion --> Language: Java --> ilk 3 seçenek tikli olmalı

<hr>

## 4- Glassfish hatası:
Eğer projeyi başlatmaya çalıştığınızda undeployed hatası alıyorsanız veya proje sürekli olarak yükleniyor olarak gözüküyorsa:  
1. Glassfish'in kurulu olduğu klasöre gidin (Netbeans'de soldaki alanda Services bölümünde servers kısmına tıklayın -->  
Glassfish yazısına sağ tıklayıp Properties ile yerini öğrenebilirsiniz).  
2. Burada bin klasörünün içinde `asadadmin.bat` dosyasını çalıştırıp "start-domain" yazıp çalıştırın. Artık projenin başlatılabilmesi gerekiyor.  
3. Hata aldığınız durumlarda ve arada projeye sağ tıklayıp önce "Clean", daha sonra ise "Deploy" çalıştırın ve projeyi sonra başlatın.

<hr>

## 5- Gerekli Kütüphaneeleri Kurmak:
1-Gerekli kütüphaneler:  
orai18n-19.3.0.0,  
ucp11,  
ojdbc11

!(Staj Görevlinize HIBERNATE mi yoksa JDBS mi kullanılacağını sorun --> Hibernate ise sadece orai18n'yi kurun)!  
Verdiğim kaynak hibernate kullanmıyor o yüzden kurulumunu ve kullanımını kendiniz araştırıp bulmalısınız.  
Eğer direkt olarak Github adresime erişiminiz varsa bu dosyaları src --> java --> ExternalLib klasörünün içinde bulabilirsiniz.  
Eğer bir hata sonucu projeye tekrar eklemeniz gerekmesi durumda kullanmanız için benim gibi Source Packages içine bir klasör oluşturup  
kütüphaneleri buraya atın. Attıktan sonra NetBeans içinde Libraries klasörüne sağ tıklayın ve Add JAR/Folder seçeneği ile kütüphaneleri buraya ekleyin.

<hr>

## 6- Projenin genel yapısı:
Öncelikle Source Packages kısmına 4 adet klasör oluşturun:

util --> içinde sadece DBConnection isimli bir sınıf bulunan ve veritabanı bağlantımızı sağlayan klasörümüzdür.  
Bu bir abstract sınıf olacak ve içinde sadece connect isimli bir metod yazılacak(Connection return etmeli)  
java.sql.Connection,  java.sql.DriverManager;  --> Bu iki kütüphaneyi import etmeyi unutmayın  
Kaynak videosunda bu metodun nasıl yapılacağı anlatılıyor

--  
Entity --> İçinde veritabanındaki ilgili tablonun değişkenlerini tutan java sınıflarını barındıracak  
Örnek olarak: Veritabanında Mahalle isimli bir tablo var ve içinde mahalle_id ve mahalle_isim sütunları var  
--> Entity içinde Mahalle isimli bir java sınıfı oluşturuyoruz  
--> içine private Integer mahalle_id ve private String mahale_isim şeklinde 2 değişken tanımlıyoruz  
-->ALT + INSERT yaparak hızlıca Getter Setter metodlarını oluşturun. Sonra aynı şekilde Constructor seçeneği ile boş ve dolu yapıcı metodlar oluşturun  
(Eğer mahalle_id otomatik veriliyorsa sadece mahalle_isim bulunduran bir yapıcı metod da oluşturun. Girmeniz gerekmeyen her değişken için bunu yapmanız sağlıklı olur)

--  
dao --> Entity içindeki değişkenleri kullanarak veritabanına satır eklemek, veri çekmek, listelemek, satır silmek gibi işlemler için kullanacağımız metodları buraya yazıyoruz.  
Öncelikle bağlantımızı almak için sınıf isminin yanına extends DBConnection ekliyoruz. "private Connection dbé isimli bir değişken tanımlıyoruz. Getter metoduna eğer null ise  
this.db = this.connect(); ile bağlantımızı sağlıyoruz.  
Ben şahsen gerekli metodlarımız için "CallableStatement" kullanmaya çalışıyorum --> Mantığı basit: veritabanında işlemi yerine getirecek ve gerekli parametreleri alacak bir stored procedure oluşturuyoruz  
ve kodumuzda bunu çağırıyoruz.  
Daha akla yatkın ama güvenlik sorunlarına neden olabilecek diğer yöntem ise "Statement" --> Temel mantığı string olarak yazdığımız veritabanı sql komutlarını Entity değişkenlerimizi vererek veritabanına göndermek olarak düşünebiliriz.  
Ayrıca ona çok benzeyen ve daha güvenli olan "PreparedStatement" kütüphanesini de araştırın.

Sınıf isimlendirmeleri genel olarak EntityDAO şeklinde yapılır. (örn:MahalleDAO)

--  
Controller --> Diğer Klasörlerin aksine burada CDI Bean dosyalarımız bulunacak ve websitemize buradan değişken atayabileceğiz ve değişkenimize ziyaretçi tarafından değer atanabilecek  
(Lütfen CDI Bean "Scope" türlerini araştırın ve uygun olanı seçin)  
Entity ve dao klasörlerimizdeki bağlantılı sınıfları burada aynı çuvala koyuyoruz. Temel olarak içinde 3 değişkenimiz var:  
Entity(Entity klasöründeki sınıfın ismi) entity;  
Dao(dao klasöründeki sınıfın ismi) dao;  
List<Entity> list; --> Bir tablonun içindeki verileri Entity nesneleri olarak depolayacak ve websitede liste olarak göstermemizi sağlayacak.

İsimlendirilmesi genel olarak EntityBean şeklinde yapılır  
Getter ve Setter kurduktan sonra Getter kısımlarına dao'da db değişkenine yaptığımız gibi eğer null ise yeni nesne üretmesini sağlayacağız

--  
Frontend kısmında Getter ve Setter yapılmayan değişkenler gözükmez!  
xhtml dosyamızda bu değişkenleri mesela inputtext oluştururken value = "#{mahalleBean.entity.mahalle_isim}" ile ziyaretçiden alınan yazının bu değişkene atanmasını sağlayabiliriz.  
(Burada mahalleBean.entity yazmış olabiliriz ama sistem otomatik olarak bu değişkene değil getter ve setter ile oluşturduğumuz getEntity() ve setEntity() metodlarına gider)  
Eğer bu değişkenlere atanan değerler ile bir insert veya silme işlemi yapmak isterseniz buton yaparken "value" yerine "action" kullanın.

<hr>

## 7- CSS değişiklikleri gözükmüyor:
Uzun süre css veya js dosyalarıyla oynadıktan sonra yaptığınız değişikliklerin siteye eklenmemesini yaşayabilirsiniz.  
Bunun nedeni sürekli projenizi tarayıcınızda açtığınızda tarayıcının bu proje için bir önbellek oluşturmasıdır.  
Bu sorunla karşılaştığınız zaman tarayıcınızın 1 veya 24 saatlik geçmişini silin

<hr>

## 8- Veritabanı:
Veritabanının nasıl olması gerektiğinden biraz bahsedelim.  
İlk önce her tablo için zorunlu olarak kullanacağımız sütunlar olacak. Bunlar: ABC_ID, AKTIF, KAYIT_TARIHI, EKLEYEN_KULLANICI_ID

ABC_ID --> Primary key olacak olan ilk sütunumuzdur, tabloyu oluştururken şu şekilde oluşturarak otomatik olarak artmasını sağlayabilirsiniz:  
ABC_ID NUMBER GENERATED by default on null as IDENTITY  
AKTIF --> Bu sütun o satırın aktif veya pasif olduğunu belirtir. Kolaylık açısından "number" ile oluşturup satırın durumuna göre 1 veya 0 atıyorum.  
KAYIT_TARIHI --> DATE türünde olan bu sütun kayıt yapıldığında o anki tarihi kayıt eder. Bunun için default değerini CURRENT_TIMESTAMP olarak ayarlayın.  
EKLEYEN_KISI_ID --> Bu ise o an siteyi giriş yapıp işlemleri gerçekleştiren kullanıcının id'si olacak. 

---  
Prosedürler: 
Procedures klasörünün altında bulunan saklı yordamların içinde insert yapan kodlar bulunuyor. Örnek bir saklı yordam:  
```sql
create or replace PROCEDURE INSERT_KISI_TEMEL (
    p_KIMLIK_NO IN KISI_TEMEL.KIMLIK_NO%TYPE,
    p_ISIM IN KISI_TEMEL.ISIM%TYPE,
    p_SOYISIM IN KISI_TEMEL.SOYISIM%TYPE,
    p_CINSIYET IN KISI_TEMEL.CINSIYET%TYPE,
    p_MEDENI_DURUM_ID IN KISI_TEMEL.MEDENI_DURUM_ID%TYPE,
    p_CILT_NO IN KISI_TEMEL.CILT_NO%TYPE,
    p_AILE_SIRA_NO IN KISI_TEMEL.AILE_SIRA_NO%TYPE,
    p_SIRA_NO IN KISI_TEMEL.SIRA_NO%TYPE,
    p_DOGUM_TARIHI IN KISI_TEMEL.DOGUM_TARIHI%TYPE,
    p_kisi_id OUT NUMBER
) AS
BEGIN
    INSERT INTO KISI_TEMEL (
        KIMLIK_NO, ISIM, SOYISIM, CINSIYET, MEDENI_DURUM_ID, CILT_NO, AILE_SIRA_NO, SIRA_NO, DOGUM_TARIHI
    ) VALUES (
        p_KIMLIK_NO, p_ISIM, p_SOYISIM, p_CINSIYET, p_MEDENI_DURUM_ID, p_CILT_NO, p_AILE_SIRA_NO, p_SIRA_NO, p_DOGUM_TARIHI
    )
    RETURNING KISI_ID INTO p_kisi_id;
END;
```

Burada gördüğünüz gibi içinde IN kullanılan satırlar bizim yordama verdiğimiz parametreler.  
sondaki OUT'u ise işlem sonucunda bize döndürülecek sayı olarak düşünebiliriz.  
Son satırdaki RETURNING INTO komutu --> Bize insert sonucunda otomatik olarak oluşacak id'yi verir.  
Fark ettiğiniz gibi kayit_tarihi ve KISI_ID sütunlarını buraya yazmadık çünkü bunlar otomatik oluşturulacak.  

<hr>
##Backend:

###Backend1 - Entity:  
Örnek olması amacıyla kisiAdres dosyalarını oluşturalım ve kullanalım.

İlk olarak kisiAdres.java dosyamızı entity klasöründe oluşturduk.  
Veritabanımızı açıyoruz ve tablo içindeki sütunlara bakıp bunları değişken olarak entity'e geçiriyoruz.  
number --> Integer,  
number(x),0) {x>11} -->BigInteger,  
VARCHAR, VARCHAR2 veya CLOB --> String, 
DATE --> DATE (java.util.date kütüphanesinden)  

Eğer tablonun içinde sokak_id gibi başka bir tabloya bağlanan bir sütun var ise onun için ekstra sokak_isim gibi bir değişken ekleyin.  
Bunun sebebi kullanıcıya veritabanında tutulan sokağın numarasını değil ismini göstermemiz gerekmesi.  
Daha sonra alt+insert ile tüm değişkenler için getter ve setter oluşturun.  
Hemen ardından yine alt+insert yapın ve Constructor seçeneği ile yapıcı metodları oluşturun:  
Boş bir yapıcı ,
hepsi seçili bir yapıcı ,
sadece kullanıcıya gösterilecek değişkenleri barındıran bir yapıcı metod.

 Entity klasörü bu kadar.


 ###Backend2 - DAO:
 kisiAdresDAO.java dosyamızı oluşturuyoruz.

 İlk yapmamız gereken işlem public class ABC yazısından sonra extends DBConnection komutunu eklemektir.  
 Daha sonra private Connection db; isimli bir değişken ekleyin. Bu veritabanı bağlantımız için önemli.  
 Getter ve setter metodlarını ekledikten sonra Getter metodu şuna benzemeli:  
 ```java
     public Connection getDb() {
        if (this.db == null) {
            this.db = this.connect();
        }
        return db;
    }
```
Ekstra olarak mesaj isimli string bir değişken de ekleyin ve getter setter ekleyin.  

Daha sonra gerekli metodları yazmaya başlayalım. İlk olarak KisiAdresEkle:

~~~java
 public Integer KisiAdresEkle(KisiAdres kisiAdres) {
        try {
            Connection conn = this.getDb();
          
            String callQuery = "{call INSERT_KISI_ADRES(?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(callQuery);
            cs.setString(1, kisiAdres.getTarif());
            cs.setString(2, kisiAdres.getSite());
            cs.setInt(3, kisiAdres.getKapi_no());
            cs.setInt(4, kisiAdres.getDaire_no());
            cs.setInt(5, kisiAdres.getKisi_adres_mahalle_id());
            cs.setInt(6, kisiAdres.getKisi_mahalle_sokak_id());
            cs.setInt(7, kisiAdres.getAktif());
            cs.registerOutParameter(8, java.sql.Types.INTEGER);

            cs.execute();
            
            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";
            return cs.getInt(8);

        } catch (Exception ex) {
            this.mesaj = DetectError(ex);
            return null;
        }

    }
~~~
public Integer --> Bu metodu Integer değer döndürmesi için ayarladık çünkü işlem sonucunda oluşan ID'yi başka bir tabloda kullanmak için döndürüceğiz.  

Parametre olarak entity dosyamızı veriyoruz. Daha sonra bean dosyamızda yeni bir entity objesi oluşturarak parametreyi dolduracağız.  

try - catch blokları --> kodlarımızı barındıran bu bloklarda eğer try bloğunun içinde bir hata olursa catch bloğuna geçer.  
Catch bloğunun parametresi olaran Exception ex ise hata hakkındaki detaylı bilgileri barındırır.  

try'dan sonra ilk yazdığımız kod ile veritabanına bağlanıyoruz.  
String callQuery ile veritabanından daha önceden yazdığımız saklı yordamı çağırıyoruz.  
Eğer saklı yordamımız olmasaydı ve Statement kullansaydık tüm insert komutunu buraya yazmamız gerekirdi. Bu tarz java kodununu içinde sql yazdığımız için profesyonelce olmazdı ve ayrıca kodlarımız metod sayımıza göre yüzlerce satır artabilirdi.  
String içindeki soru işaretleri saklı yordamın her bir parametresine denk geliyor. Parametre sırasını doğru ayarladığınızdan emin olun.  
Soru işareti sayısı toplam IN ve OUT kullanımı kadar olmalı.  
Sondaki  "cs.registerOutParameter(8, java.sql.Types.INTEGER);" kodu ile OUT ile ayarladığımız ID'mizi elde ediyoruz ve return cs.getInt(8) diyerek döndürüyoruz.  


catch metodunun içinde DetectError benim yazdığım bir hata detayı öğrenme fonksiyonu. Kullanmak isterseniz aşağıya ekliyorum:  

~~~java
public class ErrorFinder {

    public static String DetectError(Exception ex) {
        //Hatayı yakalamak için
        FacesContext context = FacesContext.getCurrentInstance();
        StringBuilder errorMessage = new StringBuilder(ex.getMessage());
        StackTraceElement[] stackTrace = ex.getStackTrace();

        //Hatanın hangi satırda olduğunu görmek için
        for (StackTraceElement element : stackTrace) {
            errorMessage.append(" (at ").append(element.getFileName())
                    .append(":").append(element.getLineNumber()).append(")");
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage.toString(), null));
        }
        return errorMessage.toString();
    }

}
~~~
Bu metodu statik yaptım. Bu sayede her dosyada "new" ile bu dosyadan bir obje üretmek zorunda olmuyorum.  

Silme metodu kısa olduğu için saklı yordam oluşturmadım ve direkt PreparedStatement kullandım:  

~~~java
 public void KisiAdresSil(int kisiAdresid) {
        String deleteQuery = "DELETE FROM KISI_ADRES WHERE KISI_ADRES_ID = ?";

        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, kisiAdresid);
            int rowsDeleted = ps.executeUpdate();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (SQLException ex) {
            this.mesaj = DetectError(ex);
        }
    }
~~~

Kullanıcıya verileri bir liste halinde göstermek isterseniz her satır için bir obje üretip değişkenleri aktarıyoruz:  

~~~java
 public List<KisiAdres> KisiAdresListesi() {
        List<KisiAdres> kisiAdresList = new ArrayList<>();

        try {
           String query = "SELECT KA.KISI_ADRES_ID, KA.ILCE, KA.TARIF, KA.SITE, KA.KAPI_NO, KA.KISI_ADRES_MAHALLE_ID, " +
               "KMS.SOKAK_ISIM, KA.KAYIT_TARIHI, KA.AKTIF " +
               "FROM KISI_ADRES KA " +
               "JOIN KISI_ADRES_MAHALLE M ON M.KISI_ADRES_MAHALLE_ID = KA.KISI_ADRES_MAHALLE_ID " +
               "JOIN KISI_MAHALLE_SOKAK KMS ON KMS.MAHALLE_ID = M.KISI_ADRES_MAHALLE_ID";

            Statement statement = getDb().createStatement();
            ResultSet rs = statement.executeQuery(queryBuilder.toString());

            while (rs.next()) {
                kisiAdresList.add(new KisiAdres(
                        rs.getString("TARIF"),
                        rs.getString("SITE"),
                        rs.getInt("DAIRE_NO"),
                        rs.getInt("KAPI_NO"),
                        rs.getString("KISI_ADRES_MAHALLE_ID"),
                        rs.getString("KISI_MAHALLE_SOKAK_ID"),
                        new java.util.Date(rs.getDate("KAYIT_TARIHI").getTime()),
                        rs.getInt("AKTIF")
                ));
            }

            this.mesaj = "işlem başarılı";

        } catch (Exception ex) {
            this.mesaj = DetectError(ex);
        }
        return kisiAdresList;
    }
~~~

Bu kısım için saklı yordam oluşturmak daha mantıklı aslında ama alışkanlık olduğu için buraya yazdım. Belki ileride saklı yordamlara dönüştürürüm.  
Siz direkt olarak saklı yordam yazın en iyisi.  

Burada join işlemi yapıyoruz. Join işlemi, iki tabloyu da aynı olarak bulunan bir sütunu eşitleyerek tek bir büyük tablo gibi kullanmamızı sağlar.  
Bu işlem ile entity'e ekstra olarak yazdığımız sokak_isim gibi değişkenleri alacağız.  

Burada String içindeki tüm yazıyı veritabanında bir SQL Worksheet'e yapıştırarak size ne getireceğini görebilirsiniz.  
("+" işaretlerini ve çift tırnakları silmeyi unutmayın.)  

Her tablodan sonra yazan KA, M, KMS gibi kelimeler bizim uydurduğumuz (tablonun ismindeki kelimelerin baş harfleri) kısaltmalar.  
Uyarı --> Eğer buradaki gibi bir tabloya kısaltma verdiyseniz artık o komutta tablonun tam ismi ile işlem yapamazsınız.  

rs.next() --> Bu komut veri olan tüm satırlar getirilene kadar true döndürür. Bu sayede while döngüsüne koyup tüm bilgileri alıyoruz.

---
Tüm DAO sayfalarında olmasa bile KisiAdresGetir gibi isimlendirilmiş metodlarımız da vardır.  
Bu metodlar veritabanında sadece ID ve isimden oluşan tabloları xhtml sayfamızda seçenekler olarak kullanmamıza yararlar.  
Temel öğemiz "SelectItem"dir. Bu öğe kullanıcıya gösterilecek ve seçildiğinde döndürülecek olarak iki değer alır.  
Veritabanı komutu ile aldığımız ID ve isimleri Selectitem listeleri olarak tutarız ve kullanırız.  
Standard bir getir metodu:  
~~~java
public List<SelectItem> KisiAdresGetir() {
        List<SelectItem> TipList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();
            String Selectquery = "SELECT KISI_ADRES_ID, KISI_ADRES_ISIM FROM KISI_ADRES";

            ResultSet rs = statement.executeQuery(Selectquery);
            while (rs.next()) {
                TipList.add(new SelectItem(rs.getInt("KISI_ADRES_ID"), rs.getString("KISI_ADRES_ISIM")));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return TipList;
    }
~~~

Bunun dışında bir de filtreleme sistemimiz var. Bunun için fitreleme yapmak istediğimiz kısımları dao dosyamıza ayrı bir değişken olarak yazıyoruz.
Filtreleme işlemi sadece liste metodumuzun içinde gerçekleşiyor ve SQL temelli bir filtre oluyor. 

İlk önce String ile yazılmış komutu StringBuilder'e çeviriyoruz çünkü duruma göre string'e yeni string metinler bağlamak gerekecek. 
Şu şekle benzemeli:
~~~java
    StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT KA.KISI_ADRES_ID, KA.ILCE, KA.TARIF, KA.SITE, KA.KAPI_NO, KA.KISI_ADRES_MAHALLE_ID, KMS.SOKAK_ISIM, KA.KAYIT_TARIHI, KA.AKTIF FROM");
            queryBuilder.append("KISI_ADRES KA JOIN KISI_ADRES_MAHALLE M ON M.KISI_ADRES_MAHALLE_ID = KA.KISI_ADRES_MAHALLE_ID");
            queryBuilder.append("JOIN KISI_MAHALLE_SOKAK KMS ON KMS.MAHALLE_ID = M.KISI_ADRES_MAHALLE_ID WHERE 1=1");
~~~

Daha sonra ise StringBuilder içindeki SQL methodumuzun sonuna WHERE 1 = 1 yazıyoruz. Bu sayede birden fazla filtremiz var ise hepsinde "AND" anahtar kelimesini kullanabiliriz.
Daha sonra değişkenlerimize eğer bir filtre yoksa hangi değer olmaları gerektiğini belirleyin.  
Benim için isim değerleri -> "", sayı değerleri -> 0 ve aktiflik filtresi için ->2. Bu değerleri değişkeni oluşturduğunuz yere default değer olarak ekleyin.

Filte kısmımız ise şuna benzeyecek: 
~~~java
  if (aktif != 2) {
      queryBuilder.append("AND AKTIFLIK = ").append(aktif).append(" ");
  }

  if (!isim.isEmpty()) {
      queryBuilder.append("AND YAKINLIK_ISIM LIKE '%").append(isim).append("%' ");
  }

~~~
(Bu kısım kisiAdres'e ait değil)  
Buradaki "LIKE % isim %" ifadesi SQL'de içinde isim içindeki karakterler geçen kısımları filtreler.  
Eğer burada ikinci % işaretini koymazsanız sadede isim değişkeni ile bitenleri,  
ilk % işaretini koymazsanız ise sadece isim değişkeni ile başlayanları filtrelersiniz.

###Backend3 - Bean:

Burada bir java dosyası değil JSF CDI Bean dosyası oluşturuyoruz.  
Oluştururken scope kısmını iyi belirleyin. Bu iki tanesi işinizi görür:
SessionScoped --> Kullanıcı sitede gezindiği sürece bilgiler kaybolmaz, bean sıfırlanmaz ve yenisi oluşmaz.  
BeanScoped --> Her sayfa değiştirildiğinde tüm bilgiler sıfırlanır.

Bu dosya bizim xhtml sayfamız ile etkileşime geçen katmandır.  

Entity'deki değişkenlerimizi ve DAO'daki metodlarımızı buradan ekstra bir adımla çağırarak kullanıyoruz.  
Entity ve Dao dosyalarımızı şu şekilde yeni bir obje oluşturarak kullanabiliriz:  

~~~Java
private KisiAdres entity;
private KisiAdresDAO dao;
private List<KisiAdres> list;

 public KisiAdres getEntity() {
        if (entity == null) {
            entity = new KisiAdres();
        }
        return entity;
    }

    public void setEntity(KisiAdres entity) {
        this.entity = entity;
    }

    public KisiAdresDAO getDao() {
        if (dao == null) {
            dao = new KisiAdresDAO();
        }
        return dao;
    }

    public void setDao(KisiAdresDAO dao) {
        this.dao = dao;
    }

    public List<KisiAdres> getList() {
        list = getDao().KisiAdresListesi();
        return list;
    }

    public void setList(List<KisiAdres> list) {
        this.list = list;
    }

~~~

Bu kodlarda fark ettiğiniz üzere getter metodları normalden farklı. Bunları kendi elimizle ayarlıyoruz.  
Burada "Singleton Pattern" tasarım örüntüsünü kullanarak eğer bir nesne yoksa üretilmesini, var ise üretilen nesnenin kullanılmasını ve başka bir tane üretilmemesini sağlar.  
Burada bulunan liste aslında zorunlu değil ama isteğe bağlı olarak bizim gibi ekleyebilirsiniz.  

Sıra geldi DAO metodlarımızı çağırmaya. Metodları çağırmak için metodları çağıracak metodlar oluşturuyoruz.  
Aslında oldukça basit ve hepsi aynı şekilde oluşturuluyor. Mesela insert içeren methodumuz:

~~~java
public Integer ekle() {
        return this.getDao().KisiAdresEkle(getEntity());
    }
~~~
















