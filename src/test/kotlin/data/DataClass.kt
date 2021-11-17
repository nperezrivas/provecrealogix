package data

import com.google.gson.JsonParser
import org.testng.Assert
import java.net.URL
import java.time.ZonedDateTime

class DataClass {


    fun getPlatesInfo(url: String): String {
        return URL(url).readText()
    }

    fun getLatestVersion(json: String, namePackage: String, keySearch1: String): String {

        val response = JsonParser.parseString(json).asJsonObject
        val packageE = response[namePackage]
        val result = packageE.asJsonObject[keySearch1]

        val baseDate = ZonedDateTime.parse("2019-05-24T15:36:39+00:00")

        var version = ""

        for ((key, value) in result.asJsonObject.entrySet()) {
            val e = value.asJsonObject["time"]

            val keyDate = ZonedDateTime.parse(e.asString)
            if (keyDate.isAfter(baseDate)) {
                version = key.toString()
            }
        }
        return version
    }

    fun keywordsAction(aJsonResponse: String, bJsonResponse: String, getPackages: Boolean) {
        val aResponse = JsonParser.parseString(aJsonResponse).asJsonObject
        val aVersions = aResponse["packages"].asJsonObject["league/plates"]

        val bResponse = JsonParser.parseString(bJsonResponse).asJsonObject
        val bVersions = bResponse["package"].asJsonObject["versions"]

        var allKey: List<String>? = null
        for ((key, aValue) in aVersions.asJsonObject.entrySet()) {
            val aKeywords = aValue.asJsonObject["keywords"].asJsonArray
            val bKeywords = bVersions.asJsonObject[key]
                .asJsonObject["keywords"]
                .asJsonArray
            if (!getPackages) {
                for (bValue in bKeywords) {
                    Assert.assertTrue(aKeywords.contains(bValue), "$key")
                }
            } else {
                if (allKey == null) {

                    allKey = aKeywords.map { keyword -> keyword.asString }
                } else {
                    aKeywords.forEach { keyword ->
                        run {
                            if (!allKey.contains(keyword.asString)) {
                                allKey += keyword.asString
                            }
                        }
                    }
                }
            }
        }
        if(allKey!=null){
            println(allKey)
        }
    }


}