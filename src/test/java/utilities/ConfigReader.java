package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    /*
    ConfigReader :
    -> Test class'i ile "configuration.properties" dosyasi arasinda iletisimi saglayan class'dir.
    -> Icerisinde ".properties" uzantili dosyayi okumak icin gerekli static blok olusturulur. Test class'indan
       kullanmak icin "getProperty()" method'u olusturulur. Bu method test class'indan gonderilen "key" degerlerini
       static blok yardimi ile "configuration.properties" dosyasinda bulup degeri dondurur.
    -> Properties class'indan properties objesi olusturulur. Static blokta bu dosya yolu properties objesine yuklenir.
    */

    public static Properties properties;

    static {

        String dosyaYolu = "configuration.properties";

        try {

            FileInputStream fis = new FileInputStream(dosyaYolu);

            properties = new Properties();
            properties.load(fis);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {

        return properties.getProperty(key);
    }
}
