package pages

import World
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory
import util.Constants.BASE_URL
import util.Constants.DEFAULT_TIMEOUT

class ABTestingPage(private var world: World) : BasePage(world) {
    override val path = "/abtest"
    override val url = "$BASE_URL$path"

    init {
        AjaxElementLocatorFactory(world.driver, DEFAULT_TIMEOUT.toInt())
        PageFactory.initElements(world.driver, this)
    }

    override fun isLoaded() : Boolean {
        val correctURL = world.driver.currentUrl == url
        val titleDisplayed = title!!.isDisplayed
        val titleCorrect = title.text.contains("A/B Test")
        return correctURL && titleDisplayed && titleCorrect
    }
}
