package hook;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {

    /*
    Hooks :
    -> Her scenario'lardan once veya sonra calisan kod bloklarina sahip class'dir.
    -> Cucumber'da stepDefinitions package icerisinde @before ve @after gibi notasyonlar var ise extend
       yapmadan her scenario'dan once veya sonra bu method'lar calisir. Bu da istenilen durum degildir.
       Bu notasyonlar'a ihtiyac olmasi durumunda hooks class'i kullanilir.
    -> Cucumber hooks; kod calisma akisini daha iyi yonetmeyi kolaylastirir ve kod fazlaligini azaltir.
    -> @After notasyonu kullanilarak her senaryodan sonra test sonuclari kontrol edilip "FAİLED" olan durumlarda
       "screenshot" alinarak raporlama amaciyla kullanilir.
    */

    @After
    public void tearDown(Scenario scenario) {

        final byte[] screenshot = ((TakesScreenshot)

                Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

        if (scenario.isFailed()) {

            scenario.attach(screenshot, "image/png", "screenshots");
        }

        Driver.closeDriver();
    }
}
