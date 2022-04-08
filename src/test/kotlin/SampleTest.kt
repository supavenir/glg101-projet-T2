import fr.supavenir.computers.PageHome
import fr.supavenir.framework.Scenario
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.io.BufferedReader
import java.nio.file.Paths
import kotlin.test.Test

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SampleTest {

    private val robot = PageHome()


    @BeforeAll
    fun beforeAll() {
        System.setProperty("webdriver.chrome.driver","/Users/thomasft/Sites/MAMP/CAI/GLG101/Projet/chromedriver")
    }

    @AfterAll
    fun afterAll() {
        robot.quit()
    }

    @Test
    fun test() {
        val data = Scenario `is` "initial"

        val buttonAdd = data `get` "buttonAdd"
        val searchInput = data `get` "searchInput"
        val searchButton = data `get` "searchButton"

        //robot `click on` buttonAdd

        robot `input in` searchInput text "Coucou, Thomas le BG"

        robot `click on` searchButton

        robot `take screenshot and save as` "test"
    }
}