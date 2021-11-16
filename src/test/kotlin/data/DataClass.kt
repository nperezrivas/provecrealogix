package data

import com.google.gson.JsonParser
import java.net.URL
import java.time.ZonedDateTime

class DataClass {


    fun getPlatesInfo(url: String): String {
        return URL(url).readText()
    }

    fun getLatestVersion (json : String,namePackage:String,keySearch1: String): String {

        val json = JsonParser.parseString(json).asJsonObject
        val json2 = json[namePackage]
        val json3 = json2.asJsonObject[keySearch1]

        val baseDate = ZonedDateTime.parse("2019-05-24T15:36:39+00:00")

        var version = "";

        for ((key, value) in json3.asJsonObject.entrySet()) {
            val e = value.asJsonObject["time"]

            val keyDate = ZonedDateTime.parse(e.asString)
            if (keyDate.isAfter(baseDate)) {
                version = key.toString()
            }
        }
        return version
    }
}