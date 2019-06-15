package steps

import World
import cucumber.api.java.en.When

class LinkSteps(var world: World) {
    @When("^I click the \"(.+)\" link$")
    fun `I click the {link} link`(linkText: String) {
        world.clickLinkByText(linkText)
    }
}
