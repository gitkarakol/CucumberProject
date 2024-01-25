package SupplySync;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
    @RunWith(Cucumber.class)
    @CucumberOptions(
            plugin = {"html:target/cucumberReport.html","json:target/report.json"},
            features = "src/test/resources/features",
            glue = "SupplySync.steps_definitions",
            tags = "@CompanyEdit or @CompanyEditNegative",
            dryRun = false
    )


    public class CompanyRunner {
}
