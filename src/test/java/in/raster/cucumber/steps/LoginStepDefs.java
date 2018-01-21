package in.raster.cucumber.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import in.raster.cucumber.pages.DashboardPage;
import in.raster.cucumber.pages.LoginPage;
import in.raster.cucumber.utilities.CommonMethod;
import in.raster.cucumber.utilities.DriverFactory;

public class LoginStepDefs {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before // before every scenario
    public void beforeEveryScenario(){
        driver = DriverFactory.createNewDriver();
        new CommonMethod(driver).init();
        loginPage = new LoginPage(driver);
    }

    @After
    public void afterEveryScenario(Scenario scenario){
        if (scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        DriverFactory.killDriver();
    }

    @Given("^the user is on the login page$")
    public void the_user_is_on_the_login_page() throws Throwable {
        loginPage.checkTheCurrentURL();
    }

    @And("^enter the username as \"([^\"]*)\"$")
    public void enter_the_username_as(String username) throws Throwable {
        loginPage.enterUserName(username);
    }

    @And("^enter the password as \"([^\"]*)\"$")
    public void enter_the_password_as(String password) throws Throwable {
        loginPage.enterPassword(password);
    }

    @And("^click on the Log in button$")
    public void click_on_the_Log_in_button() throws Throwable {
        loginPage.clickOnLoginButton();
    }

    @Given("^user is logged using the credentials \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_is_logged_using_the_credentials_and(String username, String password) throws Throwable {
        loginPage.checkTheCurrentURL();
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        new DashboardPage(driver).checkIfMenuItemIsPresent("home");
    }

    @Then("^check the login button has text \"([^\"]*)\"$")
    public void check_the_login_button_has_text(String textValue) throws Throwable {
        loginPage.checkLoginButtonText(textValue);
    }
}
