package in.raster.cucumber.utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static in.raster.cucumber.utilities.CurrentOS.LINUX;
import static in.raster.cucumber.utilities.CurrentOS.WINDOWS;

public final class CommonMethod {
    private static WebDriver webDriver;

    public CommonMethod(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public static void maximizeWindow() {
        webDriver.manage().window().maximize();
    }

    public static void getAdministratorUrl() {
        webDriver.get(new PropertyReader().readProperty("administratorURL"));
    }

    public static void clearTextbox(WebElement element) {
        element.clear();
    }

    public static void clickOnElement(WebElement element) {
        element.click();
    }

    /**
     * @param textbox                  this is the webElement of the tetbo that you want to clear and enter text
     * @param valueToEnterInTheTextBox value that you want to enter in the textbox
     */
    public static void clearAndEnterAValueInATextBox(WebElement textbox, String valueToEnterInTheTextBox) {
        clearTextbox(textbox);
        clickOnElement(textbox);
        textbox.sendKeys(valueToEnterInTheTextBox);
    }

    /**
     * @param element This is the element where you want ot move the mouse cursor
     */
    public static void mouseHoverToElement(WebElement element) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element);
        actions.build().perform();
    }

    /**
     * @param element This function will wait (30 seconds) for the element, and then click on the element.
     */
    public static void clickOnAButton(WebElement element) {
        // can add a wait here to check if the element is present
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void closeTheBrowser() {
        webDriver.close();
    }

    public static CurrentOS getOperatingSystem() {
        String currentOS = System.getProperty("os.name").toLowerCase();
        CurrentOS os = null;
        if (currentOS.contains("win")) {
            os = WINDOWS;
        } else if (currentOS.contains("nux") || currentOS.contains("nix") || currentOS.contains("aix")) {
            os = LINUX;
        } else if (currentOS.contains("mac")) {
            os = CurrentOS.MAC;
        }
        return os;
    }

    public static WebDriver createNeededDriver(String browserPropertyValue) {
        setDriverProperty(browserPropertyValue);
        ChromeOptions chromeOptions = new ChromeOptions();
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().deleteAllCookies();
        return webDriver;
    }

    public static String getBinaryExtensionAccordingToTheOs(){
        CurrentOS os;
        switch (getOperatingSystem()){
            case WINDOWS:
                return ".exe";
            case MAC:
                return "";
            case LINUX:
                return "";
        }
        return null;
    }

    /* these are the names in the resource folder, the names are given by the respective driver providers */
    public static String getDriverName(String browserPropertyValue){
        switch (browserPropertyValue){
            case "CHROME":
                return "chromedriver";
            case "FIREFOX":
                return "geckodriver";
        }
        return null;
    }

    public static String getDriverForSetPropertyValue(String browserPropertyValue){
        switch (browserPropertyValue){
            case "CHROME":
                return "webdriver.chrome.driver";
            case "FIREFOX":
                return "webdriver.gecko.driver";
        }
        return null;
    }

    public static StringBuffer createDriverPath(String browserPropertyValue){
        String driverPathFromPropertyFile = new PropertyReader().readProperty("driverBinariesPath");
        StringBuffer driverPath = new StringBuffer(driverPathFromPropertyFile);
        driverPath.append(
                getOperatingSystem().toString().toLowerCase()).append("/").append(getDriverName(browserPropertyValue)).append(getBinaryExtensionAccordingToTheOs()
        );
        return driverPath;
    }

    public static void setDriverProperty(String browserPropertyValue) {
        switch(browserPropertyValue){
            case "CHROME":
                System.setProperty(getDriverForSetPropertyValue(browserPropertyValue),
                        String.valueOf(createDriverPath(browserPropertyValue)));
                break;
            case "FIREFOX":
                System.setProperty(getDriverForSetPropertyValue(browserPropertyValue),
                        String.valueOf(createDriverPath(browserPropertyValue)));
                break;
        }
    }

    public void init() {
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        getAdministratorUrl();
        maximizeWindow();
    }

    public void switchTOAlertAndClickOnAcceptButton(){
        Alert alert = webDriver.switchTo().alert();
        alert.accept();
    }

    public void switchTOAlertAndClickOnCancelButton(){
        Alert alert = webDriver.switchTo().alert();
        alert.dismiss();
    }

    public void rightMouseClickOnElement(WebElement element){
        Actions actions = new Actions(webDriver);
        actions.contextClick(element).perform();
    }

    public void dragAndDrop(WebElement source, WebElement target){
        Actions action = new Actions(webDriver);
        action.dragAndDrop(source, target).perform();
    }

    public void navigateBackInBrowser(){
        webDriver.navigate().back();
    }

    public void navigateForwardInBrowser(){
        webDriver.navigate().forward();
    }

    public void refreshBrowser(){
        webDriver.navigate().refresh();
    }

    public void scrollDown(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor )webDriver;
        javascriptExecutor.executeScript("window.scrollBy(0,4500)","");
    }
}
