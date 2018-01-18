package in.raster.cucumber.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OurFirefoxDriver implements Driver {

    public static FirefoxOptions getFirefoxOptions(boolean headless) {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setHeadless(headless);
        //chromeOptions.addArguments("--start-maximized");
        return firefoxOptions;
    }

    @Override
    public WebDriver getWebDriver() {
        boolean headless = Boolean.parseBoolean(new PropertyReader().readProperty("headless"));
        return new FirefoxDriver(getFirefoxOptions(headless));
    }
}