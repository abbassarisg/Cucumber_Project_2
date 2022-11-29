package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.AbbasPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class US_003_StepDefinitions {

    AbbasPage abbasPage=new AbbasPage();

    Actions actions=new Actions(Driver.getDriver());
    JavascriptExecutor executor=(JavascriptExecutor)Driver.getDriver();
    @Given("Belirtilen Url'e gidilir")
    public void belirtilen_url_e_gidilir() {

        Driver.getDriver().get(ConfigReader.getProperty("medUrl"));

    }
    @Then("Kullanici sayfada sag usste bulunan kisi iconuna tiklar ve sign in ve register segmesi acilir")
    public void kullanici_sayfada_sag_usste_bulunan_kisi_iconuna_tiklar_ve_sign_in_ve_register_segmesi_acilir() {
        abbasPage.loginIcon.click();
    }
    @Then("Acilan kutucukta register secenegini tiklanir")
    public void acilan_kutucukta_register_secenegini_tiklanir() {

        abbasPage.register.click();
    }
    @Then("Acilanin Register sayfasi oldugu dogrulanir.")
    public void acilanin_register_sayfasi_oldugu_dogrulanir() {
        abbasPage.registrationTitle.isDisplayed();



    }
    @Then("Register sayfasinda bulunan Password kismina en az bir kucuk harf girilir")
    public void register_sayfasinda_bulunan_password_kismina_en_az_bir_kucuk_harf_girilir() {
        abbasPage.newPassword.sendKeys("123456a");
    }
  //  @Then("{string} renk seviyesini degisti test edilir")
  //  public void renk_seviyesini_degisti_test_edilir(String string) {
  //
  //      List<WebElement> passwordStrength=abbasPage.passwordStrength;
  //      String expectedBarTwo="background-color: rgb(255, 153, 0);";
  //      String actualBarTwo=passwordStrength.get(1).getAttribute("style");
  //      System.out.println(actualBarTwo);
  //
  //      assertEquals(expectedBarTwo,actualBarTwo);
  //  }
    @Then("Acilan sayfa kapatilir")
    public void acilan_sayfa_kapatilir() {
        Driver.closeDriver();
    }

    @Then("Password kismina {string} girilir Password streght renk seviyesini degisti test edilir")
    public void password_kismina_girilir_password_streght_renk_seviyesini_degisti_test_edilir(String password) {


       switch (password){

           case "123456a":
               List<WebElement> passwordStrength=abbasPage.passwordStrength;
               JSUtils.scrollIntoViewJS(abbasPage.passwordStrength.get(1));
               abbasPage.newPassword.sendKeys(password);
               ReusableMethods.waitForVisibility(passwordStrength.get(1),2);
               String expectedBarTwo="background-color: rgb(255, 153, 0);";
               String actualBarTwo=passwordStrength.get(1).getAttribute("style");
               System.out.println(actualBarTwo);

               assertEquals(expectedBarTwo,actualBarTwo);




               break;

           case "123456A":
               abbasPage.newPassword.sendKeys(password);
               List<WebElement> passwordStrengthA=abbasPage.passwordStrength;
               JSUtils.scrollIntoViewJS(abbasPage.passwordStrength.get(1));
               ReusableMethods.waitForVisibility(passwordStrengthA.get(1),2);
               String expectedBarTwoA="background-color: rgb(255, 153, 0);";
               String actualBarTwoA=passwordStrengthA.get(1).getAttribute("style");
               System.out.println(actualBarTwoA);

               assertEquals(expectedBarTwoA,actualBarTwoA);

                break;
           case "aaaaaa1":
               abbasPage.newPassword.sendKeys(password);
               List<WebElement> passwordStrength1=abbasPage.passwordStrength;
               String expectedBarTwo1="background-color: rgb(255, 153, 0);";
               String actualBarTwo1=passwordStrength1.get(1).getAttribute("style");
               System.out.println(actualBarTwo1);

               assertEquals(expectedBarTwo1,actualBarTwo1);

               break;
           case "aaaaaa*":
               abbasPage.newPassword.sendKeys(password);
               List<WebElement> passwordStrengthO=abbasPage.passwordStrength;
               String expectedBarTwoO="background-color: rgb(255, 153, 0);";
               String actualBarTwoO=passwordStrengthO.get(1).getAttribute("style");
               System.out.println(actualBarTwoO);
               ReusableMethods.waitForPageToLoad(2);
               assertEquals(expectedBarTwoO,actualBarTwoO);

               break;
           case "aaaA1*":
               abbasPage.newPassword.sendKeys(password);
               List<WebElement> passwordStrength7Neg=abbasPage.passwordStrength;
               String expectedBarOne="background-color: rgb(255, 0, 0);";
               String actualBarOne=passwordStrength7Neg.get(0).getAttribute("style");
               System.out.println(actualBarOne);

               assertEquals(expectedBarOne,actualBarOne);

               break;
           case "aaaaA1*":
               abbasPage.newPassword.sendKeys(password);
               List<WebElement> passwordStrength7=abbasPage.passwordStrength;
               String expectedBarFive="background-color: rgb(0, 255, 0);";
               String actualBarFive=passwordStrength7.get(0).getAttribute("style");
               System.out.println(actualBarFive);

               assertEquals(expectedBarFive,actualBarFive);

               break;
           case "A1*":
               abbasPage.newPassword.sendKeys(password, Keys.ENTER);

             JSUtils.scrollIntoViewJS(abbasPage.least4CharWarning);
              abbasPage.least4CharWarning.isDisplayed();

           //  String actualWarningImage= abbasPage.warningSymbol.getCssValue("background-image");
           //  System.out.println("actualWarningImage = " + actualWarningImage);
           //  String expectedWarningImage=ConfigReader.getProperty("warningImg");
           //  assertEquals(expectedWarningImage,actualWarningImage);


           //   String actualShadow=abbasPage.warningSymbol.getCssValue("box-shadow");
           //   System.out.println("actualShadow = " + actualShadow);
           //   String expectedShadow="rgba(240, 65, 36";

           //   assertTrue(actualShadow.contains(expectedShadow));
              
               
               

               break;


       }
    }

    @Given(": Kullanici Ascii Code {string} den sonraki karakterkerden olusan bir sifre gonderir")
    public void kullanici_ascii_code_den_sonraki_karakterkerden_olusan_bir_sifre_gonderir(String aralik) {
        abbasPage.loginIcon.click();
        abbasPage.register.click();

        String a;
        List<String> asciiToString = new ArrayList<>();
        for (int i =0; i <178 ; i++) {
            a=""+(char)i;
            //a=Character.toString(i);
            asciiToString.add(a);
        }
        System.out.println("asciiToString = " + asciiToString);

        List<String> passworList=new ArrayList<>();
        String b="";
        String c="";
        String d="";
        String e="";
        String f="";


        for (int i = 0; i <176 ; i++) {


            //abbasPage.newPassword.sendKeys(asciiToString.get(i));


            if(i>1 && i<25){
                b=b.concat(asciiToString.get(i));
                // System.out.println("b = " + b);
                if(i==24){
                    passworList.add(b);
                }

            }else if (i>26 && i<50){
                c=c.concat(asciiToString.get(i));
                // System.out.println("c = " + c);

                if(i==49){
                    passworList.add(c);
                }

            }
            else if (i>50 && i<=75){
                d=d.concat(asciiToString.get(i));
                //System.out.println("d = " + d);
                if(i==75){
                    passworList.add(d);}


            }else if (i>128 && i<=150){
                e=e.concat(asciiToString.get(i));
                //System.out.println("e = " + e);
                if(i==149){
                    passworList.add(e);
                }

            }else if (i>151 && i<175) {
                f = f.concat(asciiToString.get(i));
                //System.out.println("f= " + f);
                if (i==174){
                    passworList.add(f);
                }

            }


        }
        System.out.println("passworList = " + passworList);

        if (aralik.equals("128-149") ||aralik.equals("151-174")){
            abbasPage.email.sendKeys(passworList.get(4));
            abbasPage.newPassword.sendKeys(passworList.get(4));
            try {
                ReusableMethods.getScreenshotWebElement("email",abbasPage.email);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        System.out.println(aralik);



    }
    @Then(": Kullanici Password Strenght {string} degistigini test eder")
    public void kullanici_password_strenght_degistigini_test_eder(String renk) {


       // executor.executeScript("arguments[0].scrollIntoView(true)",abbasPage.passwordStrength);
        try {
            ReusableMethods.getScreenshot("Password");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        List<WebElement> passwordStrength=abbasPage.passwordStrength;
        String actualBarOne=passwordStrength.get(4).getAttribute("style");
        System.out.println(actualBarOne);

        assertEquals(renk,actualBarOne);

    }


}
