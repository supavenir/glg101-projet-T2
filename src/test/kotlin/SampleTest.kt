import fr.supavenir.computers.PageHome
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import kotlin.test.Test
import kotlin.test.assertTrue

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SampleTest {

    private val robot = PageHome()


    @BeforeAll
    fun beforeAll() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver")
    }

    @AfterAll
    fun afterAll() {
        robot.quit()
    }

    @Test
    fun computerExist() {
        robot `scenario is` "initial"

        assertTrue(robot `check existence of the computer that bears the name of` "ACE")
    }
}