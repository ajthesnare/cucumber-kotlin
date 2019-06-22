package support

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import util.Constants.INTERVAL_MS
import util.Constants.TIMEOUT_MS
import java.net.URL
import java.time.LocalDateTime


class World {
    lateinit var driver: WebDriver
    var value: Int = 0

    fun setUpChromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_BIN") ?: "chromedriver.exe")

//        driver = ChromeDriver()
//        driver.manage().timeouts().implicitlyWait(TIMEOUT_SEC_LONG, TimeUnit.SECONDS)

        val capability = DesiredCapabilities.chrome()
        driver = RemoteWebDriver(URL("192.168.240.3"), capability)

    }

    fun retry(timeoutMs: Long = TIMEOUT_MS, intervalMs: Long = INTERVAL_MS, block: () -> Any) {
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

    fun clickLinkByText(linkText: String) {
        driver.findElement(By.xpath("//a[text()='$linkText']")).click()
    }
}
