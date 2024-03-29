package SupplySync;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "SupplySync.steps_definitions",
        tags = "@createNewBranch or @editBranch or @negativeTestCase" ,
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json"},
        dryRun = false

)

public class BranchTestRunner {
}
