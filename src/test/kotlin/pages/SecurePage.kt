package pages

import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory
import support.World
import util.Constants.BASE_URL
import util.Constants.TIMEOUT_SEC_INT

class SecurePage(private var world: World) : BasePage(world) {
    init {
        AjaxElementLocatorFactory(world.driver, TIMEOUT_SEC_INT)
        PageFactory.initElements(world.driver, this)
    }

    override val path = "/secure"
    override val url = "$BASE_URL$path"
    override val pageTitle = "Secure Area"

    override fun get() {
        navigateTo(url)
    }

    override fun isLoaded(): Boolean {
        val correctURL = world.driver.currentUrl == url
        val titleDisplayed = isH2HeadingDisplayed()
        val titleCorrect = h2HeadingText.contains(pageTitle)
        return correctURL && titleDisplayed && titleCorrect
    }
}
