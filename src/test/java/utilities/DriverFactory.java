package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
                driver = new ChromeDriver();
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
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
