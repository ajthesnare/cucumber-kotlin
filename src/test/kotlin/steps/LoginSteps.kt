package steps

import cucumber.api.java.en.When
import io.cucumber.datatable.DataTable
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

    @When("I log in:")
    fun `I log in with credentials`(table: DataTable) {
        val loginPage = LoginPage(world)
        val tableMap =  table.asMaps().first()
        val username = tableMap["username"]!!
        val password = tableMap["password"]!!
        loginPage.populateUsername(username)
        loginPage.populatePassword(password)
        loginPage.clickLoginButton()
    }
}
