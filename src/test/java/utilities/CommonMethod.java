package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class CommonMethod {

    private static WebDriver driver;

    public CommonMethod(WebDriver driver) {
        this.driver = driver;
    }

    public void init(){
        getAdministratorUrl();
        maximizeWindow();
    }

    public static void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public static void getAdministratorUrl() {
        driver.get(new PropertyReader().readProperty("administratorURL"));
    } // $$ property file reader n java

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

    // move this to utilities class
    /**
     *
     * @param element
     * This function will wait (30 seconds) for the element, and then click on the element.
     */
    public static void clickOnAButton(WebElement element){
        // can add a wait here to check if the element is present
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void closeTheBrowser() {
        driver.close();
    }

}
