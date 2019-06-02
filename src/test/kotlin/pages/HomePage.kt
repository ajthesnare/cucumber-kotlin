package pages

import World
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory
import util.Constants.BASE_URL
import util.Constants.DEFAULT_TIMEOUT

class HomePage(private var world: World) : BasePage(world) {
    override val path = ""
    override val url = BASE_URL

    init {
        AjaxElementLocatorFactory(world.driver, DEFAULT_TIMEOUT.toInt())
        PageFactory.initElements(world.driver, this)
    }

    override fun isLoaded() : Boolean {
        val correctURL = world.driver.currentUrl == url
        val titleDisplayed = title!!.isDisplayed
        val titleCorrect = title.text.contains("pizza")
        return correctURL && titleDisplayed && titleCorrect
    }
}
