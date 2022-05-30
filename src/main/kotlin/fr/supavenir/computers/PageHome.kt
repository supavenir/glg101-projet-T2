package fr.supavenir.computers

import fr.supavenir.framework.PageAbstract

class PageHome : PageAbstract("https://computer-database.gatling.io/computers") {
    fun `check existence of the computer`(): Boolean {
        val name = this `get data` "name"
        this `input in` (this `get variable` "searchInput") text name

        this `click on` (this `get variable` "searchButton")
        val existInTableXPath = "//section[@id='main']/table[@class='computers zebra-striped']//*[contains(text(),'$name')]"

        return this `check if element exist where xpath is` existInTableXPath
    }

    infix fun `order computers by name`(direction: OrderDirection): Boolean {
        return if (direction === OrderDirection.ASC) {
            this `check if element exist where xpath is` "//section[@id='main']/table/tbody/tr[1]/td[1]/a[.='ACE']"
        } else {
            this `click on` (this `get variable` "tableThComputerName")
            this `check if element exist where xpath is` "//section[@id='main']/table/tbody/tr[1]/td[1]/a[.='lenovo thinkpad z61p']"
        }
    }

    fun `go next page`(): Boolean {
        if (!(this `check if element exist where xpath is` (this `get variable` "nextPageButton"))) {
            return false
        }
        this `click on` (this `get variable` "nextPageButton")
        return true
    }

    fun `go previous page`(): Boolean {
        if (!(this `check if element exist where xpath is` (this `get variable` "previousPageButton"))) {
            return false
        }
        this `click on` (this `get variable` "previousPageButton")

        return true
    }
}