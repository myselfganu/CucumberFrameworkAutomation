package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    protected static WebDriver driver;

    public DriverFactory() {
        initialize();
    }

    private void initialize(){
        if (driver == null) {
            createNewDriver();
        }
    }

    private void createNewDriver(){

        String browser = new PropertyReader().readProperty("browser");

        switch (browser){
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("headless");
                chromeOptions.addArguments("window-size=1200x600");
                driver = new ChromeDriver(chromeOptions);
                break;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void killDriver() {
        driver.quit();
        driver = null;
    }


}
