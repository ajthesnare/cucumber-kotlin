package pages

import World
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory
import util.Constants.DEFAULT_TIMEOUT

abstract class BasePage(world: World) {
    abstract val url: String
    abstract val path: String

    private val driver = world.driver

    @FindBy(xpath = "//h3")
    val title: WebElement? = null

    init {
        AjaxElementLocatorFactory(driver, DEFAULT_TIMEOUT.toInt())
        PageFactory.initElements(driver, this)
    }

    abstract fun isLoaded() : Boolean

    fun get() {
        driver.get(url)
    }

    fun clickLink(linkText: String) {
        driver.findElement(By.xpath("//a[@href='/$linkText']")).click()
    }
}
