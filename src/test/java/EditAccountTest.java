
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
/*@CucumberOptions(features = "src/test/java/features/",
        glue = {"src/test/java/steps/SearchStepDefs.java"})*/

/*@CucumberOptions(format = { "json:target/REPORT_NAME.json", "pretty",
        "html:target/HTML_REPORT_NAME" }, features = { "src/test/java/features/" }, tags= "@Test")*/

@CucumberOptions(features = "src/test/java/com/ae/cucumber/features/" , tags = "@editAccount" ,
                    format = {"pretty", "html:target/cucumber", "json:target/cucumber-report.json"})

public class EditAccountTest {

}