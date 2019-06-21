import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
        features = ["src/test/resources/cucumber/features"],
        tags = ["not @todo"],
        plugin = ["pretty", "html:target/reports"],
        glue = ["steps"]
)
class RunCucumber
