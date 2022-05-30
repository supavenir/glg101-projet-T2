package fr.supavenir.framework

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select

class SelectElement(private val webElement: WebElement) {

    private val selectElement: Select = Select(webElement)

    infix fun `by text`(text: String) {
        selectElement.selectByVisibleText(text)
    }

    infix fun `by value`(value: String) {
        selectElement.selectByValue(value)
    }

    infix fun `by index`(index: Int) {
        selectElement.selectByIndex(index)
    }
}