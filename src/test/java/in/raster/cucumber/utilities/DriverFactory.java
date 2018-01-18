package in.raster.cucumber.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static in.raster.cucumber.utilities.CommonMethod.createNeededDriver;

public class DriverFactory {

//    protected static DriverFactory driverFactory = new DriverFactory(); //works without the singleton
    protected static WebDriver webDriver;

/*    private DriverFactory() {
    }*/

    public static WebDriver createNewDriver(){

        String browserPropertyValue = new PropertyReader().readProperty("browser");

        switch (browserPropertyValue){
            case "FIREFOX":
                CommonMethod.setDriverProperty(browserPropertyValue);
                webDriver = new OurFirefoxDriver().getWebDriver();
                break;
            case "CHROME":
                CommonMethod.setDriverProperty(browserPropertyValue);
                webDriver = new OurChromeDriver().getWebDriver();
                //webDriver = createNeededDriver(browserPropertyValue);
                //webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                break;
        }
        return webDriver;
    }

    public static WebDriver getCurrentDriverInstance() {
        return webDriver;
    }

    public static void killDriver() {
        if (webDriver != null) { // if webDriver is not null then quit the webDriver.
            webDriver.quit();
            webDriver = null;
        }
    }

}
