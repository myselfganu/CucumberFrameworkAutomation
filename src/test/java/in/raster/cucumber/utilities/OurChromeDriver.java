package in.raster.cucumber.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static java.lang.Boolean.parseBoolean;

public class OurChromeDriver implements Driver {

    /*@Override
    public Options getDriverOptions() {
        return (Options) DriverOptions.getChromeOptions(Boolean.parseBoolean(new PropertyReader().readProperty("headless")));
    }*/

    public static ChromeOptions getChromeOptions(boolean headless) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(headless);
        //chromeOptions.addArguments("--start-maximized");
        return chromeOptions;
    }

    @Override
    public WebDriver getWebDriver() {
        boolean headless = Boolean.parseBoolean(new PropertyReader().readProperty("headless"));
        return new ChromeDriver(getChromeOptions(headless));
    }
}
