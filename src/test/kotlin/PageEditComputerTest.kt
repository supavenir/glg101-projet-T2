import fr.supavenir.computers.PageEditComputer
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PageEditComputerTest {

    private lateinit var robot: PageEditComputer

    @BeforeEach
    fun beforeEach() {
        robot = PageEditComputer()
        System.setProperty("webdriver.chrome.driver", "./chromedriver")
    }

    @AfterEach
    fun afterEach() {
        robot `take screenshot and save as` robot.getScenario().name
        robot.quit()
    }

    @Test
    fun editComputer() {
        robot `scenario is` "initial_edit_computer"
        assertTrue(robot.`edit computer`())
    }

    @Test
    fun bugEditComputer() {
        robot `scenario is` "bug_edit_computer"
        assertFalse(robot.`edit computer`())
    }

    @Test
    fun deleteComputer() {
        robot `scenario is` "initial_delete_computer"
        assertTrue(robot.`delete computer`())
    }
}