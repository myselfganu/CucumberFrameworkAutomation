package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.AbstractPage;
import utilities.DriverFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage extends DriverFactory{

    WebDriver driver;
    private static String url = "https://demo.civihrhosting.co.uk/welcome-page";

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="edit-name")
    private WebElement userNameTextbox;

    @FindBy(id= "edit-pass")
    private WebElement passwordTextbox;

    @FindBy(id = "edit-submit")
    private WebElement submitButton;

    public void setup() {
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }



    public void checkTheCurrentURL(){
        //setup();
        Assert.assertTrue("The URL is not correct" , driver.getCurrentUrl().equals(url));
    }

    /**
     *
     * @param element
     * This function will wait (30 seconds) for the element, and then click on the element.
     */
    public void clickOnAButton(WebElement element){
        // can add a wait here to check if the element is present
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void closeTheBrowser() {
        driver.close();
    }

    public void enterUserName(String valueTOEnter){
        AbstractPage.clearAndEnterAValueInATextBox(userNameTextbox , valueTOEnter);
    }

    public void enterPassword(String valueToEnter){
        AbstractPage.clearAndEnterAValueInATextBox(passwordTextbox , valueToEnter);
    }

    public void clickOnLoginButton(){
        clickOnAButton(submitButton);
    }

}
