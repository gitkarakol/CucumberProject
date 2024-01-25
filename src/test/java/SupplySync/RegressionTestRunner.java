package SupplySync;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "SupplySync.steps_definitions",
        tags = "@RegressionTest",
        plugin = {"html:target/RegressionTestReport.html", "pretty", "json:target/cucumber-reports/RegressionTest.json"}
)
public class RegressionTestRunner {
}
