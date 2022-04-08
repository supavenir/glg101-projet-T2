package fr.supavenir.framework

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class InputElement(private val element: WebElement) {
    infix fun text(text: String) {
        element.sendKeys(text)
    }
}