package in.raster.cucumber.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OurChromeDriver implements Driver {

    public static ChromeOptions getChromeOptions(boolean headless) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(headless);
        return chromeOptions;
    }

    @Override
    public WebDriver getWebDriver() {
        boolean headless = Boolean.parseBoolean(new PropertyReader().readProperty("headless"));
        return new ChromeDriver(getChromeOptions(headless));
    }
}
