package in.raster.cucumber.utilities;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    protected static WebDriver webDriver;

    public static WebDriver createNewDriver(){
        String browserPropertyValue = new PropertyReader().readProperty("browser");
        switch (browserPropertyValue){
            case "FIREFOX":
                CommonMethod.setDriverProperty(browserPropertyValue);
                webDriver = new CustomFirefoxDriver().getWebDriver();
                break;
            case "CHROME":
                CommonMethod.setDriverProperty(browserPropertyValue);
                webDriver = new CustomChromeDriver().getWebDriver();
                break;
        }
        return webDriver; //throw an exception when the browsers mentioned get exhausted
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
