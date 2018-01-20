package in.raster.cucumber.utilities;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class CustomFirefoxDriver implements Driver {

    @Override
    public WebDriver getWebDriver() {
        boolean headless = Boolean.parseBoolean(new PropertyReader().readProperty("headless"));
        return new FirefoxDriver((FirefoxOptions) setFirefoxOptions(headless));
    }

    @Override
    public MutableCapabilities setDriverOptions(boolean headless) {
        return setFirefoxOptions(headless);
    }

    private static FirefoxOptions setFirefoxOptions(boolean headless) {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setHeadless(headless);
        return firefoxOptions;
    }
}
