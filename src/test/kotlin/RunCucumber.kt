import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith
import org.testng.annotations.Test

@RunWith(Cucumber::class)
@CucumberOptions(
        features = ["src/test/resources/cucumber/features"],
        plugin = ["pretty", "html:target/reports"]
)

@Test
class RunCucumber
