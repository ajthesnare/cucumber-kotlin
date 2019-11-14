package support

import cucumber.api.java.After
import cucumber.api.java.Before

class Hooks(private var world: World) {
    @Before
    fun `Runs before every scenario`() {
        world.setDriver()
    }

    @After
    fun `Runs after every scenario`() {
        world.driver.close()
    }
}
