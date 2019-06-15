package steps

import World
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import pages.ABTestingPage
import pages.AddRemoveElementsPage
import pages.HomePage
import kotlin.test.assertTrue

class PageSteps(var world: World) {
    @Given("^I am on the \"(.+)\" page$")
    fun `I am on the {page} page`(pageOption: String) {
        val page = when (pageOption) {
            "Home" -> HomePage(world)
            "A/B Testing" -> ABTestingPage(world)
            "Add/Remove Elements" -> AddRemoveElementsPage(world)
            else -> throw Exception("Unknown page specified.")
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
            else -> throw Exception("Unknown page specified.")
        }
        assertTrue(page.isLoaded())
    }
}
