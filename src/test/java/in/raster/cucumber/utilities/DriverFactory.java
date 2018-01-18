package in.raster.cucumber.utilities;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    protected static WebDriver webDriver;

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
