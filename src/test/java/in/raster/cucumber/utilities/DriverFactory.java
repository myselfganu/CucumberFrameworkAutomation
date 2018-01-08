package in.raster.cucumber.utilities;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static in.raster.cucumber.utilities.CommonMethod.createNeededDriver;

public class DriverFactory {

    protected static DriverFactory driverFactory = new DriverFactory();
    protected static WebDriver driver;

    private DriverFactory() {
    }

    public static WebDriver createNewDriver(){

        String browserPropertyValue = new PropertyReader().readProperty("browser");

        switch (browserPropertyValue){
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                driver = createNeededDriver(browserPropertyValue);
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                break;
        }
        return driver;
    }

    public static WebDriver getCurrentDriverInstance() {
        return driver;
    }

    public static void killDriver() {
        if (driver != null) { // if driver is not null then quit the driver.
            driver.quit();
            driver = null;
        }
    }

}