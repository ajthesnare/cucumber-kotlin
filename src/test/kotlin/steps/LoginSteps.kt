package steps

import cucumber.api.java.en.When
import pages.LoginPage
import support.World

class LoginSteps(var world: World) {
    @When("I log in")
    fun `I log in`() {
        val loginPage = LoginPage(world)
        loginPage.populateUsername("tomsmith")
        loginPage.populatePassword("SuperSecretPassword!")
        loginPage.clickLoginButton()
    }
}
