package util

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import support.World
import util.Constants.INTERVAL_MS
import util.Constants.TIMEOUT_MS
import java.net.URL
import java.time.LocalDateTime
import java.util.concurrent.TimeUnit

class Util(private val world: World) {
    fun setDriver() {
        world.driver = when (System.getenv("ENV") ?: "local") {
            "local" -> {
                when (System.getProperty("browser")) {
                    "firefox" -> {
                        System.setProperty("webdriver.firefox.driver", System.getenv("FIREFOX_BIN")
                                ?: "ghekodriver.exe")
                        FirefoxDriver()
                    }
                    else -> {
                        System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_BIN") ?: "chromedriver.exe")
                        ChromeDriver()
                    }
                }
            }
            "remote" -> {
                val capability = when (System.getProperty("browser")) {
                    "firefox" -> DesiredCapabilities.firefox()
                    else -> DesiredCapabilities.chrome()
                }
                RemoteWebDriver(URL("http://localhost:4444/wd/hub"), capability)
            }
            else -> throw Exception("Invalid ENV: ${System.getenv("env")}")
        }
        world.driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT_SEC_LONG, TimeUnit.SECONDS)
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
}
