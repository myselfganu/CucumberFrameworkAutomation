package in.raster.cucumber.utilities;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public interface Driver {
    WebDriver getWebDriver();
    MutableCapabilities setDriverOptions(boolean headless);
}
