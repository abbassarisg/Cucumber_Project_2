package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(

        plugin = {"html:target/cucumber-reports.html",
                  "json:target/json-reports/cucumber.json",
                  "junit:target/xml-report/cucumber.xml"},
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@Smoke",
        dryRun = false
)

public class Runner {

    /*
    -> Runner class'inda class body icerisinde hicbir sey bulunmaz.
    -> Bu class'i onemli yapan 2 adet notasyon vardir.
       1.@RunWith(Cucumber.class) : Runner class'ina calisma ozelligi katar.
       2.@CucumberOptions : features, glue, tags, dryRun yer alir.
       -features : feature dosyalarinin dosya yolunu alir.
       -glue : stepDefinitions dosyalarinin dosya yolunu alir.
       -tags : Hangi tag calistirilmak istenilirse belirtilip calistirilir.
       -dryRun : .true; testler calistirilmadan eksik adimlari verir.
                 .false; testler driver ile calistirilir.
       -plugin : html raporlar almak ve diger yeni raporlar olusturmak icin kullanilir.
    */
}
