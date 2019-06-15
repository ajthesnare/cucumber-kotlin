package pages

import World
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory
import util.Constants.BASE_URL
import util.Constants.TIMEOUT_SEC_INT

class AddRemoveElementsPage(private var world: World) : BasePage(world) {
    override val path = "/add_remove_elements/"
    override val url = "$BASE_URL$path"
    override val pageTitle = "Add/Remove Elements"

    init {
        AjaxElementLocatorFactory(world.driver, TIMEOUT_SEC_INT)
        PageFactory.initElements(world.driver, this)
    }

    override fun get() {
        world.driver.get(url)
    }

    override fun isLoaded(): Boolean {
        val correctURL = world.driver.currentUrl == url
        val titleDisplayed = getH3Heading().isDisplayed
        val titleCorrect = getH3HeadingText().contains(pageTitle)
        return correctURL && titleDisplayed && titleCorrect
    }
}
