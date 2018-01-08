package in.raster.cucumber.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static in.raster.cucumber.utilities.CurrentOS.LINUX;
import static in.raster.cucumber.utilities.CurrentOS.WINDOWS;

public final class CommonMethod {

    private static WebDriver driver;

    /*private enum OS {
        WINDOWS, LINUX, MAC
    };*/

    public CommonMethod(WebDriver driver) {
        this.driver = driver;
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
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.build().perform();
    }

    /**
     * @param element This function will wait (30 seconds) for the element, and then click on the element.
     */
    public static void clickOnAButton(WebElement element) {
        // can add a wait here to check if the element is present
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    // move this to utilities class

    public static void closeTheBrowser() {
        driver.close();
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
        CurrentOS os = CommonMethod.getOperatingSystem();

        setDriverProperty(os, browserPropertyValue);
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("headless"); // create a function for options
        chromeOptions.addArguments("window-size=1200x600");
        driver = new ChromeDriver(chromeOptions);
        return driver;
    }

    public static void setDriverProperty(CurrentOS os, String browserPropertyValue) {
        String driverPath = new PropertyReader().readProperty("driverBinariesPath");
        StringBuffer driverPathCreate = new StringBuffer(driverPath);

        if (os == WINDOWS && browserPropertyValue.equals("chrome")) {
            String chromeDriverWindowsBinaryExtension = new PropertyReader().readProperty("chromeDriverWindowsBinaryExtension");
            String chromeDriverSetPropertyValue = new PropertyReader().readProperty("chromeDriverSetPropertyValue");
            String chromeDriver = new PropertyReader().readProperty("chromeDriver");

            driverPathCreate.append(os.toString().toLowerCase()).append("/").append(chromeDriver).append(chromeDriverWindowsBinaryExtension);

            System.setProperty(chromeDriverSetPropertyValue, String.valueOf(driverPathCreate));

        } else if (os == LINUX && browserPropertyValue.equals("chrome")) {
            String chromeDriverLinuxBinaryExtension = new PropertyReader().readProperty("chromeDriverLinuxBinaryExtension");
            String chromeDriverSetPropertyValue = new PropertyReader().readProperty("chromeDriverSetPropertyValue");
            String chromeDriver = new PropertyReader().readProperty("chromeDriver");

            driverPathCreate.append(os.toString().toLowerCase()).append("/").append(chromeDriver).append(chromeDriverLinuxBinaryExtension);

            System.setProperty(chromeDriverSetPropertyValue, String.valueOf(driverPathCreate));

        } else if (os == LINUX && browserPropertyValue.equals("chrome")) {
            String chromeDriverLinuxBinaryExtension = new PropertyReader().readProperty("chromeDriverLinuxBinaryExtension");
            String chromeDriverSetPropertyValue = new PropertyReader().readProperty("chromeDriverSetPropertyValue");
            String chromeDriver = new PropertyReader().readProperty("chromeDriver");

            driverPathCreate.append(os.toString().toLowerCase()).append("/").append(chromeDriver).append(chromeDriverLinuxBinaryExtension);

            System.setProperty(chromeDriverSetPropertyValue, String.valueOf(driverPathCreate));
            
        }
    }

    public void init() {
        getAdministratorUrl();
        maximizeWindow();
    }
}
