package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;


public class AbbasPage {

    public AbbasPage(){PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(id= "account-menu")
    public WebElement loginIcon;

    @FindBy(xpath = "(//span[text()='Register'])[1]")
    public WebElement register;

    @FindBy(css="h1#register-title")
    public WebElement registrationTitle;

    @FindBy(css = "input#firstPassword")
    public WebElement newPassword;

    @FindBy(css="input#secondPassword")
    public WebElement confirmPasswor;

    @FindBy(xpath = "//li[@class='point']")
    public List<WebElement> passwordStrength;

    @FindBy(xpath = "//div[text()='Your password is required to be at least 4 characters.']")
    public WebElement least4CharWarning;

    @FindBy(css="#firstPassword")
    public WebElement warningSymbol;

    @FindBy(css="input#email")
    public WebElement email;



}
