package in.raster.cucumber.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import in.raster.cucumber.utilities.CommonMethod;
import in.raster.cucumber.utilities.PropertyReader;

public class LoginPage {

    private WebDriver driver;
    
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

    public void checkTheCurrentURL(){
        Assert.assertTrue("The URL is not correct" , driver.getCurrentUrl().equals(new PropertyReader().readProperty("administratorURL")));
    }

    public void enterUserName(String valueTOEnter){
        CommonMethod.clearAndEnterAValueInATextBox(userNameTextbox , valueTOEnter);
    }

    public void enterPassword(String valueToEnter){
        CommonMethod.clearAndEnterAValueInATextBox(passwordTextbox , valueToEnter);
    }

    public void clickOnLoginButton(){
        CommonMethod.clickOnAButton(submitButton);
    }

    public void checkLoginButtonText(String textValue){
        Assert.assertTrue("Login button doesnot contain the text",submitButton.getText().equals(textValue));
    }

}
