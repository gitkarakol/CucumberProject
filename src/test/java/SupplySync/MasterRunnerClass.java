package SupplySync;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json"},
        glue = "SupplySync.steps_definitions",
        tags = "@creationOfMasterProfile or @EditMaster",
        dryRun = false
)


public class MasterRunnerClass {

}
