package pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory
import support.World
import util.Constants.TIMEOUT_SEC_INT

abstract class BasePage(private val world: World) {
    init {
        AjaxElementLocatorFactory(world.driver, TIMEOUT_SEC_INT)
        PageFactory.initElements(world.driver, this)
    }

    @FindBy(xpath = "//h1")
    private val h1Heading: WebElement? = null

    @FindBy(xpath = "//h2")
    private val h2Heading: WebElement? = null

    @FindBy(xpath = "//h3")
    private val h3Heading: WebElement? = null

    abstract val url: String
    abstract val path: String
    abstract val pageTitle: String

    abstract fun get()
    abstract fun isLoaded(): Boolean

    fun navigateTo(url: String) {
        world.driver.get(url)
    }

    fun isH1HeadingDisplayed(): Boolean {
        return h1Heading!!.isDisplayed
    }

    val h1HeadingText: String get() = h1Heading!!.text

    fun isH2HeadingDisplayed(): Boolean {
        return h2Heading!!.isDisplayed
    }

    val h2HeadingText: String get() = h2Heading!!.text

    fun isH3HeadingDisplayed(): Boolean {
        return h3Heading!!.isDisplayed
    }

    val h3HeadingText: String get() = h3Heading!!.text
}
