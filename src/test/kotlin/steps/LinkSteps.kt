package steps

import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import io.cucumber.datatable.DataTable
import org.openqa.selenium.By
import support.World
import kotlin.test.assertTrue

class LinkSteps(var world: World) {
    @When("I click the {string} link")
    fun `I click the {link} link`(linkText: String) {
        world.clickLinkByText(linkText)
    }

    // todo: figure out a better way to handle the tabe
    @Then("the following links should display:")
    fun `the following links should display`(table: DataTable) {
        for (row in table.asMaps().toHashSet()) {
            val href = row["href"]
            val text = row["text"]
            assertTrue(world.driver.findElement(By.xpath("//a[@href='$href' and text()='$text']")).isDisplayed)
        }
    }
}
