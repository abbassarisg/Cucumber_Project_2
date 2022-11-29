package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.DataBaseUtility.createConnection;
import static utilities.DataBaseUtility.getColumnData;


public class KullanciData {

    List<Object> actualData;
    @Given("kullanci connection kuarar")
    public void kullanci_connection_kuarar() {
        createConnection();
    }
    @Given("Kullanici tum yeni kayitli bilgileri ceker {string} ve {string}")
    public void kullanici_tum_yeni_kayitli_bilgileri_ceker_ve(String query, String columnName) {

        actualData = getColumnData(query,columnName);

    }
    @Then("Kullanici kullanici bilgilerini dogrular")
    public void kullanici_kullanici_bilgilerini_dogrular() {

        assertTrue("Data match etmedi",actualData.contains("456-25-6547"));
    }
}

