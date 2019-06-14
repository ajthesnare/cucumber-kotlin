package pages

import World
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory
import util.Constants.TIMEOUT_SEC_INT

abstract class BasePage(private var world: World) {
    abstract val url: String
    abstract val path: String
    abstract val pageTitle: String

    private val driver = world.driver

    @FindBy(xpath = "//h3")
    private val title: WebElement? = null

    init {
        AjaxElementLocatorFactory(driver, TIMEOUT_SEC_INT)
        PageFactory.initElements(driver, this)
    }

    abstract fun get()

    abstract fun isLoaded(): Boolean

    fun isPageLoaded(url: String, titleText: String): Boolean {
        val correctURL = world.driver.currentUrl == url
        val titleDisplayed = getTitle().isDisplayed
        val titleCorrect = getTitleText().contains(titleText)
        return correctURL && titleDisplayed && titleCorrect
    }

    private fun getTitle(): WebElement {
        return title!!
    }

    private fun getTitleText(): String {
        return title!!.text
    }
}
