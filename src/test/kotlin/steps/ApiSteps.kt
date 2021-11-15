package steps

import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import com.google.inject.Inject
import data.ApiQuery
import io.cucumber.java8.En
import io.cucumber.java8.Scenario
import org.testng.annotations.AfterSuite
import pages.LoginPage
import pages.OffersPromotionsPage
import utils.ProjectCapabilities
import java.util.stream.Collectors


class ApiSteps @Inject constructor(): En{

    var apiQuery = ApiQuery()

    init {
        Before("@CrealogixScenarioApi"){scenario: Scenario ->

        }

        After("@CrealogixScenarioApi"){scenario: Scenario ->

        }

        Given("Api call"){
            val key = "league/plates"
            var valor = apiQuery.getUserToken("https://packagist.org/p/league/plates.json")
            //print(valor)
            val json = JsonParser.parseString(valor).asJsonObject
            //val result = json.asJsonObject["packages"].asJsonObject[key]
            val builder = GsonBuilder()
           // val o = builder.create().fromJson<>()
        }


    }

}