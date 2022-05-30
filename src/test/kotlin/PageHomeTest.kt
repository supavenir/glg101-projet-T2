import fr.supavenir.computers.OrderDirection
import fr.supavenir.computers.PageAddComputer
import fr.supavenir.computers.PageHome
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance
import java.util.*
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PageHomeTest {

    private lateinit var robot: PageHome

    @BeforeEach
    fun beforeEach() {
        robot = PageHome()
        System.setProperty("webdriver.chrome.driver", "./chromedriver")
    }

    @AfterEach
    fun afterEach() {
        robot `take screenshot and save as` robot.getScenario().name
        robot.quit()
    }

    @Test
    fun computerExist() {
        robot `scenario is` "initial_search_computer"
        assertTrue(robot.`check existence of the computer`())
    }

    @Test
    fun computerNotExist() {
        robot `scenario is` "bug_search_computer"
        assertFalse(robot.`check existence of the computer`())
    }

    @Test
    fun computerOrderByNameASC() {
        robot `scenario is` "initial_order_asc_computer"
        assertTrue(robot `order computers by name` OrderDirection.ASC)
    }

    @Test
    fun computerOrderByNameDESC() {
        robot `scenario is` "initial_order_desc_computer"
        assertTrue(robot `order computers by name` OrderDirection.DESC)
    }

    @Test
    fun computerGoNextPage() {
        robot `scenario is` "initial_go_next_page_computer"
        assertTrue(robot.`go next page`())
    }

    @Test
    fun computerGoPreviousPage() {
        robot `scenario is` "initial_go_previous_page_computer"
        robot.`go next page`()
        assertTrue(robot.`go previous page`())
    }

    @Test
    fun bugComputerGoPreviousPage() {
        robot `scenario is` "bug_go_previous_page_computer"
        assertFalse(robot.`go previous page`())
    }
}