package fr.supavenir.computers

import fr.supavenir.framework.PageAbstract

class PageHome : PageAbstract("https://computer-database.gatling.io/computers") {
    infix fun `check existence of the computer that bears the name of`(name: String): Boolean {
        val searchInput = this `get variable` "searchInput"
        val searchButton = this `get variable` "searchButton"

        this `input in` searchInput text name

        this `click on` searchButton
        val existInTableXPath = "//section[@id='main']/table[@class='computers zebra-striped']//*[contains(text(),'$name')]"

        return this `check if element exist where xpath is` existInTableXPath
    }
}