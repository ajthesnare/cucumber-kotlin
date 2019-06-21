package steps

import support.World
import cucumber.api.java.en.Then
import io.cucumber.datatable.DataTable
import org.junit.Assert.assertTrue
import org.openqa.selenium.By

class ContentSteps(var world: World) {
    @Then("^the following text should display:$")
    fun `the following text should display`(table: DataTable) {
        val tableText = table.asList()
        for (text in tableText) {
            val locator = "//*[contains(text(), '$text')]"
            assertTrue(world.driver.findElement(By.xpath(locator)).isDisplayed)
        }
    }

    @Then("^the text for element \"h3\" should be one of the following:$")
    fun `the text for element {element} should be one of the following`(table: DataTable) {
        val tableText = table.asList()
        val elementText = world.driver.findElement(By.xpath("//h3")).text
        assertTrue(tableText.contains(elementText))
    }
}
