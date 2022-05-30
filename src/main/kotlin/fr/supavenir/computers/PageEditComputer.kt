package fr.supavenir.computers

import fr.supavenir.framework.PageAbstract
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.Select
import java.util.Date

class PageEditComputer : PageAbstract("https://computer-database.gatling.io/computers") {

    fun `edit computer`(): Boolean {
        this `click on` "//section[@id='main']/table/tbody/tr[1]/td[1]/a"

        val name = this `get data` "name"
        val dateIntroduced = this `get data` "dateIntroduced"
        val dateDiscontinued = this `get data` "dateDiscontinued"
        val company = this `get data` "company"

        this `input in` (this `get variable` "nameInput") text name

        this `input in` (this `get variable` "introducedInput") text dateIntroduced

        this `input in` (this `get variable` "discontinuedInput") text dateDiscontinued

        this `select in` (this `get variable` "companySelect") `by text` company

        this `click on` (this `get variable` "editComputerButton")

        if (!(this `check if element exist where xpath is` (this `get variable` "computerBanner"))) {
            return false
        }

        return "Done ! Computer .* has been updated".toRegex().matches((this `get element` (this `get variable` "computerBanner")).text)
    }

    fun `delete computer`(): Boolean {
        this `click on` "//section[@id='main']/table/tbody/tr[1]/td[1]/a"

        this `click on` (this `get variable` "deleteComputerButton")

        if (!(this `check if element exist where xpath is` (this `get variable` "computerBanner"))) {
            return false
        }

        return "Done ! Computer .* has been deleted".toRegex().matches((this `get element` (this `get variable` "computerBanner")).text)
    }
}