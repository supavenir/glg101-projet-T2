package fr.supavenir.computers

import fr.supavenir.framework.PageAbstract
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.Select
import java.util.Date

class PageAddComputer : PageAbstract("https://computer-database.gatling.io/computers") {

    override fun `scenario is`(name: String) {
        super.`scenario is`(name)

        this `click on` (this `get variable` "addButton")
    }

    fun `add computer`(): Boolean {
        val name = this `get data` "name"
        val dateIntroduced = this `get data` "dateIntroduced"
        val dateDiscontinued = this `get data` "dateDiscontinued"
        val company = this `get data` "company"

        this `input in` (this `get variable` "nameInput") text name

        this `input in` (this `get variable` "introducedInput") text dateIntroduced

        this `input in` (this `get variable` "discontinuedInput") text dateDiscontinued

        this `select in` (this `get variable` "companySelect") `by text` company

        this `click on` (this `get variable` "createComputerButton")

        if (!(this `check if element exist where xpath is` (this `get variable` "computerBanner"))) {
            return false
        }

        return "Done ! Computer .* has been created".toRegex().matches((this `get element` (this `get variable` "computerBanner")).text)
    }
}