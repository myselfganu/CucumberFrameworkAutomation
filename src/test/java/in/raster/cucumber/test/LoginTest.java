package in.raster.cucumber.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/in/raster/cucumber/features/" ,
                    tags = "@LoginFeature",
                    glue = "in.raster.cucumber.steps",
                    format = {"pretty", "html:target/cucumber", "json:target/cucumber-report.json"})
public class LoginTest {
}
