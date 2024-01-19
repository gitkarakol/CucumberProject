package SupplySync.steps_definitions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumberReport.html","json:target/report.json"},
        features = "src/test/resources/features",
        glue = "step_definitions",
        tags = "@printUrlTitle",
        dryRun = true
)


public class MasterRunnerClass {


}
