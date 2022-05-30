import fr.supavenir.computers.PageAddComputer
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PageAddComputerTest {

    private lateinit var robot: PageAddComputer

    @BeforeEach
    fun beforeEach() {
        robot = PageAddComputer()
        System.setProperty("webdriver.chrome.driver", "./chromedriver")
    }

    @AfterEach
    fun afterEach() {
        robot `take screenshot and save as` robot.getScenario().name
        robot.quit()
    }

    @Test
    fun addNewComputer() {
        robot `scenario is` "initial_add_computer"
        assertTrue(robot.`add computer`())
    }

    @Test
    fun bugAddNewComputer() {
        robot `scenario is` "bug_add_computer"
        assertFalse(robot.`add computer`())
    }
}