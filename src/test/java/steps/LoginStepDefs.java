package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.AbstractPage;
import utilities.DriverFactory;
import utilities.PropertyReader;

public class LoginStepDefs extends DriverFactory {

    @Before
    public void beforeEveryScenario(){
        driver = new DriverFactory().getDriver();
        new AbstractPage(driver).getAdministratorUrl();
        new AbstractPage(driver).maximizeWindow();
    }

    @After
    public void afterEveryScenario(){
        new DriverFactory().killDriver();
    }

    @Given("^the user is on the login page$")
    public void the_user_is_on_the_login_page() throws Throwable {
        new LoginPage(driver).checkTheCurrentURL();
    }

    @And("^enter the username as \"([^\"]*)\"$")
    public void enter_the_username_as(String username) throws Throwable {
        new LoginPage(driver).enterUserName(username);
    }

    @And("^enter the password as \"([^\"]*)\"$")
    public void enter_the_password_as(String password) throws Throwable {
        new LoginPage(driver).enterPassword(password);
    }

    @And("^click on the Log in button$")
    public void click_on_the_Log_in_button() throws Throwable {
        new LoginPage(driver).clickOnLoginButton();
    }

    @Given("^user is logged using the credentials \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_is_logged_using_the_credentials_and(String username, String password) throws Throwable {
        new LoginPage(driver).checkTheCurrentURL();
        new LoginPage(driver).enterUserName(username);
        new LoginPage(driver).enterPassword(password);
        new LoginPage(driver).clickOnLoginButton();
        new DashboardPage(driver).checkIfMenuItemIsPresent("home");
    }
}
