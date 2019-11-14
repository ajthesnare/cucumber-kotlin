package support

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import util.Util

class World {
    lateinit var driver: WebDriver
    var value: Int = 0

    fun setDriver() {
        val util = Util(this)
        util.setDriver()
    }

    fun clickLinkByText(linkText: String) {
        driver.findElement(By.xpath("//a[text()='$linkText']")).click()
    }
}
