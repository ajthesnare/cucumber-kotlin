import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import util.Constants.DEFAULT_TIMEOUT
import java.time.LocalDateTime
import java.util.concurrent.TimeUnit

class World {
    lateinit var driver: WebDriver

    fun setUpChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\A.J\\Development\\chromedriver.exe")
        driver = ChromeDriver()
        driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
    }

    fun retry(timeoutMs: Long = 30000, intervalMs: Long = 100, block: () -> Any) {
        val timeoutSeconds = timeoutMs / 1000
        val endTime = LocalDateTime.now().plusSeconds(timeoutSeconds)
        while (LocalDateTime.now() <= endTime) {
            try {
                block()
                return
            } catch (a: AssertionError) {
                Thread.sleep(intervalMs)
            } catch (e: Exception) {
                Thread.sleep(intervalMs)
            }
        }
        block()
    }
}
