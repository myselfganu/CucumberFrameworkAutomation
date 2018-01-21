package in.raster.cucumber.utilities;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CustomChromeDriver implements Driver {
    @Override
    public WebDriver getWebDriver() {
        boolean headless = Boolean.parseBoolean(new PropertyReader().readProperty("headless"));
        return new ChromeDriver((ChromeOptions) setDriverOptions(headless));
    }

    @Override
    public MutableCapabilities setDriverOptions(boolean headless){
        return setChromeOptions(headless);
    }

    private ChromeOptions setChromeOptions(boolean headless) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(headless);
        return chromeOptions;
    }
}
