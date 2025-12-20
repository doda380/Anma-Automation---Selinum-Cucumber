package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/features",
        glue = {"step_definitions","Hooks"},
        tags = "@smoke",
        plugin = {"pretty",
                "html:target/cucumber-report/cucumber-pretty.html",
                "json:target/cucumber-report/cucumber-Test-Report.json",
                "junit:target/cucumber-report/cukes.xml",
                "rerun:target/cucumber-report/rerun.txt"
        },
        dryRun= false,
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
