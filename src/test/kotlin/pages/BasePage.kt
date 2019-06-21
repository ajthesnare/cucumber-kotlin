package pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory
import support.World
import util.Constants.TIMEOUT_SEC_INT

abstract class BasePage(private var world: World) {
    abstract val url: String
    abstract val path: String
    abstract val pageTitle: String

    private val driver = world.driver

    @FindBy(xpath = "//h1")
    private val h1Heading: WebElement? = null

    @FindBy(xpath = "//h2")
    private val h2Heading: WebElement? = null

    @FindBy(xpath = "//h3")
    private val h3Heading: WebElement? = null

    init {
        AjaxElementLocatorFactory(driver, TIMEOUT_SEC_INT)
        PageFactory.initElements(driver, this)
    }

    abstract fun get()

    abstract fun isLoaded(): Boolean

    fun getH1Heading(): WebElement {
        return h1Heading!!
    }

    fun getH1HeadingText(): String {
        return h1Heading!!.text
    }

    fun getH2Heading(): WebElement {
        return h2Heading!!
    }

    fun getH2HeadingText(): String {
        return h2Heading!!.text
    }

    fun getH3Heading(): WebElement {
        return h3Heading!!
    }

    fun getH3HeadingText(): String {
        return h3Heading!!.text
    }
}
