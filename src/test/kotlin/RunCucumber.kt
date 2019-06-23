import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
        features = ["src/test/resources/cucumber/features"],
        plugin = ["pretty", "html:target/cucumber-reports"],
        glue = ["steps", "support"]
)
class RunCucumber
