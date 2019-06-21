package steps

import support.World
import cucumber.api.java.en.Then
import org.junit.Assert.assertEquals

class ParallelSteps(var world: World) {
    @Then("^I set dynamic var to (\\d+)$")
    fun `I set dynamic var to {value}`(newValue: Int) {
        world.value = newValue
    }

    @Then("^dynamic var should be (\\d+)$")
    fun `dynamic var should be {value}`(expValue: Int) {
        assertEquals(world.value, expValue)
    }
}
