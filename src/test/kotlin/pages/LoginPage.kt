package pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory
import support.World
import util.Constants.BASE_URL
import util.Constants.TIMEOUT_SEC_INT

class LoginPage(private var world: World) : BasePage(world) {
    init {
        AjaxElementLocatorFactory(world.driver, TIMEOUT_SEC_INT)
        PageFactory.initElements(world.driver, this)
    }

    @FindBy(id = "username")
    private val usernameField: WebElement? = null

    @FindBy(id = "password")
    private val passwordField: WebElement? = null

    @FindBy(xpath = "//button[@type='submit']")
    private val loginButton: WebElement? = null

    override val path = "/login"
    override val url = "$BASE_URL$path"
    override val pageTitle = "Login Page"

    override fun get() {
        navigateTo(url)
    }

    override fun isLoaded(): Boolean {
        val correctURL = world.driver.currentUrl == url
        val titleDisplayed = isH2HeadingDisplayed()
        val titleCorrect = h2HeadingText.contains(pageTitle)
        return correctURL && titleDisplayed && titleCorrect
    }

    fun populateUsername(username: String) {
        usernameField!!.sendKeys(username)
    }

    fun populatePassword(password: String) {
        passwordField!!.sendKeys(password)
    }

    fun clickLoginButton() {
        loginButton!!.click()
    }
}
