package support

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import util.Constants.INTERVAL_MS
import util.Constants.TIMEOUT_MS
import util.Constants.TIMEOUT_SEC_LONG
import java.net.URL
import java.time.LocalDateTime
import java.util.concurrent.TimeUnit

class World {
    lateinit var driver: WebDriver
    var value: Int = 0

    fun setUpChromeDriver() {
        driver = when (System.getenv("ENV") ?: "local") {
            "local" -> {
                System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_BIN") ?: "chromedriver.exe")
                ChromeDriver()
            }
            "remote" -> {
                val capability = DesiredCapabilities.chrome()
                RemoteWebDriver(URL("http://localhost:4444/wd/hub"), capability)
            }
            else -> throw Exception("Invalid ENV: ${System.getenv("env")}")
        }
        driver.manage().timeouts().implicitlyWait(TIMEOUT_SEC_LONG, TimeUnit.SECONDS)
    }

    fun retry(timeoutMs: Long = TIMEOUT_MS, intervalMs: Long = INTERVAL_MS, block: () -> Any) {
        val timeoutSeconds = timeoutMs / 1000
        val endTime = LocalDateTime.now().plusSeconds(timeoutSeconds)
        while (LocalDateTime.now() <= endTime) {
            try {
                block()
                return
            } catch (t: Throwable) {
                Thread.sleep(intervalMs)
            }
        }
        block()
    }

    fun clickLinkByText(linkText: String) {
        driver.findElement(By.xpath("//a[text()='$linkText']")).click()
    }
}
