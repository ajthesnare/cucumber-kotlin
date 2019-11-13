package steps

import cucumber.api.java.en.When
import support.World
import util.Constants.BASE_URL

class UtilSteps(var world: World) {
    @When("I navigate to {string}")
    fun `I navigate to {string}`(url: String) {
        world.driver.get("$BASE_URL$url")
    }
}
