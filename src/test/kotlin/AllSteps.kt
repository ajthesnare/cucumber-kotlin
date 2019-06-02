
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import pages.ABTestingPage
import pages.AddRemoveElementsPage
import pages.HomePage
import kotlin.test.assertTrue

class AllSteps(var world: World) {
    @Given("^I am on the home page$")
    fun `I am on the home page`() {
        val homePage = HomePage(world)
        homePage.get()
    }

    @When("^I click the \"(.+)\" link$")
    fun `I click the {link} link`(linkText: String) {
        val homePage = HomePage(world)
        homePage.clickLink(linkText)
    }

    @Then("^the \"(.+)\" page should display$")
    fun `the {String} page should display`(pageOption: String) {
        val page = when (pageOption) {
            "A/B Testing" -> ABTestingPage(world)
            "Add/Remove Elements" -> AddRemoveElementsPage(world)
            else -> {
                throw Exception("Unknown page specified.")
            }
        }
        assertTrue(page.isLoaded())
    }
}
