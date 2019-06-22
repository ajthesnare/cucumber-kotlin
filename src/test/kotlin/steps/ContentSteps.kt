package steps

import cucumber.api.java.en.Then
import org.junit.Assert.assertTrue
import org.openqa.selenium.By
import support.World

class ContentSteps(var world: World) {
    @Then("^the following text should display:$")
    fun `the following text should display`(tableText: List<String>) {
        for (text in tableText) {
            val locator = "//*[contains(text(), '$text')]"
            assertTrue(world.driver.findElement(By.xpath(locator)).isDisplayed)
        }
    }

    @Then("^the text for element \"h3\" should be one of the following:$")
    fun `the text for element {element} should be one of the following`(tableText: List<String>) {
        val elementText = world.driver.findElement(By.xpath("//h3")).text
        assertTrue(tableText.contains(elementText))
    }
}
