package fr.supavenir.framework

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.apache.tools.ant.util.FileUtils
import org.openqa.selenium.By
import org.openqa.selenium.OutputType
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import java.io.File
import java.nio.file.Paths
import javax.imageio.ImageIO

abstract class PageAbstract(
    private val url: String
) {

    private var scenario: Scenario? = null
    protected val driver = ChromeDriver()
    private var data = hashMapOf<String, String>()

    val title: String
        get() = driver.title

    init {
        driver.navigate().to(url)
        val jsonString = File("./components.json").readText(Charsets.UTF_8)
        val type = object : TypeToken<HashMap<String, String>>() {}.type
        data = Gson().fromJson(jsonString, type)
    }

    infix fun `get element` (what: String): WebElement = driver.findElement(By.xpath(what))

    infix fun `click on`(what: String) {
        (this `get element` what).click()
    }

    infix fun `input in`(what: String): InputElement = InputElement((this `get element` what))

    infix fun `select in`(what: String): SelectElement = SelectElement((this `get element` what))

    protected infix fun `check if element exist where xpath is`(xpath: String): Boolean {
        return try {
            this `get element` xpath
            true
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            false
        }
    }

    fun quit() {
        driver.quit()
    }

    infix fun `take screenshot and save as`(fileName: String) {
        val screenshotFile = driver.getScreenshotAs(OutputType.FILE)
        val fullImg = ImageIO.read(screenshotFile)
        ImageIO.write(fullImg, "png", screenshotFile)
        val destFile = File(Paths.get("./screens/$fileName.png").toString())
        FileUtils.getFileUtils().copyFile(screenshotFile, destFile)
    }

    open infix fun `scenario is`(name: String) {
        scenario = Scenario `is` name
    }

    infix fun `get data`(name: String): String = scenario!! `get` name

    infix fun `get variable`(name: String): String = data[name]!!

    fun getScenario(): Scenario = scenario!!
}