package steps

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import pages.*
import support.World
import kotlin.test.assertTrue

class BasePageSteps(var world: World) {
    @Given("^I am on the \"(.+)\" page$")
    fun `I am on the {page} page`(pageOption: String) {
        val page = when (pageOption) {
            "Home" -> HomePage(world)
            "A/B Testing" -> ABTestingPage(world)
            "Add/Remove Elements" -> AddRemoveElementsPage(world)
            "Login" -> LoginPage(world)
            "Secure" -> SecurePage(world)
            else -> throw Exception("Unknown page specified: $pageOption")
        }
        page.get()
        assertTrue(page.isLoaded())
    }

    @Then("^the \"(.+)\" page should display$")
    fun `the {String} page should display`(pageOption: String) {
        val page = when (pageOption) {
            "Home" -> HomePage(world)
            "A/B Testing" -> ABTestingPage(world)
            "Add/Remove Elements" -> AddRemoveElementsPage(world)
            "Login" -> LoginPage(world)
            "Secure" -> SecurePage(world)
            else -> throw Exception("Unknown page specified: $pageOption")
        }
        assertTrue(page.isLoaded())
    }
}
