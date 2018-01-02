package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import pages.DashboardPage;
import utilities.DriverFactory;

import java.util.List;

public class DashboardStepDefs extends DriverFactory {

    @Then("^check \"([^\"]*)\" menu label is shown$")
    public void check_menu_label_is_shown(String menuItem) throws Throwable {
        Assert.assertTrue("Menu Item is NOT Present :" + menuItem, new DashboardPage(driver).checkIfMenuItemIsPresent(menuItem));
    }

    @Then("^check following menu labels are shown: (.*)$")
    public void check_following_menu_labels_are_shown(List<String> menus) throws Throwable {
        for (String menu :
                menus
                ) {
            Assert.assertTrue("Menu Item is NOT Present :" + menu, new DashboardPage(driver).checkIfMenuItemIsPresent(menu));
        }
    }

    @Given("^hover mouse over the user image on the right corner$")
    public void hover_mouse_over_the_user_image_on_the_right_corner() throws Throwable {
        new DashboardPage(driver).mouseHoverTheUserMenu();
    }

    @Given("^click on Edit Account link$")
    public void click_on_Edit_Account_link() throws Throwable {
        new DashboardPage(driver).mouserHoverAndClickOnTheEditAccountsLink();
    }

}
