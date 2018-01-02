package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AbstractPage {

    WebDriver driver = DriverFactory.getDriver();

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void getAdministratorUrl() {
        driver.get(new PropertyReader().readProperty("administratorURL"));
    }

    public static void clearTextbox(WebElement element) {
        element.clear();
    }

    public static void clickOnElement(WebElement element) {
        element.click();
    }

    /**
     *
     * @param textbox
     * this is the webElement of the tetbo that you want to clear and enter text
     * @param valueToEnterInTheTextBox
     * value that you want to enter in the textbox
     */
    public static void clearAndEnterAValueInATextBox(WebElement textbox, String valueToEnterInTheTextBox) {
        clearTextbox(textbox);
        clickOnElement(textbox);
        textbox.sendKeys(valueToEnterInTheTextBox);
    }

    /**
     *
     * @param element
     * This is the element where you want ot move the mouse cursor
     */
    public static void mouseHoverToElement(WebElement element){
        Actions actions = new Actions(DriverFactory.getDriver());
        actions.moveToElement(element);
        actions.build().perform();
    }

}
