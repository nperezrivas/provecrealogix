package data

import com.beust.klaxon.JsonObject
import com.beust.klaxon.Klaxon
import java.net.URL

class ApiQuery {


    fun getUserToken(url: String): String {
        return URL(url).readText()
    }

}