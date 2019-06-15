package pages

import World
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory
import util.Constants.BASE_URL
import util.Constants.TIMEOUT_SEC_INT

class HomePage(private var world: World) : BasePage(world) {
    override val path = ""
    override val url = "$BASE_URL/"
    override val pageTitle = "Welcome to the-internet"

    init {
        AjaxElementLocatorFactory(world.driver, TIMEOUT_SEC_INT)
        PageFactory.initElements(world.driver, this)
    }

    override fun get() {
        world.driver.get(url)
    }

    override fun isLoaded(): Boolean {
        println(world.driver.currentUrl)
        val correctURL = world.driver.currentUrl == url
        val titleDisplayed = getH1Heading().isDisplayed
        val titleCorrect = getH1HeadingText().contains(pageTitle)
        return correctURL && titleDisplayed && titleCorrect
    }
}
