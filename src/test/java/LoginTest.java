
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/in/raster/cucumber/features/" ,
                    tags = "@loginFalseFail",
                    format = {"pretty", "html:target/cucumber", "json:target/cucumber-report.json"})
public class LoginTest {
}