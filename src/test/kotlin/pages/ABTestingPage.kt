package pages

import World
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory
import util.Constants.BASE_URL
import util.Constants.TIMEOUT_SEC_INT

class ABTestingPage(private var world: World) : BasePage(world) {
    override val path = "/abtest"
    override val url = "$BASE_URL$path"
    override val pageTitle = "A/B Test"

    init {
        AjaxElementLocatorFactory(world.driver, TIMEOUT_SEC_INT)
        PageFactory.initElements(world.driver, this)
    }

    override fun get() {
        world.driver.get(url)
    }

    override fun isLoaded(): Boolean {
        return isPageLoaded(url, pageTitle)
    }
}
