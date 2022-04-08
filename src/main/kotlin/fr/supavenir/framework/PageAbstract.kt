package fr.supavenir.framework

import org.apache.tools.ant.util.FileUtils
import org.openqa.selenium.By
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.chrome.ChromeDriver
import java.io.File
import java.lang.System.getProperty
import java.nio.file.Paths
import javax.imageio.ImageIO

abstract class PageAbstract(
    private val url: String
) {

    private val driver = ChromeDriver()

    val title: String
        get() = driver.title

    init {
        driver.navigate().to(url)
    }

    infix fun `click on`(what: String) {
        driver.findElement(By.xpath(what)).click()
    }

    infix fun `input in`(what: String): InputElement = InputElement(driver.findElement(By.xpath(what)))


    fun quit() {
        driver.quit()
    }

    infix fun `take screenshot and save as`(fileName: String) {
        val screenshotFile = driver.getScreenshotAs(OutputType.FILE)
        val fullImg = ImageIO.read(screenshotFile)
        ImageIO.write(fullImg, "png", screenshotFile)
        val destFile = File(Paths.get("./$fileName.png").toString())
        FileUtils.getFileUtils().copyFile(screenshotFile, destFile)
    }
}