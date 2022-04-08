package fr.supavenir.framework

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

data class Scenario(
    val name: String
) {
    private var data = hashMapOf<String, String>()

    init {
        val jsonString = File("./scenario.json").readText(Charsets.UTF_8)
        val type = object : TypeToken<HashMap<String, HashMap<String, String>>>() {}.type
        data = Gson().fromJson<HashMap<String, HashMap<String, String>>>(jsonString, type)[name]!!
    }

    infix fun `get`(name: String): String {
        return data[name]!!
    }

    companion object {
        infix fun `is`(name: String): Scenario {
            return Scenario(name)
        }
    }
}
