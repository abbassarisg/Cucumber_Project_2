package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    /*
    Driver :
    -> Test class'inda ve page class'inda kullanilacak driver'i olusturulan class'dir.
    -> Static olarak olusturulur ve getDriver() method icerisinde driver'a deger atamasi yapilir.
    -> Farkli browser'lari kullanmak icin driver'a switch statement ile tanimlama yapilir.
    -> En sonda driver kapatilmasi icin closeDriver() method'u olusturulur.
    -> POM'de Driver icin TestBase class'ina extends yapmak yerine Driver class'indan static method'lar
       kullanarak driver olusturulup ilgili ayarlarin yapilmasi ve en son driver'in kapatilmasi tercih edilir.
    */

    /*
    -> POM'de Driver class'indaki "getDriver()'in" obje olusturularak kullanilmasini engellemek icin
       "Singleton pattern" kullanimi tercih edilir.
    -> Singleton pattern : Tekli kullanimdir. Bir class'in farki class'lardan obje olusturularak kullanimini
       engellemek icin kullanilir. Bunu yapmak icin kullanilan constructor private yapilir ve baska class'larda
       Driver class'indan obje olusturulmasi mumkun olmaz.
    -> Test class’larindan kolayca ulasmak icin driver static olarak olusturulur.
    */

    private Driver() {

    }

    static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {

            switch (ConfigReader.getProperty("browser")) {

                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "edge" :
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                case "safari" :
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;

                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "headless-chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;

                default :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver() {

        if (driver != null) {

            driver.quit();

            driver = null;
        }
    }
}
