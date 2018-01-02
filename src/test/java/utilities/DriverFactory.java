package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    protected static DriverFactory driverFactory = new DriverFactory();
    protected static WebDriver driver;

    private DriverFactory() {
    }

/*    public static WebDriver initialize(){
        if (driver == null) {
            return createNewDriver();
        }
    }*/

    public static WebDriver createNewDriver(){

        String browser = new PropertyReader().readProperty("browser");

        switch (browser){
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                //chromeOptions.addArguments("headless");
                chromeOptions.addArguments("window-size=1200x600");
                driver = new ChromeDriver(chromeOptions);
                break;
        }
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void killDriver() {
        driver.quit();
        driver = null;
    }

}
